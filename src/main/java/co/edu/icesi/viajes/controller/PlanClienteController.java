package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.PlanCliente;
import co.edu.icesi.viajes.dto.PlanClienteDTO;
import co.edu.icesi.viajes.service.PlanClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plancliente")
public class PlanClienteController {
    @Autowired
    private PlanClienteService planClienteService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearPlanCliente(@Valid @RequestBody PlanCliente planCliente) throws Exception{
        PlanCliente planCliente1 = planClienteService.save(planCliente);
        return ResponseEntity.ok(planCliente1);
    }

    @GetMapping("/consultarplanesscliente/{id}")
    public ResponseEntity<?> consultarPlanesPorCliente(@Valid @PathVariable("id") Integer idClie){
        List<PlanClienteDTO> planClienteDTOS= planClienteService.consultarPlanesPorCliente(idClie);
        return ResponseEntity.ok(planClienteDTOS);
    }
}
