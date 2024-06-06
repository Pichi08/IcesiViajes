package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.dto.PlanDTO;
import co.edu.icesi.viajes.service.PlanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
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
    public ResponseEntity<?> crear(@Valid @RequestBody Plan plan) throws Exception {
        if (plan.getUsuario() == null){
            return ResponseEntity.badRequest().body("El usuario no puede ser nulo");
        }
        else{
            Plan plan1 = planService.save(plan);
            return ResponseEntity.ok(plan1);
        }
    }

    @GetMapping("/obtenerplanesimagenes")
    public ResponseEntity<?> obtenerPlanes(){
        List<PlanDTO> lstPlan = planService.consultarTodosPlanesImagenes();
        return ResponseEntity.ok(lstPlan);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Plan plan) throws Exception {
        Plan plan1 = planService.update(plan);
        return ResponseEntity.ok(plan1);
    }

    @PostMapping("/borrar")
    public String borrar(@Valid @RequestBody Plan plan ) throws Exception {
        planService.delete(plan);
        return "Se elimino el plan";
    }

    @PostMapping("/borrarporid/{id}")
    public ResponseEntity<?> borrarPorId(@Valid @PathVariable("id") Integer id ) throws Exception {
        planService.deleteById(id);
        return ResponseEntity.ok("Se elimino el Plan correctamente");
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarPlanes() {
        List<Plan> lstPlan = planService.findAll();
        return ResponseEntity.ok(lstPlan);
    }

    @GetMapping("/consultarid/{id}")
    public ResponseEntity<?> consultarId(@Valid @PathVariable("id") Integer id) {
        Optional<Plan> plan = planService.findById(id);
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/consultarnombres")
    public ResponseEntity<?> consultarNombresPlan() {
        List<String> lstPlan = planService.findAllPlanNamesAndDescription();
        return ResponseEntity.ok(lstPlan);
    }

    @GetMapping("/consultarfechas")
    public ResponseEntity<?>  consultarFechasPlan(@Valid @RequestBody Date fechaInicio, Date fechaFin) {
        List<Plan> lstPlan = planService.findByFechaInicioViajeOrFechaFinViaje(fechaInicio, fechaFin);
        return ResponseEntity.ok(lstPlan);
    }

}
