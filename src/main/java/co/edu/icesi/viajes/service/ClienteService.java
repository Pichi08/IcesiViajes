package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ClienteService extends GenericService<Cliente, Integer>{
    List<ClienteDTO> consultarClientesPorNombre(@Param("pNombre") String nombre);
    public List<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable);
    public List<Cliente> findByCorreoIgnoreCase(String correo);
    public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion);
    public List<Cliente> findByNombreLikeIgnoreCase(String nombre);
    public List<Cliente> findByFechaCreacionBetween(Date fechaInicio, Date fechaFin);
    public Long countByEstado(String estado);
    public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido);
    Page<ClienteDTO> consultarPorTipoID(@Param("pCodigo") String codigo, Pageable pageable);

}
