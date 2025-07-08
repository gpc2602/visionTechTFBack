package upc.com.visiontech2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.AsignarRolesDTO;
import upc.com.visiontech2.dto.UsuarioConRolesDTO;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.serviceinterfaces.IUsersService;
import upc.com.visiontech2.serviceinterfaces.IRolService;
import upc.com.visiontech2.repositories.IUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario-roles")
public class UserRoleController {

    @Autowired
    private IUsersService uS;

    @Autowired
    private IRolService rS;
    
    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioConRolesDTO> obtenerUsuarioConRoles(@PathVariable("id") Long id) {
        try {
            Users usuario = uS.listId(id);
            if (usuario == null) {
                return ResponseEntity.notFound().build();
            }

            UsuarioConRolesDTO dto = new UsuarioConRolesDTO();
            dto.setIdUsuario(usuario.getIdUsuario());
            dto.setUsername(usuario.getUsername());
            dto.setNombre(usuario.getNombre());
            dto.setCorreoElectronico(usuario.getCorreoElectronico());
            dto.setTelefono(usuario.getTelefono());

            // Convertir roles a IDs
            List<Long> roleIds = usuario.getRoles().stream()
                    .map(role -> role.getIdRol())
                    .collect(Collectors.toList());
            dto.setRoleIds(roleIds);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/asignar")
    public ResponseEntity<String> asignarRoles(@Valid @RequestBody AsignarRolesDTO dto) {
        try {
            Users usuario = uS.listId(dto.getIdUsuario());
            if (usuario == null) {
                return ResponseEntity.notFound().build();
            }

            usuario.getRoles().clear();

            for (Long roleId : dto.getRoleIds()) {
                Role role = rS.listId(roleId);
                if (role != null) {
                    usuario.getRoles().add(role);
                }
            }

            userRepository.save(usuario);

            String mensaje = "Roles asignados correctamente!";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al asignar roles: " + e.getMessage());
        }
    }

    @GetMapping("/todos-usuarios-roles")
    public List<UsuarioConRolesDTO> listarTodosUsuariosConRoles() {
        return uS.list().stream().map(usuario -> {
            UsuarioConRolesDTO dto = new UsuarioConRolesDTO();
            dto.setIdUsuario(usuario.getIdUsuario());
            dto.setUsername(usuario.getUsername());
            dto.setNombre(usuario.getNombre());
            dto.setCorreoElectronico(usuario.getCorreoElectronico());
            dto.setTelefono(usuario.getTelefono());

            List<Long> roleIds = usuario.getRoles().stream()
                    .map(role -> role.getIdRol())
                    .collect(Collectors.toList());
            dto.setRoleIds(roleIds);

            List<String> roleNames = usuario.getRoles().stream()
                    .map(role -> role.getRol())
                    .collect(Collectors.toList());
            dto.setRoleNames(roleNames);

            return dto;
        }).collect(Collectors.toList());
    }
}
