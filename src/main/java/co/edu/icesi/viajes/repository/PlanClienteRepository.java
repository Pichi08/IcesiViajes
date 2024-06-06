package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.PlanCliente;
import co.edu.icesi.viajes.dto.PlanClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanClienteRepository extends JpaRepository<PlanCliente, Integer> {
    @Query(nativeQuery = true)
    public List<PlanClienteDTO> consultarPlanesPorCliente(@Param("pIdClie") Integer idClie);

}
