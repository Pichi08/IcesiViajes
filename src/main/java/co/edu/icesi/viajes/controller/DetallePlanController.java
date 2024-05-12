package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.service.DetallePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleplan")
public class DetallePlanController {

    @Autowired
    private DetallePlanService detallePlanService;

    @PostMapping("/crear")
    public String crear(@RequestBody DetallePlan detallePlan ) throws Exception {
        detallePlanService.save(detallePlan);
        return "Se guardo el detalle del plan";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestBody DetallePlan detallePlan ) throws Exception {
        detallePlanService.update(detallePlan);
        return "Se actualizo el detalle del plan";
    }

    @PostMapping("/borrar")
    public String borrar(@RequestBody DetallePlan detallePlan ) throws Exception {
        detallePlanService.delete(detallePlan);
        return "Se elimino el detalle del plan";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@RequestBody Integer id ) throws Exception {
        detallePlanService.deleteById(id);
        return "Se elimino el detalle del plan";
    }

    @GetMapping("/consultar")
    public List<DetallePlan> buscarDetallePlan() {
        return detallePlanService.findAll();
    }

    @GetMapping("/consultarid")
    public Optional<DetallePlan> buscarIdDetallePlan(@RequestBody Integer id) {
        return detallePlanService.findById(id);
    }

    @GetMapping("/consultarporidplan")
    public DetallePlan buscarDetallePlanPorIdPlan(@RequestBody Integer id) {
        return detallePlanService.findByPlanId(id);
    }


}
