package co.edu.icesi.viajes.controller;


import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.dto.ClienteDTO;
import co.edu.icesi.viajes.service.ClienteService;
import jakarta.validation.Valid;
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
    public String crear(@Valid @RequestBody Cliente cliente ) throws Exception {
        clienteService.save(cliente);
        return "Se guardo el cliente";
    }

    @PostMapping("/actualizar")
    public String actualizar(@Valid@RequestBody Cliente cliente ) throws Exception {
        clienteService.update(cliente);
        return "Se actualizo el cliente";
    }

    @PostMapping("/borrar")
    public String borrar(@Valid@RequestBody Cliente cliente ) throws Exception {
        clienteService.delete(cliente);
        return "Se elimino el cliente";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@Valid@RequestBody Integer id ) throws Exception {
        clienteService.deleteById(id);
        return "Se elimino el cliente";
    }

    @GetMapping("/consultar")
    public List<Cliente> buscarClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/consultarid")
    public Optional<Cliente> buscarIdClientes(@Valid@RequestBody Integer id) {
        return clienteService.findById(id);
    }
}
