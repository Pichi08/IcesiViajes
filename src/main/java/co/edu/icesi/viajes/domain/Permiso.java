package co.edu.icesi.viajes.domain;

import co.edu.icesi.viajes.dto.DestinoDTO;
import co.edu.icesi.viajes.dto.PermisoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Permiso.consultaPermisoPorRol",
                query = "",
                resultSetMapping = "Permiso.consultaPermisoPorRol"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Permiso.consultaPermisoPorRol",
                classes = {
                        @ConstructorResult(
                                targetClass = PermisoDTO.class,
                                columns = {
                                        @ColumnResult(name = "nombre", type = String.class),
                                }
                        )
                }
        )
})




@Data
@Entity
@Table(name="permiso")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_per")
    private Integer idPer;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Column(name = "estado")
    @NotNull(message = "Estado es obligatorio")
    private String estado;

    @Column(name = "id_rol")
    @NotNull(message = "ID del rol es obligatorio")
    private Integer idRol;
}
