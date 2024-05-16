package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.domain.ImagenDestino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenDestinoRepository extends JpaRepository<ImagenDestino, Integer> {
}
