package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.ImagenDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImagenDestinoRepository extends JpaRepository<ImagenDestino, Integer> {
    List<ImagenDestino> findByOrderByImageId();

    @Query("SELECT img FROM ImagenDestino img WHERE img.idPlan = :idPlan")
    List<ImagenDestino> findImagesByPlanId(@Param("idPlan") Integer idPlan);
    ImagenDestino getOne(Integer id);

}
