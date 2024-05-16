package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.PlanCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanClienteRepository extends JpaRepository<PlanCliente, Integer> {
}
