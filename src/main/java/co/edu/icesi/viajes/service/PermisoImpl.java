package co.edu.icesi.viajes.service;



import co.edu.icesi.viajes.dto.PermisoDTO;
import co.edu.icesi.viajes.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class PermisoImpl implements PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<PermisoService> findAll() {
        return null;
    }

    @Override
    public Optional<PermisoService> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public PermisoService save(PermisoService entity) throws Exception {
        return null;
    }

    @Override
    public PermisoService update(PermisoService entity) throws Exception {
        return null;
    }

    @Override
    public void delete(PermisoService entity) throws Exception {

    }

    @Override
    public void deleteById(Integer integer) throws Exception {

    }

    @Override
    public void validate(PermisoService entity) throws Exception {

    }

    @Override
    public Long count() {
        return null;
    }


    @Override
    public List<PermisoDTO> consultaPermisoPorRol(String nombre) {
        return permisoRepository.consultaPermisoPorRol(nombre);
    }
}
