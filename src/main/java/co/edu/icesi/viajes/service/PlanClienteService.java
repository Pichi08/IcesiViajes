package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.domain.PlanCliente;
import co.edu.icesi.viajes.dto.PlanClienteDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanClienteService extends GenericService<PlanCliente, Integer>{
    public List<PlanClienteDTO> consultarPlanesPorCliente(@Param("pIdClie") Integer idClie);

}
