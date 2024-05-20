package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.service.TipoDestinoService;
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
@RequestMapping("/tipodestino")
public class TipoDestinoController {

    @Autowired
    private TipoDestinoService tipoDestinoService;

    @GetMapping("/consultar")
    public ResponseEntity<?> buscarTipoDestino() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();
        return ResponseEntity.ok(lstTipoDestino);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdTipoDestino(@Valid @RequestBody Integer id) {
        Optional<TipoDestino> tipoDestino = tipoDestinoService.findById(id);
        return ResponseEntity.ok(tipoDestino);
    }

}
