package co.edu.icesi.viajes.domain;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "tipo_destino")
public class TipoDestino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tide")
    private Integer idTide;

    @Column(name = "codigo")
    @NotBlank(message = "Código es obligatorio")
    private String codigo;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Column(name = "descripcion")
    @NotBlank(message = "Descripción es obligatoria")
    private String descripcion;

    @Column(name = "fecha_creacion")
    @NotNull(message = "Fecha de creación es obligatoria")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usu_creador")
    @NotBlank(message = "Usuario creador es obligatorio")
    private String usuCreador;

    @Column(name = "usu_modificador")
    private String usuModificador;

    @Column(name = "estado")
    @NotBlank(message = "Estado es obligatorio")
    private String estado;

    public Integer getIdTide() {
        return idTide;
    }
    public void setIdTide(Integer idTide) {
        this.idTide = idTide;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public String getUsuCreador() {
        return usuCreador;
    }
    public void setUsuCreador(String usuCreador) {
        this.usuCreador = usuCreador;
    }
    public String getUsuModificador() {
        return usuModificador;
    }
    public void setUsuModificador(String usuModificador) {
        this.usuModificador = usuModificador;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
