package co.edu.icesi.viajes.domain;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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