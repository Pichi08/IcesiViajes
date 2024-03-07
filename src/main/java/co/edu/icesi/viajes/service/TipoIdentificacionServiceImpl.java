package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import co.edu.icesi.viajes.repository.TipoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService{

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    @Override
    public List<TipoIdentificacion> findAll() {
        return tipoIdentificacionRepository.findAll();
    }

    @Override
    public Optional<TipoIdentificacion> findById(Integer integer) {
        return tipoIdentificacionRepository.findById(integer);
    }

    @Override
    public TipoIdentificacion save(TipoIdentificacion entity) throws Exception {
        return tipoIdentificacionRepository.save(entity);
    }

    @Override
    public TipoIdentificacion update(TipoIdentificacion entity) throws Exception {
        return tipoIdentificacionRepository.save(entity);
    }

    @Override
    public void delete(TipoIdentificacion entity) throws Exception {
        tipoIdentificacionRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        tipoIdentificacionRepository.deleteById(integer);
    }

    @Override
    public void validate(TipoIdentificacion entity) throws Exception {

    }

    @Override
    public Long count() {
        return tipoIdentificacionRepository.count();
    }

    @Override
    public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) {
        return tipoIdentificacionRepository.findByEstadoOrderByNombreAsc(estado);
    }

    @Override
    public List<TipoIdentificacion> findByCodigoAndEstado(String codigo, String estado) {
        return tipoIdentificacionRepository.findByCodigoAndEstado(codigo, estado);
    }
}
