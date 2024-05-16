package co.edu.icesi.viajes.repository;


import co.edu.icesi.viajes.domain.Permiso;

import co.edu.icesi.viajes.dto.PermisoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    @Query(nativeQuery = true)
    public List<PermisoDTO> consultaPermisoPorRol(@Param("pNombre") String nombre);

}
