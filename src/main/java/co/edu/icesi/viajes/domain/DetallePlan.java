package co.edu.icesi.viajes.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="detalle_plan")
public class DetallePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_depl")
    private Integer idDepl;

    @Column(name = "alimentacion")
    @NotNull(message = "Alimentación es obligatoria")
    private String alimentacion;

    @Column(name = "hospedaje")
    @NotNull(message = "Hospedaje es obligatorio")
    private String hospedaje;

    @Column(name = "transporte")
    @NotNull(message = "Transporte es obligatorio")
    private String transporte;

    @Column(name = "traslados")
    @NotNull(message = "Traslados es obligatorio")
    private String traslados;

    @Column(name = "cantidad_noches")
    @NotNull(message = "Cantidad de noches es obligatoria")
    private Integer cantidadNoches;

    @Column(name = "cantidad_dias")
    @NotNull(message = "Cantidad de días es obligatoria")
    private Integer cantidadDias;

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
    @NotNull(message = "Estado es obligatorio")
    private String estado;

    @Column(name = "id_plan")
    @NotNull(message = "ID del plan es obligatorio")
    private Integer idPlan;

    @Column(name = "id_dest")
    @NotNull(message = "ID del destino es obligatorio")
    private Integer idDest;
}
