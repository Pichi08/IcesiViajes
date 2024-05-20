package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.dto.PermisoDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermisoService extends GenericService<PermisoService, Integer>{
     List<PermisoDTO> consultaPermisoPorRol(@Param("pNombre") String nombre);

}
