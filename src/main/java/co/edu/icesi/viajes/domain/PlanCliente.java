package co.edu.icesi.viajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "plan_cliente")
public class PlanCliente {

    @Id
    @Column(name = "id_plan_clie")
    private Integer idPlanClie;

    @Column(name = "id_plan")
    private Integer idPlan;

    @Column(name = "id_clie")
    private Integer idClie;
}