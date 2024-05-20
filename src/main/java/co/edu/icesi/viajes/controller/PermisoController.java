package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.dto.PermisoDTO;
import co.edu.icesi.viajes.service.PermisoService;
import co.edu.icesi.viajes.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permiso")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;


    @GetMapping("/consultarNombre")
    public List<PermisoDTO> buscarDetallePlan(@Valid @RequestBody String nombre) {
        return permisoService.consultaPermisoPorRol(nombre);
    }

}
