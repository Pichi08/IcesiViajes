package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Integer> {

    public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado);

    public List<TipoIdentificacion> findByCodigoAndEstado(String codigo, String estado);

}
