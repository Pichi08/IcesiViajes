package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.dto.ReqRes;
import co.edu.icesi.viajes.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/auth/register")
    public ResponseEntity<ReqRes> register(@Valid @RequestBody ReqRes reg){
        return ResponseEntity.ok(authenticationService.register(reg));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@Valid @RequestBody ReqRes req){
        //System.out.println(req);
        return ResponseEntity.ok(authenticationService.login(req));
    }
}
