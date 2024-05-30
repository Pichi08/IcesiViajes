package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.dto.DestinoDTO;
import co.edu.icesi.viajes.service.DestinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;


    @PostMapping("/crear")
    public ResponseEntity<?> crearDestino(@Valid @RequestBody Destino destino) throws Exception{
        System.out.println("ENTRO A LA API");
        Destino destino1 = destinoService.save(destino);
        return ResponseEntity.ok(destino1);
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> buscarDestino() {
        List<Destino> lstDestino = destinoService.findAll();
        return ResponseEntity.ok(lstDestino);
    }

    @GetMapping("/consultarNombre")
    public ResponseEntity<?> consultarDestinos(){
        List<DestinoDTO> lstDestino = destinoService.findName();
        return ResponseEntity.ok(lstDestino);

    }


    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdDestino(@Valid @RequestBody Integer id) {
        Optional<Destino> destino = destinoService.findById(id);
        return ResponseEntity.ok(destino);
    }
}
