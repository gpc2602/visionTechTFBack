package upc.com.visiontech2.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.ListarRolDTO;
import upc.com.visiontech2.dto.RolDTO;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping("/lista")
    public List<ListarRolDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ListarRolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserciones")
    public ResponseEntity<String> insert(@Valid @RequestBody RolDTO dtorol) {
        try {
            ModelMapper m = new ModelMapper();
            Role r = m.map(dtorol, Role.class);
            
            rS.insert(r);
            String mensaje = "Rol registrado correctamente: " + dtorol.getRol();
            return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el rol: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ListarRolDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        ListarRolDTO dto = m.map(rS.listId(id), ListarRolDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            Role role = rS.listId(id);
            if (role == null) {
                return ResponseEntity.notFound().build();
            }

            rS.delete(id);
            return ResponseEntity.ok("Rol eliminado correctamente (ID: " + id + ")");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el rol: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        try {
            ModelMapper m = new ModelMapper();
            Role r = m.map(dto, Role.class);
            
            rS.update(r);
            return ResponseEntity.ok("Rol actualizado correctamente (ID: " + r.getIdRol() + ")");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el rol: " + e.getMessage());
        }
    }
}