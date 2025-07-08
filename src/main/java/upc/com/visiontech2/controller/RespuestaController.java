package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.RespuestaDTO;
import upc.com.visiontech2.entities.Respuesta;
import upc.com.visiontech2.serviceinterfaces.IRespuestaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
    
    @Autowired
    private IRespuestaService rS;

    @GetMapping
    public List<RespuestaDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RespuestaDTO aDTO) {
        ModelMapper m = new ModelMapper();
        Respuesta a = m.map(aDTO, Respuesta.class);
        rS.insert(a);
    }

    @GetMapping("/{idRespuesta}")
    public RespuestaDTO listarId(@PathVariable("idRespuesta") int idRespuesta) {
        ModelMapper m = new ModelMapper();
        RespuestaDTO dto = m.map(rS.listId(idRespuesta), RespuestaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RespuestaDTO aDTO) {
        ModelMapper m = new ModelMapper();
        Respuesta a = m.map(aDTO, Respuesta.class);
        rS.update(a);
    }

    @DeleteMapping("/{idRespuesta}")
    public void eliminar(@PathVariable("idRespuesta") int idRespuesta) {
        rS.delete(idRespuesta);
    }

    @GetMapping("/respuestadespuesdefecha")
    public List<RespuestaDTO> RespuestasDespuesDeFecha(LocalDate fecha) {
        return rS.RespuestasDespuesDeFecha(fecha).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/respuestaantesdefecha")
    public List<RespuestaDTO> RespuestasAntesDeFecha(LocalDate fecha) {
        return rS.RespuestasAntesDeFecha(fecha).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidadrespuestasportema")
    public List<Object[]> CantidadRespuestasPorTema() {
        return rS.CantidadRespuestasPorTema().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, Object[].class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/temasporcantidadrespuestas")
    public List<Object[]> TemasPorCantidadDeRespuestas() {
        return rS.TemasPorCantidadDeRespuestas().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, Object[].class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/respuestasportema")
    public List<RespuestaDTO> RespuestasPorTema(int idTema) {
        return rS.RespuestasPorTema(idTema).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

}
