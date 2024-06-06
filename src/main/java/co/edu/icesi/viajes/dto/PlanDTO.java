package co.edu.icesi.viajes.dto;

import co.edu.icesi.viajes.domain.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class PlanDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -5001962843330842387L;

    public PlanDTO(String nombre,String url,Integer idPlan) {
        this.nombre = nombre;
        this.url = url;
        this.idPlan = idPlan;
    }


    public PlanDTO(String planNombre, String destinoNombre, Date fechaInicioViaje, Date fechaFinViaje, Integer cantidadPersonas, Double valorTotal, String url) {
        this.plan_nombre = planNombre;
        this.destino_nombre = destinoNombre;
        this.fechaInicioViaje = fechaInicioViaje;
        this.fechaFinViaje = fechaFinViaje;
        this.cantidadPersonas = cantidadPersonas;
        this.valorTotal = valorTotal;
        this.url = url;
    }

    private Integer idPlan;
    private String plan_nombre;
    private String destino_nombre;
    private String url;
    private String nombre;
    private Integer cantidadPersonas;
    private Date fechaInicioViaje;
    private Date fechaFinViaje;
    private Double valorTotal;



}
