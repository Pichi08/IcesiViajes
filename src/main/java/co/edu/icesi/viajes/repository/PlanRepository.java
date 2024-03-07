package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    public List<Plan> findByCodigoOrderByCodigoAsc(String codigo);
}
