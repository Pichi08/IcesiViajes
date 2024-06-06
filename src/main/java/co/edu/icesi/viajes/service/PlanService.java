package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.dto.PlanDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PlanService extends GenericService<Plan, Integer>{

    public List<PlanDTO> consultarTodosPlanesImagenes();

    public List<String> findAllPlanNamesAndDescription();

    public List<Plan> findByFechaInicioViajeOrFechaFinViaje(Date fechaInicio, Date fechaFin);

    public List<PlanDTO> findByCriterios(String nombreDest, Date fechaInicio, Date fechaFin, Integer cantidadPer);

    List<PlanDTO> consultarPlanesBusqueda(@Param("nombreDestino") String nombre);

    List<PlanDTO> consultarPlanesFechasBusqueda(@Param("nombreDestino") String nombre, @Param("fechaInicioViaje") Date fechaInicio, @Param("fechaFinViaje") Date fechaFin);

    List<PlanDTO> consultarPlanesYPersonasBusqueda(@Param("nombreDestino") String nombre, @Param("cantidadPersonas") Integer personas);

    List<PlanDTO> consultarPlanesYFechasYPersonasBusqueda(@Param("nombreDestino") String nombre, @Param("fechaInicioViaje") Date fechaInicio, @Param("fechaFinViaje") Date fechaFin, @Param("cantidadPersonas") Integer personas);

}
