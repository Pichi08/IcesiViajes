package co.edu.icesi.viajes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
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

}
