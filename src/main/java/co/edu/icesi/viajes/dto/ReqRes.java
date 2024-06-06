package co.edu.icesi.viajes.dto;

import co.edu.icesi.viajes.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    //private int statusCode;
    private String error;
    //private String message;
    private String token;
    private String refreshToken;
    //private String expirationTime;

    private String login;
    private String password;
    private String nombre;
    private String identificacion;
    private Date fechaCreacion;
    private String usuCreador;
    private String estado;
    private String rol;


    private Usuario usuario;
    //private List<Usuario> usuarioList;

}