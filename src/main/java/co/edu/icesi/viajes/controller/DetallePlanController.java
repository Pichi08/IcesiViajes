package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.service.DetallePlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleplan")
public class DetallePlanController {

    @Autowired
    private DetallePlanService detallePlanService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody DetallePlan detallePlan) throws Exception {
        DetallePlan detallePlan1 = detallePlanService.save(detallePlan);
        return ResponseEntity.ok(detallePlan1);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@Valid @RequestBody DetallePlan detallePlan) throws Exception {
        DetallePlan detallePlan1 = detallePlanService.update(detallePlan);
        return ResponseEntity.ok(detallePlan1);
    }

    @PostMapping("/borrar")
    public String borrar(@Valid @RequestBody DetallePlan detallePlan ) throws Exception {
        detallePlanService.delete(detallePlan);
        return "Se elimino el detalle del plan";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@Valid @RequestBody Integer id ) throws Exception {
        detallePlanService.deleteById(id);
        return "Se elimino el detalle del plan";
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> buscarDetallePlan() {
        List<DetallePlan> lstDetallePlan = detallePlanService.findAll();
        return ResponseEntity.ok(lstDetallePlan);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdDetallePlan(@Valid @RequestBody Integer id) {
        Optional<DetallePlan> detallePlan = detallePlanService.findById(id);
        return ResponseEntity.ok(detallePlan);
    }

    @GetMapping("/consultarporidplan")
    public ResponseEntity<?> buscarDetallePlanPorIdPlan(@Valid @RequestBody Integer id) {
        DetallePlan detallePlan = detallePlanService.findByPlanId(id);
        return ResponseEntity.ok(detallePlan);

    }
}
