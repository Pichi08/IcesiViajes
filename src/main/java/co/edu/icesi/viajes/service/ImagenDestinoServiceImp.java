package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.domain.ImagenDestino;
import co.edu.icesi.viajes.repository.ImagenDestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenDestinoServiceImp implements ImagenDestinoService{

    @Autowired
    ImagenDestinoRepository imagenDestinoRepository;

    @Override
    public List<ImagenDestino> findByOrderByImageId() {
        return imagenDestinoRepository.findByOrderByImageId();
    }

    @Override
    public List<ImagenDestino> findAll() {
        return null;
    }

    @Override
    public Optional<ImagenDestino> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public ImagenDestino save(ImagenDestino entity) throws Exception {
        return imagenDestinoRepository.save(entity);
    }

    @Override
    public ImagenDestino update(ImagenDestino entity) throws Exception {
        return null;
    }

    @Override
    public void delete(ImagenDestino entity) throws Exception {

    }

    @Override
    public void deleteById(Integer integer) throws Exception {

    }

    @Override
    public void validate(ImagenDestino entity) throws Exception {

    }

    @Override
    public Long count() {
        return null;
    }

}
