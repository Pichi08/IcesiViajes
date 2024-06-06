package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.dto.PlanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    public List<Plan> findByCodigoOrderByCodigoAsc(String codigo);
    @Query(nativeQuery = true)
    public List<PlanDTO> consultarTodosPlanesImagenes();

    @Query("SELECT p.nombre, p.descripcionSolicitud FROM Plan p")
    List<String> findAllPlanNamesAndDescription();

    @Query("SELECT p FROM Plan p WHERE p.fechaInicioViaje = :fechaInicio OR p.fechaFinViaje = :fechaFin")
    List<Plan> findByFechaInicioViajeOrFechaFinViaje(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query(nativeQuery = true)
    List<PlanDTO> consultarPlanesBusqueda(@Param("nombreDestino") String nombre);

    @Query(nativeQuery = true)
    List<PlanDTO> consultarPlanesFechasBusqueda(@Param("nombreDestino") String nombre, @Param("fechaInicioViaje") Date fechaInicio, @Param("fechaFinViaje") Date fechaFin);

    @Query(nativeQuery = true)
    List<PlanDTO> consultarPlanesYPersonasBusqueda(@Param("nombreDestino") String nombre, @Param("cantidadPersonas") Integer personas);

    @Query(nativeQuery = true)
    List<PlanDTO> consultarPlanesYFechasYPersonasBusqueda(@Param("nombreDestino") String nombre, @Param("fechaInicioViaje") Date fechaInicio, @Param("fechaFinViaje") Date fechaFin, @Param("cantidadPersonas") Integer personas);

}
