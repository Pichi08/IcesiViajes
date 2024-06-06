package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.domain.PlanCliente;
import co.edu.icesi.viajes.dto.PlanClienteDTO;
import co.edu.icesi.viajes.repository.PlanClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Scope("singleton")
@Service
public class PlanClienteServiceImp implements PlanClienteService{

    @Autowired
    PlanClienteRepository planClienteRepository;

    @Override
    public List<PlanCliente> findAll() {
        return null;
    }

    @Override
    public Optional<PlanCliente> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public PlanCliente save(PlanCliente entity) throws Exception {
        return planClienteRepository.save(entity);
    }

    @Override
    public PlanCliente update(PlanCliente entity) throws Exception {
        return null;
    }

    @Override
    public void delete(PlanCliente entity) throws Exception {

    }

    @Override
    public void deleteById(Integer integer) throws Exception {

    }

    @Override
    public void validate(PlanCliente entity) throws Exception {

    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public List<PlanClienteDTO> consultarPlanesPorCliente(Integer idClie) {
        return planClienteRepository.consultarPlanesPorCliente(idClie);
    }
}
