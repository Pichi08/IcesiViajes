package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoIdentificacion;

import java.util.List;

public interface TipoIdentificacionService extends GenericService<TipoIdentificacion, Integer>{

    public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado);

    public List<TipoIdentificacion> findByCodigoAndEstado(String codigo, String estado);

}
