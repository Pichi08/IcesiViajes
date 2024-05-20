package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario) throws Exception {
        Usuario usuario1 = usuarioService.save(usuario);
        return ResponseEntity.ok(usuario1);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Usuario usuario) throws Exception {
        Usuario usuario1 = usuarioService.update(usuario);
        return ResponseEntity.ok(usuario1);
    }

    @PostMapping("/borrar")
    public String borrar(@Valid @RequestBody Usuario usuario ) throws Exception {
        usuarioService.delete(usuario);
        return "Se elimino el usuario";
    }

    @PostMapping("/borrarporid")
    public String borrarPorId(@Valid @RequestBody Integer id) throws Exception {
        usuarioService.deleteById(id);
        return "Se elimino el usuario";
    }

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarUsuarios() {
        List<Usuario> lstUsuario = usuarioService.findAll();
        return ResponseEntity.ok(lstUsuario);
    }

    @GetMapping("/consultarid")
    public ResponseEntity<?> buscarIdUsuarios(@Valid @RequestBody Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

}
