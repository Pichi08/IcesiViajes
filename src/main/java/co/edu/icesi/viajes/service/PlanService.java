package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Plan;

import java.util.Date;
import java.util.List;

public interface PlanService extends GenericService<Plan, Integer>{

    public List<String> findAllPlanNamesAndDescription();

    public List<Plan> findByFechaInicioViajeOrFechaFinViaje(Date fechaInicio, Date fechaFin);
}
