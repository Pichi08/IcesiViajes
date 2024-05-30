package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoDestino;

import java.util.List;

public interface TipoDestinoService extends GenericService<TipoDestino, Integer> {

    public TipoDestino findByIdTide(Integer id);
    public List<TipoDestino> findByCodigo(String codigo);
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado);
    public List<TipoDestino> findByOrderByNombreAsc();
}
