package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.ImagenDestino;
import java.util.List;

public interface ImagenDestinoService extends GenericService<ImagenDestino, Integer>{
    List<ImagenDestino> findByOrderByImageId();

}
