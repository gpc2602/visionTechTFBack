package upc.com.visiontech2.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.UserSecurityDTO;
import upc.com.visiontech2.dto.UsersDTO;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.repositories.IRoleRepository;
import upc.com.visiontech2.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private IUsersService uS;

    @Autowired
    private IRoleRepository roleRepository;

    @GetMapping("/lista")
    public List<UsersDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserciones")
    public ResponseEntity<String> insert(@Valid @RequestBody UserSecurityDTO dtouser) {
        try {
            ModelMapper m = new ModelMapper();
            Users u = m.map(dtouser, Users.class);

            // Gestionar roles
            if (dtouser.getRol() != null && !dtouser.getRol().isEmpty()) {
                // Si se especifican roles, usarlos
                u.getRoles().clear();
                List<Long> roleIds = dtouser.getRol().stream()
                        .map(Role::getIdRol)
                        .collect(Collectors.toList());

                List<Role> existingRoles = roleRepository.findAllById(roleIds);

                if (existingRoles.size() != roleIds.size()) {
                    throw new RuntimeException("Algunos roles no fueron encontrados");
                }

                u.getRoles().addAll(existingRoles);
            } else {
                // Si no se especifican roles, asignar ROLE_USER por defecto
                Role userRole = roleRepository.findByRol("ROLE_USER");
                if (userRole != null) {
                    u.getRoles().clear();
                    u.getRoles().add(userRole);
                } else {
                    throw new RuntimeException(
                            "Rol ROLE_USER no encontrado. Asegúrate de que los roles estén inicializados.");
                }
            }

            uS.insert(u);
            String mensaje = "Usuario registrado correctamente: " + dtouser.getNombre();
            return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el usuario: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsersDTO dto = m.map(uS.listId(id), UsersDTO.class);
        return dto;
    }

    @GetMapping(value = "/username/{username}")
    public UsersDTO buscarPorUsername(@PathVariable("username") String username) {
        ModelMapper m = new ModelMapper();
        return m.map(uS.findOneByUsername(username), UsersDTO.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            Users user = uS.listId(id.intValue());
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            uS.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente (ID: " + id + ")");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsersDTO dto) {
        try {
            Users existingUser = uS.listId(dto.getIdUsuario().longValue());
            if (existingUser == null) {
                return ResponseEntity.notFound().build();
            }

            String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
            
            boolean isAdmin = SecurityContextHolder.getContext().getAuthentication()
                    .getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
            
            boolean isEditingSelf = existingUser.getUsername().equals(currentUsername);
            
            if (!isAdmin && !isEditingSelf) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("No tiene permisos para actualizar este usuario");
            }

            uS.update(existingUser, dto);
            return ResponseEntity.ok("Usuario actualizado correctamente (ID: " + existingUser.getIdUsuario() + ")");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    @GetMapping("/activos-emergencias")
    public ResponseEntity<List<Users>> obtenerUsuariosConMuchosRegistros(@RequestParam long minCantidad) {
        List<Users> usuarios = uS.obtenerUsuariosConMuchosRegistros(minCantidad);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
}