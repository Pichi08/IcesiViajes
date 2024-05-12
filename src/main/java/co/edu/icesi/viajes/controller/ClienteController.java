package co.edu.icesi.viajes.controller;


import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.dto.ClienteDTO;
import co.edu.icesi.viajes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public String crear(@RequestBody Cliente cliente ) throws Exception {
        clienteService.save(cliente);
        return "Se guardo el cliente";
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/consultarId")
    public Optional<Cliente> buscarIdClientes(@RequestBody Integer id) {
        return clienteService.findById(id);
    }
}
