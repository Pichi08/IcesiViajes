package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.dto.PlanDTO;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PlanService extends GenericService<Plan, Integer>{

    public List<PlanDTO> consultarTodosPlanesImagenes();

    public List<String> findAllPlanNamesAndDescription();

    public List<Plan> findByFechaInicioViajeOrFechaFinViaje(Date fechaInicio, Date fechaFin);

    public List<PlanDTO> findByCriterios(String nombreDest, Date fechaInicio, Date fechaFin, Integer cantidadPer);
}
