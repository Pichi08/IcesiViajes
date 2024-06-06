package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.domain.ImagenDestino;
import co.edu.icesi.viajes.service.ImagenDestinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagendestino")
public class ImagenDestinoController {

    @Autowired
    private ImagenDestinoService imagenDestinoService;

    @GetMapping("/consultarid/{id}")
    public ResponseEntity<?> buscarImagenesPorIdPlan(@Valid @PathVariable("id") Integer id) {
        List<ImagenDestino> imagenDestinoList = imagenDestinoService.findImagesByPlanId(id);
        return ResponseEntity.ok(imagenDestinoList);
    }
}
