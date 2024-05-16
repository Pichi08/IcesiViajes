package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String crear(@Valid@RequestBody Plan plan ) throws Exception {
        planService.save(plan);
        return "Se guardo el plan";
    }

    @PostMapping("/actualizar")
    public String actualizar(@Valid@RequestBody Plan plan ) throws Exception {
        planService.update(plan);
        return "Se actualizo el plan";
    }

    @PostMapping("/borrar")
    public String borrar(@Valid@RequestBody Plan plan ) throws Exception {
        planService.delete(plan);
        return "Se elimino el plan";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@Valid@RequestBody Integer id ) throws Exception {
        planService.deleteById(id);
        return "Se elimino el plan";
    }

    @GetMapping("/consultar")
    public List<Plan> consultarPlanes() {
        return planService.findAll();
    }

    @GetMapping("/consultarid")
    public Optional<Plan> consultarId(@Valid@RequestBody Integer id) {
        return planService.findById(id);
    }

    @GetMapping("/consultarnombres")
    public List<String> consultarNombresPlan() {
        return planService.findAllPlanNamesAndDescription();
    }

    @GetMapping("/consultarfechas")
    public List<Plan> consultarFechasPlan(@Valid @RequestBody Date fechaInicio, Date fechaFin) {
        return planService.findByFechaInicioViajeOrFechaFinViaje(fechaInicio, fechaFin);
    }


}
