package co.edu.icesi.viajes.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name="plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @Column(name = "codigo")
    @NotBlank(message = "Código es obligatorio")
    private String codigo;

    @Column(name = "descripcion_solicitud")
    @NotBlank(message = "Descripción de la solicitud es obligatoria")
    private String descripcionSolicitud;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Column(name = "cantidad_personas")
    @NotNull(message = "Cantidad de personas es obligatoria")
    private Integer cantidadPersonas;

    @Column(name = "fecha_solicitud")
    @NotNull(message = "Fecha de solicitud es obligatoria")
    private Date fechaSolicitud;

    @Column(name = "fecha_inicio_viaje")
    private Date fechaInicioViaje;

    @Column(name = "fecha_fin_viaje")
    private Date fechaFinViaje;

    @Column(name = "valor_total", columnDefinition = "numeric(19,2) default 0.00")
    @NotNull(message = "Valor total es obligatorio")
    private Double valorTotal;

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

    /*
    @Column(name = "id_usua")
    @NotNull(message = "ID del usuario es obligatorio")
    private Integer idUsua;
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usua")
    @NotNull
    private Usuario usuario;
}
