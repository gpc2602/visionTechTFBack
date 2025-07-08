package upc.com.visiontech2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.com.visiontech2.dto.ReporteGeneralDTO;
import upc.com.visiontech2.serviceinterfaces.IReporteService;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    @Autowired
    private IReporteService reporteService;

    @GetMapping("/general")
    public ResponseEntity<ReporteGeneralDTO> obtenerReporteGeneral() {
        try {
            ReporteGeneralDTO reporte = reporteService.obtenerReporteGeneral();
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
