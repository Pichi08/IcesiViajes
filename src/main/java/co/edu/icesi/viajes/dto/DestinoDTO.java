package co.edu.icesi.viajes.dto;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class DestinoDTO implements Serializable {
    public DestinoDTO(String nombre,String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Serial
    private static final long serialVersionUID = 3544865563286917051L;

    private Integer idDest;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String tierra;
    private String aire;
    private String mar;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModificador;
    private String estado;
    private Integer idTide;
}
