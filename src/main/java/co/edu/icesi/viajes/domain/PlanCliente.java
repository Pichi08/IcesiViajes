package co.edu.icesi.viajes.domain;

import co.edu.icesi.viajes.dto.PermisoDTO;
import co.edu.icesi.viajes.dto.PlanClienteDTO;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "PlanCliente.consultarPlanesPorCliente",
                query = "",
                resultSetMapping = "PlanCliente.consultarPlanesPorCliente"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "PlanCliente.consultarPlanesPorCliente",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanClienteDTO.class,
                                columns = {
                                        @ColumnResult(name = "id_plan_clie", type = Integer.class),
                                        @ColumnResult(name = "id_plan", type = Integer.class),
                                        @ColumnResult(name = "id_clie", type = Integer.class),
                                        @ColumnResult(name = "nombre",type = String.class)
                                }
                        )
                }
        )
})
@Data
@Entity
@Table(name = "plan_cliente")
public class PlanCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan_clie")
    private Integer idPlanClie;

    @Column(name = "id_plan")
    @NotNull(message = "ID del plan es obligatorio")
    private Integer idPlan;

    @Column(name = "id_clie")
    @NotNull(message = "ID del cliente es obligatorio")
    private Integer idClie;
}