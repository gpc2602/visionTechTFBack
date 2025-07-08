package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.IncidenteDTO;
import upc.com.visiontech2.entities.Incidente;
import upc.com.visiontech2.serviceinterfaces.IIncidenteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/incidentes")
public class IncidenteController {

    @Autowired
    private IIncidenteService iR;

    @GetMapping("/lista")
    public List<IncidenteDTO> listar() {
        return iR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IncidenteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserciones")
    public void registrar(@RequestBody IncidenteDTO iDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Incidente i = modelMapper.map(iDTO, Incidente.class);
        iR.insert(i);
    }

    @GetMapping("/{idIncidente}")
    public IncidenteDTO listarId(@PathVariable("idIncidente") int idIncidente) {
        ModelMapper m = new ModelMapper();
        IncidenteDTO dto = m.map(iR.listId(idIncidente), IncidenteDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody IncidenteDTO iDTO) {
        ModelMapper m = new ModelMapper();
        Incidente i = m.map(iDTO, Incidente.class);
        iR.update(i);
    }

    @DeleteMapping("/{idIncidente}")
    public void eliminar(@PathVariable("idIncidente") int idIncidente) {
        iR.deleteByRutaId(idIncidente);
    }

    @GetMapping("/tipos/{tipo}")
    public List<Incidente> buscarPorTipo(@PathVariable String tipo) {
        return iR.buscarPorTipo(tipo);

    }
}
