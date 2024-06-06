package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.ImagenDestino;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ImagenDestinoService extends GenericService<ImagenDestino, Integer>{
    List<ImagenDestino> findByOrderByImageId();
    List<ImagenDestino> findImagesByPlanId(@Param("idPlan") Integer idPlan);

    Optional<ImagenDestino> getOne(Integer id);



}
