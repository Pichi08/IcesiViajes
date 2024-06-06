package co.edu.icesi.viajes.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PlanClienteDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 9190232090945441762L;

    public PlanClienteDTO(Integer idPlanClie, Integer idPlan, Integer idClie, String nombre) {
        this.idPlanClie = idPlanClie;
        this.idClie = idClie;
        this.idPlan = idPlan;
        this.nombre = nombre;
    }

    private Integer idPlanClie;
    private Integer idClie;
    private Integer idPlan;
    private String nombre;



}
