package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.TipoDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Integer> {

    public TipoDestino findByIdTide(Integer id);
    public List<TipoDestino> findByCodigo(String codigo);
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado);

    //El ?1 significa que el primer parametro que se le pase a la funcion sera el primer parametro de la query
    //Y el ?2 significa que el segundo parametro que se le pase a la funcion sera el segundo parametro de la query
    //Esto se hace para evitar inyecciones SQL
    //@Query("select tp from TipoDestino where  tp.codigo = ?1 and tp.estado = ?2")
    //public List<TipoDestino> findByCodigoAndEstadoJPQL(String codigo, String estado);

    public List<TipoDestino> findByCodigoOrderByCodigoAsc(String codigo);

    public List<TipoDestino> findByOrderByNombreAsc();

}
