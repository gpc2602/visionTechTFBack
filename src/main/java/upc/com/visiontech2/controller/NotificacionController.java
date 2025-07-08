package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.NotificacionDTO;
import upc.com.visiontech2.entities.Notificacion;
import upc.com.visiontech2.serviceinterfaces.INotifiacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
    
    @Autowired
    private INotifiacionService nS;

    @GetMapping
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificacionDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(nDTO, Notificacion.class);
        nS.insert(n);
    }

    @GetMapping("/{idNotificacion}")
    public NotificacionDTO listarId(@PathVariable("idNotificacion") int idNotificacion) {
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS.listId(idNotificacion), NotificacionDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody NotificacionDTO nDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(nDTO, Notificacion.class);
        nS.update(n);
    }

}
