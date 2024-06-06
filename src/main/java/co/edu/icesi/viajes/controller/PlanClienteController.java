package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.PlanCliente;
import co.edu.icesi.viajes.service.PlanClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
