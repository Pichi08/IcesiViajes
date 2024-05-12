package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.DetallePlan;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DetallePlanService extends GenericService<DetallePlan, Integer>{

    DetallePlan findByPlanId(Integer idPlan);
}
