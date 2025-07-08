package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.CondicionAtmosfericaDTO;
import upc.com.visiontech2.entities.CondicionAtmosferica;
import upc.com.visiontech2.serviceinterfaces.ICondicionAtmosfericaService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/catmosferica")
public class CondicionAtmosfericaController {

    @Autowired
    private ICondicionAtmosfericaService cA;

    @GetMapping("/lista")
    public List<CondicionAtmosfericaDTO> listar() {
        return cA.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CondicionAtmosfericaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserciones")
    public void insertar(@RequestBody CondicionAtmosfericaDTO cAtmosfericasDTO) {
        ModelMapper modelMapper = new ModelMapper();
        CondicionAtmosferica ca = modelMapper.map(cAtmosfericasDTO, CondicionAtmosferica.class);
        cA.insert(ca);
    }

    @GetMapping("/{idCAtmosferica}")
    public CondicionAtmosfericaDTO listarId(@PathVariable("idCAtmosferica") int idCAtmosferica) {
        ModelMapper modelMapper = new ModelMapper();
        CondicionAtmosfericaDTO dto = modelMapper.map(cA.listId(idCAtmosferica), CondicionAtmosfericaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody CondicionAtmosfericaDTO cAtmosfericasDTO) {
        ModelMapper modelMapper = new ModelMapper();
        CondicionAtmosferica ca = modelMapper.map(cAtmosfericasDTO, CondicionAtmosferica.class);
        cA.update(ca);
    }

    @DeleteMapping("/{idCAtmosferica}")
    public void eliminar(@PathVariable("idCAtmosferica") int idCAtmosferica) {
        cA.delete(idCAtmosferica);
    }

    @GetMapping("/catmosferica_ruta/{nombreRuta}/{fechainicio}/{fechafin}")
    public List<CondicionAtmosfericaDTO> buscarPorRutaYFecha(
            @PathVariable String nombreRuta,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fechainicio,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fechafin) {

        return cA.findByNombreRutaAndFechaHoraBetween(nombreRuta, fechainicio, fechafin).stream().map(condicion -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(condicion, CondicionAtmosfericaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/ultima-condicion/{nombreRuta}")
    public ResponseEntity<CondicionAtmosfericaDTO> getUltimaCondicion(@PathVariable String nombreRuta) {
        return cA.findUltimaByNombreRuta(nombreRuta)
                .map(condicion -> {
                    ModelMapper modelMapper = new ModelMapper();
                    return ResponseEntity.ok(modelMapper.map(condicion, CondicionAtmosfericaDTO.class));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
