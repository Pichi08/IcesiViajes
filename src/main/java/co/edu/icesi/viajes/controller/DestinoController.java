package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping("/consultar")
    public ResponseEntity<?> buscarDestino() {
        List<Destino> lstDestino = destinoService.findAll();
        return ResponseEntity.ok(lstDestino);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdDestino(@RequestBody Integer id) {
        Optional<Destino> destino = destinoService.findById(id);
        return ResponseEntity.ok(destino);
    }

}
