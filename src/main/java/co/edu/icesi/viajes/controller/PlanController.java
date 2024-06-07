package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.dto.PlanDTO;
import co.edu.icesi.viajes.service.PlanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping("/consultarpornombre/{nombreDestino}")
    public ResponseEntity<?> consultarPlanesPorDestino(@PathVariable("nombreDestino") String nombreDestno){
        List<PlanDTO> lstPlans = planService.consultarPlanesBusqueda(nombreDestno);
        return ResponseEntity.ok(lstPlans);
    }
    @GetMapping("/consultarfechas/{nombreDestino}/{fechaInicioViaje}/{fechaFinViaje}")
    public ResponseEntity<?> consultarPlanesPorDestino(
            @PathVariable("nombreDestino") String nombreDestno,
            @PathVariable("fechaInicioViaje") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @PathVariable("fechaFinViaje") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){

        List<PlanDTO> lstPlans = planService.consultarPlanesFechasBusqueda(nombreDestno, fechaInicio, fechaFin);
        return ResponseEntity.ok(lstPlans);
    }
    @GetMapping("/consultardestpersonas/{nombreDestino}/{cantidadPersonas}")
    public ResponseEntity<?> consultarPlanesPorDestinoCantidadPersonas(
            @PathVariable("nombreDestino") String nombreDestino,
            @PathVariable("cantidadPersonas") Integer personas
    ){
        List<PlanDTO> lstPlans = planService.consultarPlanesYPersonasBusqueda(nombreDestino,personas);
        return ResponseEntity.ok(lstPlans);
    }

    @GetMapping("/consultartodo/{nombreDestino}/{fechaInicioViaje}/{fechaFinViaje}/{cantidadPersonas}")
    public ResponseEntity<?> consultarPlanesPorTodosCriterios(
            @PathVariable("nombreDestino") String nombreDestino,
            @PathVariable("fechaInicioViaje") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @PathVariable("fechaFinViaje") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @PathVariable("cantidadPersonas") Integer personas
    ){
        List<PlanDTO> lstPlans = planService.consultarPlanesYFechasYPersonasBusqueda(nombreDestino, fechaInicio, fechaFin, personas);
        return ResponseEntity.ok(lstPlans);
    }

    @GetMapping("/contar")
    public ResponseEntity<?> contarPlanes(){
        Long totalPlanes = planService.count();
        return ResponseEntity.ok(totalPlanes);
    }

    @GetMapping("/consultarpotencial")
    public ResponseEntity<?> potencialAsesores(){
        List<PlanDTO> lstAsesores = planService.consultarPotencialAsesores();
        return ResponseEntity.ok(lstAsesores);
    }

    @GetMapping("/consultartotalventas")
    public ResponseEntity<?> totalVentas(){
        PlanDTO totalVentas = planService.consultarTotalVentas();
        return ResponseEntity.ok(totalVentas);
    }

    @GetMapping("/consultarventasreales")
    public ResponseEntity<?> ventasReales(){
        PlanDTO ventasReales = planService.consultarVentasReales();
        return ResponseEntity.ok(ventasReales);
    }


}
