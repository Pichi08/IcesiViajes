package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.service.PlanService;
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
    public String crear(@RequestBody Plan plan ) throws Exception {
        planService.save(plan);
        return "Se guardo el plan";
    }

    @GetMapping("/consultar")
    public List<Plan> consultarPlanes() {
        return planService.findAll();
    }

    @GetMapping("/consultarId")
    public Optional<Plan> consultarId(@RequestBody Integer id) {
        return planService.findById(id);
    }

    @GetMapping("/consultarNombres")
    public List<String> consultarNombresPlan() {
        return planService.findAllPlanNamesAndDescription();
    }

    @GetMapping("/consultarFechas")
    public List<Plan> consultarFechasPlan(@RequestBody Date fechaInicio, Date fechaFin) {
        return planService.findByFechaInicioViajeOrFechaFinViaje(fechaInicio, fechaFin);
    }


}
