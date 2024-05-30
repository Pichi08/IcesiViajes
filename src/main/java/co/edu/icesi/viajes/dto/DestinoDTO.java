package co.edu.icesi.viajes.dto;

import co.edu.icesi.viajes.domain.TipoDestino;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class DestinoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2787281453303120829L;

    public DestinoDTO(Integer idDest, String codigo, String nombre, String descripcion, Date fechaCreacion, Date fechaModificacion, String usuCreador, String usuModificador, String estado) {
        this.idDest = idDest;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.estado = estado;
    }

    private Integer idDest;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModificador;
    private String estado;
    private TipoDestino tipoDestino;


}
