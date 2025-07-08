package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.TemaForoDTO;
import upc.com.visiontech2.dto.ErrorResponse;
import upc.com.visiontech2.entities.TemaForo;
import upc.com.visiontech2.serviceinterfaces.ITemaForoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/temaforo")
public class TemaForoController {

    @Autowired
    private ITemaForoService tS;

    @GetMapping
    public List<TemaForoDTO> listar() {
        return tS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TemaForoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody TemaForoDTO aDTO) {
        ModelMapper m = new ModelMapper();
        TemaForo a = m.map(aDTO, TemaForo.class);
        tS.insert(a);
    }

    @GetMapping("/{idTemaForo}")
    public TemaForoDTO listarId(@PathVariable("idTemaForo") int idTemaForo) {
        ModelMapper m = new ModelMapper();
        TemaForoDTO dto = m.map(tS.listId(idTemaForo), TemaForoDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody TemaForoDTO aDTO) {
        ModelMapper m = new ModelMapper();
        TemaForo a = m.map(aDTO, TemaForo.class);
        tS.update(a);
    }

    @DeleteMapping("/{idTemaForo}")
    public ResponseEntity<Object> eliminar(@PathVariable("idTemaForo") int idTemaForo) {
        try {
            tS.delete(idTemaForo);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            // Crear un objeto JSON con el mensaje de error
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/temadespuesdefecha")
    public List<TemaForoDTO> TemasDespuesDeFecha(LocalDate fecha) {
        return tS.TemasDespuesDeFecha(fecha).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, TemaForoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/temaantesdefecha")
    public List<TemaForoDTO> TemasAntesDeFecha(LocalDate fecha) {
        return tS.TemasAntesDeFecha(fecha).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, TemaForoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/temascerrados")
    public List<TemaForoDTO> TemasCerrados() {
        return tS.TemasCerrados().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, TemaForoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/temasporusuario")
    public List<TemaForoDTO> TemasPorUsuario(int idUsuario) {
        return tS.TemasPorUsuario(idUsuario).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, TemaForoDTO.class);
        }).collect(Collectors.toList());
    }

}
