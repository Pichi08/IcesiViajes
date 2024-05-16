package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import co.edu.icesi.viajes.service.TipoIdentificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoidentificacion")
public class TipoIdentificacionController {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @GetMapping("/consultar")
    public List<TipoIdentificacion> buscarDetallePlan() {
        return tipoIdentificacionService.findAll();
    }

    @GetMapping("/consultarid")
    public Optional<TipoIdentificacion> buscarIdDetallePlan(@Valid @RequestBody Integer id) {
        return tipoIdentificacionService.findById(id);
    }
}
