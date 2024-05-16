package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.service.UsuarioService;
import jakarta.validation.Valid;
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
    public String crear(@Valid@RequestBody Usuario usuario ) throws Exception {
        usuarioService.save(usuario);
        return "Se guardo el usuario";
    }

    @PostMapping("/actualizar")
    public String actualizar(@Valid@RequestBody Usuario usuario ) throws Exception {
        usuarioService.update(usuario);
        return "Se actualizo el usuario";
    }

    @PostMapping("/borrar")
    public String borrar(@Valid@RequestBody Usuario usuario ) throws Exception {
        usuarioService.delete(usuario);
        return "Se elimino el usuario";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@Valid@RequestBody Integer id ) throws Exception {
        usuarioService.deleteById(id);
        return "Se elimino el usuario";
    }

    @GetMapping("/consultar")
    public List<Usuario> consultarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/consultarid")
    public Optional<Usuario> buscarIdUsuarios(@Valid @RequestBody Integer id) {
        return usuarioService.findById(id);
    }

}
