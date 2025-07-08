package upc.com.visiontech2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.CaloriasTotalesPorRutaDTO;
import upc.com.visiontech2.dto.MetricaDTO;
import upc.com.visiontech2.entities.Metrica;
import upc.com.visiontech2.serviceinterfaces.IMetricaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metricas")
public class MetricaController {

    @Autowired
    private IMetricaService mS;

    @GetMapping("/lista")
    public List<MetricaDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MetricaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserciones")
    public void insertar(@RequestBody MetricaDTO mDto) {
        ModelMapper modelMapper = new ModelMapper();
        Metrica m = modelMapper.map(mDto, Metrica.class);
        mS.insert(m);
    }

    @PutMapping
    public void modificar(@RequestBody MetricaDTO mDto) {
        ModelMapper modelMapper = new ModelMapper();
        Metrica m = modelMapper.map(mDto, Metrica.class);
        mS.update(m);
    }

    @DeleteMapping("/{idMetrica}")
    public void eliminar(@PathVariable("idMetrica") int idMetrica) {
        mS.delete(idMetrica);
    }

    @GetMapping("buscar_metrica_ruta/{nombreRuta}")
    public List<MetricaDTO> buscarPorRuta(@PathVariable String nombreRuta) {
        return mS.listByNombreRuta(nombreRuta).stream().map(metrica -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(metrica, MetricaDTO.class);
        })
                .collect(Collectors.toList());
    }

    @GetMapping("/total-calorias/{nombreRuta}")

    public CaloriasTotalesPorRutaDTO getTotalCaloriasExactas(@PathVariable String nombreRuta) {
        int total = mS.sumCaloriasByNombreRuta(nombreRuta);
        return new CaloriasTotalesPorRutaDTO(total);
    }

    @GetMapping("/{idMetrica}")
    public MetricaDTO listarId(@PathVariable("idMetrica") int idMetrica) {
        ModelMapper m = new ModelMapper();
        MetricaDTO dto = m.map(mS.listId(idMetrica), MetricaDTO.class);
        return dto;
    }
}
