package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorLogin(@RequestParam String login){
        return ResponseEntity.ok(usuarioService.findUsuarioByLogin(login));
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
