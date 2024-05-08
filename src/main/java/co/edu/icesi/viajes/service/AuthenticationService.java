package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.config.jwt.JWTUtils;
import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.dto.ReqRes;
import co.edu.icesi.viajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public ReqRes register(ReqRes registrationRequest){
        ReqRes resp = new ReqRes();
        //System.out.println(registrationRequest.getRol() + registrationRequest.getLogin() + registrationRequest.getNombre());
        try {
            // Verificar si el nombre de usuario ya existe
            if (usuarioRepository.existsUsuarioByLogin(registrationRequest.getLogin())) {
                resp.setError("El nombre de usuario ya está en uso.");
                return resp;
            }

            Usuario usuario = new Usuario();
            usuario.setLogin(registrationRequest.getLogin());
            usuario.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            usuario.setNombre(registrationRequest.getNombre());
            usuario.setIdentificacion(registrationRequest.getIdentificacion());
            String tipoRol = registrationRequest.getRol();

            if (tipoRol.equals("ADMIN")){
                usuario.setId_rol(1);
            } else if (tipoRol.equals("ASESOR")){
                usuario.setId_rol(2);
            } else if (tipoRol.equals("VIEWER")){
                usuario.setId_rol(3);
            }


            /*
            Rol rol = new Rol();
            rol.setNombre(registrationRequest.getRol());
            usuario.setRol(rol);
             */

            Usuario usuarioResult = usuarioRepository.save(usuario);

            if (usuarioResult.getIdUsua()>0) {
                resp.setUsuario((usuarioResult));
                //resp.setMessage("User Saved Successfully");
                //resp.setStatusCode(200);
            }

        }catch (Exception e){
            //resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }



    public ReqRes login(ReqRes loginRequest){
        ReqRes response = new ReqRes();
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getLogin(),
                            loginRequest.getPassword()));
            var user = usuarioRepository.findByLogin(loginRequest.getLogin()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            //response.setStatusCode(200);
            response.setToken(jwt);
            //response.setRol(user);
            response.setRefreshToken(refreshToken);
            //response.setExpirationTime("24Hrs");
            //response.setMessage("Successfully Logged In");

        }catch (Exception e){
            //response.setStatusCode(500);
            //response.setMessage(e.getMessage());
        }
        return response;
    }





    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
            Usuario users = usuarioRepository.findByLogin(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                //response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                //response.setExpirationTime("24Hr");
                //response.setMessage("Successfully Refreshed Token");
            }
            //response.setStatusCode(200);
            return response;

        }catch (Exception e){
            //response.setStatusCode(500);
            //response.setMessage(e.getMessage());
            return response;
        }
    }
}
