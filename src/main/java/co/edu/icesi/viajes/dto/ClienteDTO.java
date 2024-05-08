package co.edu.icesi.viajes.dto;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ClienteDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6733906714888102899L;

    public ClienteDTO(String numeroIdentificacion, String primerApellido, String segundoApellido, String nombre, String estado, Integer idTiid) {
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

    public ClienteDTO(String cliente_nombre, String alimentacion, String hospedaje, String transporte, String plan_codigo, String plan_descripcion) {
        this.cliente_nombre = cliente_nombre;
        this.alimentacion = alimentacion;
        this.hospedaje = hospedaje;
        this.transporte = transporte;
        this.plan_codigo = plan_codigo;
        this.plan_descripcion = plan_descripcion;
    }
    
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
    private String cliente_nombre;
    private String alimentacion;
    private String hospedaje;
    private String transporte;
    private String plan_codigo;
    private String plan_descripcion;
}

