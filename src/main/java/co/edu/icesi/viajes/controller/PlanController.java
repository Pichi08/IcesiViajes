package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Plan plan) throws Exception {
        Plan plan1 = planService.save(plan);
        return ResponseEntity.ok(plan1);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Plan plan) throws Exception {
        Plan plan1 = planService.update(plan);
        return ResponseEntity.ok(plan1);
    }

    @PostMapping("/borrar")
    public String borrar(@RequestBody Plan plan) throws Exception {
        planService.delete(plan);
        return "Se elimino el plan";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@RequestBody Integer id) throws Exception {
        planService.deleteById(id);
        return "Se elimino el plan";
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarPlanes() {
        List<Plan> lstPlan = planService.findAll();
        return ResponseEntity.ok(lstPlan);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> consultarId(@RequestBody Integer id) {
        Optional<Plan> plan = planService.findById(id);
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/consultarnombres")
    public ResponseEntity<?> consultarNombresPlan() {
        List<String> lstPlan = planService.findAllPlanNamesAndDescription();
        return ResponseEntity.ok(lstPlan);
    }

    @GetMapping("/consultarfechas")
    public ResponseEntity<?>  consultarFechasPlan(@RequestBody Date fechaInicio, Date fechaFin) {
        List<Plan> lstPlan = planService.findByFechaInicioViajeOrFechaFinViaje(fechaInicio, fechaFin);
        return ResponseEntity.ok(lstPlan);
    }


}
