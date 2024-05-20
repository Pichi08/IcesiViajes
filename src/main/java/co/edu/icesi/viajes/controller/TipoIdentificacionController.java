package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import co.edu.icesi.viajes.service.TipoIdentificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> buscarTipoIde() {
        List<TipoIdentificacion> lstTipoIde = tipoIdentificacionService.findAll();
        return ResponseEntity.ok(lstTipoIde);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdTipoIde(@Valid @RequestBody Integer id) {
        Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionService.findById(id);
        return ResponseEntity.ok(tipoIdentificacion);
    }
}
