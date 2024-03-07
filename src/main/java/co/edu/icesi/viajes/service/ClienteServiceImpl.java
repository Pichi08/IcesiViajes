package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import co.edu.icesi.viajes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Override
    public Cliente update(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Override
    public void delete(Cliente entity) throws Exception {
        clienteRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        clienteRepository.deleteById(id);
    }

    @Override
    public void validate(Cliente entity) throws Exception {

    }

    @Override
    public Long count() {
        return clienteRepository.count();
    }

    @Override
    public List<ClienteDTO> consultarClientesPorNombre(String nombre) {
        return clienteRepository.consultarClientesPorNombre(nombre);
    }

    @Override
    public List<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, org.springframework.data.domain.Pageable pageable) {
        return clienteRepository.findByEstadoOrderByNumeroIdentificacionAsc(estado, pageable);

    }

    @Override
    public List<Cliente> findByCorreoIgnoreCase(String correo) {
        return clienteRepository.findByCorreoIgnoreCase(correo);
    }

    @Override
    public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion) {
        return clienteRepository.findByNumeroIdentificacionLike(numeroIdentificacion);
    }

    @Override
    public List<Cliente> findByNombreLikeIgnoreCase(String nombre) {
        return clienteRepository.findByNombreLikeIgnoreCase(nombre);
    }

    @Override
    public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) {
        return clienteRepository.findByFechaNacimientoBetween(fechaInicio, fechaFin);
    }


    @Override
    public Long countByEstado(String estado) {
        return clienteRepository.countByEstado(estado);
    }

    @Override
    public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido) {
        return clienteRepository.findByPrimerApellidoAndSegundoApellido(primerApellido, segundoApellido);
    }

    @Override
    public Page<ClienteDTO> consultarPorTipoID(String codigo, Pageable pageable) {
        return clienteRepository.consultarPorTipoID(codigo, pageable);
    }

    @Override
    public List<Cliente> findBySexoOrderByFechaNacimiento(String sexo) {
        return clienteRepository.findBySexoOrderByFechaNacimiento(sexo);
    }


}
