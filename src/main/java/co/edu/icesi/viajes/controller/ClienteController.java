package co.edu.icesi.viajes.controller;


import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) throws Exception {
        Cliente client = clienteService.save(cliente);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Cliente cliente) throws Exception {
        Cliente client = clienteService.update(cliente);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/borrar")
    public String borrar(@RequestBody Cliente cliente) throws Exception {
        clienteService.delete(cliente);
        return "Se elimino el cliente";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@RequestBody Integer id) throws Exception {
        clienteService.deleteById(id);
        return "Se elimino el cliente";
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> buscarClientes() {
        List<Cliente> lstClientes = clienteService.findAll();
        return ResponseEntity.ok(lstClientes);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdClientes(@RequestBody Integer id) {
        Optional<Cliente> client = clienteService.findById(id);
        return ResponseEntity.ok(client);
    }
}
