package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/consultarNombres")
    public List<String> consultarNombres() {
        return planService.findAllPlanNamesAndDescription();
    }
}
