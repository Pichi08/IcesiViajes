package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TipoIdentificacionTest {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;


    @Test
    public void encontrarPorEstado() {
        List<TipoIdentificacion> tipoIdentificaciones = tipoIdentificacionService.findByEstadoOrderByNombreAsc("A");
        for (TipoIdentificacion tipoIdentificacion : tipoIdentificaciones) {
            System.out.println(tipoIdentificacion.getNombre());
        }
    }

    @Test
    public void encontrarPorCodigoYEstado() {
        List<TipoIdentificacion> tipoIdentificaciones = tipoIdentificacionService.findByCodigoAndEstado("CC", "A");
        for (TipoIdentificacion tipoIdentificacion : tipoIdentificaciones) {
            System.out.println(tipoIdentificacion.getNombre());
        }
    }

}
