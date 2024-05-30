package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.ImagenDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImagenDestinoRepository extends JpaRepository<ImagenDestino, Integer> {
    List<ImagenDestino> findByOrderByImageId();
}
