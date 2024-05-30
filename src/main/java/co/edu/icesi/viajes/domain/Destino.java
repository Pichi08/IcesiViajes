package co.edu.icesi.viajes.domain;
import co.edu.icesi.viajes.dto.DestinoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;


@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Destino.consultaDestinosPorTipoDestin",
                query = "",
                resultSetMapping = "Destino.consultaDestinosPorTipoDestin"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Destino.consultaDestinosPorTipoDestin",
                classes = {
                        @ConstructorResult(
                                targetClass = DestinoDTO.class,
                                columns = {
                                        @ColumnResult(name = "nombreDestin", type = String.class),
                                        @ColumnResult(name = "descripcion", type = String.class),
                                }
                        )
                }
        )
})
@Data
@Entity
@Table(name = "destino")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dest")
    private Integer idDest;

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
    @NotNull(message = "Estado es obligatorio")
    private String estado;

    /*
    @Column(name = "id_tide")
    @NotNull(message = "ID de tipo de destino es obligatorio")
    private Integer idTide;
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tide")
    @NotNull
    private TipoDestino tipoDestino;
}
