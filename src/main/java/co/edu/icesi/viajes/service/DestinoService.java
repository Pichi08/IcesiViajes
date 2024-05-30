package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.dto.DestinoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DestinoService extends GenericService<Destino, Integer>{

    public List<Destino> findByCodigoAndEstado(String codigo, String estado);
    List<DestinoDTO> consultaDestinosPorTipoDestin(@Param("pNombre") String nombre);
    List<Destino> findDestinoByEstado();
    List<DestinoDTO> findName();


}
