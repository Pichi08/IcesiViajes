package co.edu.icesi.viajes.domain;
import co.edu.icesi.viajes.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@NamedNativeQueries({
        @NamedNativeQuery( name = "Cliente.consultarClientesPorNombre",
                query = "",
                resultSetMapping = "Cliente.consultarClientesPorNombre"
        ),
        @NamedNativeQuery( name = "Cliente.consultarPorTipoID",
                query = "",
                resultSetMapping = "Cliente.consultarPorTipoID"
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Cliente.consultarClientesPorNombre",
                classes = { @ConstructorResult(targetClass = ClienteDTO.class,
                        columns = {
                                @ColumnResult(name = "numero_identificacion", type = String.class),
                                @ColumnResult(name = "primer_apellido", type = String.class),
                                @ColumnResult(name = "segundo_apellido", type = String.class),
                                @ColumnResult(name = "nombre", type = String.class),
                                @ColumnResult(name = "estado", type = String.class),
                                @ColumnResult(name = "id_tiid", type = Integer.class),
                        })

                }
        ),
        @SqlResultSetMapping(
                name = "Cliente.consultarPorTipoID",
                classes = { @ConstructorResult(targetClass = ClienteDTO.class,
                        columns = {
                                @ColumnResult(name = "id_clie", type = Integer.class),
                                @ColumnResult(name = "numero_identificacion", type = String.class),
                                @ColumnResult(name = "nombre", type = String.class),
                                @ColumnResult(name = "primer_apellido", type = String.class),
                                @ColumnResult(name = "nombreID", type = String.class),
                        })

                }
        )

})

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id_clie")
    private Integer idClie;
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "correo")
    private String correo;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
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
    @Column(name = "id_tiid")
    private Integer idTiid;


}
