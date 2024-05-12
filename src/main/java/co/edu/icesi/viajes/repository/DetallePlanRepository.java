package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.DetallePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetallePlanRepository extends JpaRepository<DetallePlan, Integer> {

    @Query("SELECT dp FROM DetallePlan dp WHERE dp.idPlan = :idPlan")
    DetallePlan findByPlanId(@Param("idPlan") Integer idPlan);
}
