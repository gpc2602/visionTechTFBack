package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.ContactoEmergenciaDTO;
import upc.com.visiontech2.dto.ContactoEmergenciaRPDTO;
import upc.com.visiontech2.entities.ContactoEmergencia;
import upc.com.visiontech2.serviceinterfaces.IContactoEmergenciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contactoemergencia")
public class ContactoEmergenciaController {

    @Autowired
    private IContactoEmergenciaService cS;

    @GetMapping
    public List<ContactoEmergenciaDTO> listar() {
        return cS.list().stream().map(contacto -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(contacto, ContactoEmergenciaDTO.class);
        })
                .collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody ContactoEmergenciaDTO contactoEmergenciaDTO) {
        ModelMapper m = new ModelMapper();
        ContactoEmergencia contacto = m.map(contactoEmergenciaDTO, ContactoEmergencia.class);
        cS.insert(contacto);
    }

    @GetMapping("/{idContactoEmergencia}")
    public ContactoEmergenciaDTO listId(@PathVariable("idContactoEmergencia") int idContactoEmergencia) {
        ModelMapper modelMapper = new ModelMapper();
        ContactoEmergenciaDTO dto = modelMapper.map(cS.listId(idContactoEmergencia), ContactoEmergenciaDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody ContactoEmergenciaRPDTO contactoEmergenciaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ContactoEmergencia contacto = modelMapper.map(contactoEmergenciaDTO, ContactoEmergencia.class);
        cS.update(contacto);
    }

    @DeleteMapping("/{idContactoEmergencia}")
    public void delete(@PathVariable("idContactoEmergencia") int idContactoEmergencia) {
        cS.delete(idContactoEmergencia);
    }

    @GetMapping("/contactosemergencia-por-usuario/{idUsuario}/contactos")
    public List<ContactoEmergenciaDTO> listarPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return cS.obtenerContactosEmergenciaUsuario(idUsuario).stream()
                .map(contacto -> {
                    ModelMapper modelMapper = new ModelMapper();
                    return modelMapper.map(contacto, ContactoEmergenciaDTO.class);
                })
                .collect(Collectors.toList());
    }
}
