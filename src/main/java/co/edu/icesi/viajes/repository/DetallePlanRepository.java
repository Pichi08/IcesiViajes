package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.DetallePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePlanRepository extends JpaRepository<DetallePlan, Integer> {

    //public List<DetallePlan> findByCodigoOrderByCodigoAsc(String codigo);
}
