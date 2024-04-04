package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.dto.DestinoDTO;
import co.edu.icesi.viajes.repository.DestinoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }

    @Override
    public Optional<Destino> findById(Integer id) {
        return destinoRepository.findById(id);
    }

    @Override
    public Destino save(Destino entity) throws Exception {
        return destinoRepository.save(entity);
    }

    @Override
    public Destino update(Destino entity) throws Exception {
        return destinoRepository.save(entity);
    }

    @Override
    public void delete(Destino entity) throws Exception {
        destinoRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        destinoRepository.deleteById(integer);
    }

    @Override
    public void validate(Destino entity) throws Exception {

    }

    @Override
    public Long count() {
        return destinoRepository.count();
    }

    @Override
    public List<Destino> findByCodigoAndEstado(String codigo, String estado) {
        return destinoRepository.findByCodigoAndEstado(codigo, estado);
    }

    @Override
    public List<DestinoDTO> consultaDestinosPorTipoDestin(String nombre) {
        return destinoRepository.consultaDestinosPorTipoDestin(nombre);
    }

    @Override
    public List<Destino> findDestinoByEstado() {
        return destinoRepository.findDestinoByEstado();
    }
}
