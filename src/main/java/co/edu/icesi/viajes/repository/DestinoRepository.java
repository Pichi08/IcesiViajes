package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.dto.DestinoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DestinoRepository extends JpaRepository<Destino, Integer> {

   public List<Destino> findByCodigoAndEstado(String codigo, String estado);

   @Query(nativeQuery = true)
   public List<DestinoDTO> consultaDestinosPorTipoDestin(@Param("pNombre") String nombre);

   @Query("SELECT d FROM Destino d WHERE d.estado = 'A'")
   List<Destino> findDestinoByEstado();

    // Consultar todos los destinos activos, mostrando que tipo de destino es.




}
