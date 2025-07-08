package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.RecomendacionDTO;
import upc.com.visiontech2.entities.Recomendacion;
import upc.com.visiontech2.serviceinterfaces.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {
    
    @Autowired
    private IRecomendacionService rS;

    @GetMapping("/lista")
    public List<RecomendacionDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserciones")
    public void registrar(@RequestBody RecomendacionDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Recomendacion r = m.map(rDTO, Recomendacion.class);
        rS.insert(r);
    }

    @GetMapping("/{idRecomendacion}")
    public RecomendacionDTO listarId(@PathVariable("idRecomendacion") int idRecomendacion) {
        ModelMapper m = new ModelMapper();
        RecomendacionDTO dto = m.map(rS.listId(idRecomendacion), RecomendacionDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RecomendacionDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Recomendacion r = m.map(rDTO, Recomendacion.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRecomendacion}")
    public void eliminar(@PathVariable("idRecomendacion") int idRecomendacion) {
        rS.delete(idRecomendacion);
    }

    @GetMapping("/busquedas")
    public List<RecomendacionDTO> buscar(@RequestParam String c) {
        return rS.buscarPorComentario(c).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/promedio/{idRuta}")
    public double obtenerPromedio(@PathVariable int idRecomendacion) {
        return rS.obtenerPromedioPuntuacion(idRecomendacion);
    }
}
