package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public List<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable);

    public List<Cliente> findByCorreoIgnoreCase(String correo);

    public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion);

    public List<Cliente> findByNombreLikeIgnoreCase(String nombre);

    public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin);

    public Long countByEstado(String estado);

    //  Consultar clientes por tipo de identificación. Debe de ser paginado
    public List<Cliente> findByIdTiid(int tipoIdentificacion);

    public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido);

    //Consultar todos los clientes con los siguientes filtros: Estado, número identificación, tipo de identificación, nombre (con Like) en orden ascendente. (debe de ser una sola consulta y los filtros pueden ser opcionales).
    //public List<Cliente> findByEstadoAndNumeroIdentificacionAndTipoIdentificacionAndNombreLikeOrderByNombreAsc(String estado, String numeroIdentificacion, String tipoIdentificacion, String nombre);

    @Query(nativeQuery = true)
    List<ClienteDTO> consultarClientesPorNombre(@Param("pNombre") String nombre);

    @Query(nativeQuery = true)
    Page<ClienteDTO> consultarPorTipoID(@Param("pCodigo") String codigo, Pageable pageable);

    List<Cliente> findBySexoOrderByFechaNacimiento(String sexo);

    @Query(nativeQuery = true)
    List<ClienteDTO> consultarPlanYDetallePlan(@Param("pNombre") String nombre);

    Optional<Cliente> findByNumeroIdentificacion(String numeroId);
}
