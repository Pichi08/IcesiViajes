package co.edu.icesi.viajes.dto;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class DestinoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2787281453303120829L;

    public DestinoDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

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
