package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/asesor")
    //@PreAuthorize("hasRole('USER')")
    public String messageUser(){
        return "Vista Asesor";
    }

    @GetMapping("/admin")
    //@PreAuthorize("hasRole('ADMIN')")
    public String messageAdmin(){
        return "Vista Admin";
    }

    @GetMapping("/helloSecured")
    public String secureEndPoint(){
        return "End Point protegido, unicmanete ingresan autorizados";
    }

    @PostMapping("/crear")
    public String crear(@RequestBody Usuario usuario ) throws Exception {
        usuarioService.save(usuario);
        return "Se guardo el usuario";
    }

    @GetMapping("/consultar")
    public List<Usuario> consultarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/consultarId")
    public Optional<Usuario> buscarIdUsuarios(@RequestBody Integer id) {
        return usuarioService.findById(id);
    }

}
