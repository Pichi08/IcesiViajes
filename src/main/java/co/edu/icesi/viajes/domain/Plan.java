package co.edu.icesi.viajes.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name="plan")
public class Plan {
    @Id
    @Column(name = "id_plan")
    private Integer idPlan;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion_solicitud")
    private String descripcionSolicitud;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;

    @Column(name = "fecha_inicio_viaje")
    private Date fechaInicioViaje;

    @Column(name = "fecha_fin_viaje")
    private Date fechaFinViaje;

    @Column(name = "valor_total", columnDefinition = "numeric(19,2) default 0.00")
    private Double valorTotal;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usu_creador")
    private String usuCreador;

    @Column(name = "usu_modificador")
    private String usuModificador;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_clie")
    private Integer idClie;

    @Column(name = "id_usua")
    private Integer idUsua;
}
