package co.edu.icesi.viajes.domain;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
@Data
@Entity
@Table(name="tipo_identificacion")
public class TipoIdentificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiid")
    private Integer idTiid;

    @Column(name = "codigo")
    @NotBlank(message = "Código es obligatorio")
    private String codigo;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

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
}
