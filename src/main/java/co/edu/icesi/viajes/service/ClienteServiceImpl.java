package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import co.edu.icesi.viajes.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

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
        Optional<Cliente> cliente = clienteRepository.findById(entity.getIdClie());
        if(cliente.isPresent()){
            Cliente cliente1 = cliente.get();
            cliente1.setNumeroIdentificacion(entity.getNumeroIdentificacion());
            cliente1.setPrimerApellido(entity.getPrimerApellido());
            cliente1.setSegundoApellido(entity.getSegundoApellido());
            cliente1.setNombre(entity.getNombre());
            cliente1.setTelefono1(entity.getTelefono1());
            cliente1.setTelefono2(entity.getTelefono2());
            cliente1.setCorreo(entity.getCorreo());
            cliente1.setSexo(entity.getSexo());
            cliente1.setFechaNacimiento(entity.getFechaNacimiento());
            cliente1.setIdTiid(entity.getIdTiid());
            cliente1.setFechaModificacion(entity.getFechaModificacion());
            cliente1.setUsuModificador(entity.getUsuModificador());

        }
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

    @Override
    public List<ClienteDTO> consultarPlanYDetallePlan(String nombre) {
        return clienteRepository.consultarPlanYDetallePlan(nombre);
    }


}
