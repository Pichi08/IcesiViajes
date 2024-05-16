package co.edu.icesi.viajes.domain;

import co.edu.icesi.viajes.dto.DestinoDTO;
import co.edu.icesi.viajes.dto.PermisoDTO;
import jakarta.persistence.*;
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
    @Column(name = "id_per")
    private Integer id_per;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_rol")
    private Integer id_rol;
}
