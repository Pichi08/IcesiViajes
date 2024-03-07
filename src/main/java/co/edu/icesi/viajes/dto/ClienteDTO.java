package co.edu.icesi.viajes.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ClienteDTO implements Serializable {

    public ClienteDTO(String numeroIdentificacion,String primerApellido, String segundoApellido,String nombre,String estado,Integer idTiid) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombre = nombre;
        this.estado = estado;
        this.idTiid = idTiid;
    }

    public ClienteDTO(Integer idClie, String numeroIdentificacion, String nombre, String primerApellido, String nombreID) {
        this.idClie = idClie;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.nombreID = nombreID;
    }

    @Serial
    private static final long serialVersionUID = 8460626525156785057L;

    private Integer idClie;
    private String numeroIdentificacion;
    private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String telefono1;
    private String telefono2;
    private String correo;
    private String sexo;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModificador;
    private String estado;
    private Integer idTiid;
    private String nombreID;
}
