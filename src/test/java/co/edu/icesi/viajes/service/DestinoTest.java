package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.dto.DestinoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest

public class DestinoTest {

    @Autowired
    private DestinoService destinoService;

    @Test
    void debeConsultarDestinoPorCodigoYEstado() {
        List<Destino> lstDestino = destinoService.findByCodigoAndEstado("CARTAGENA", "A");

        for (Destino destino : lstDestino) {
            System.out.println(destino.getNombre() + "-" + destino.getEstado());
        }
    }

    @Test
    void debeConsultarDestinoPorTipoDestino() {
        List<DestinoDTO> lstDestino = destinoService.consultaDestinosPorTipoDestin("PLAYA Y MAR");

        for (DestinoDTO destino : lstDestino) {
            System.out.println("Entro");
            System.out.println(destino.getNombre() + "-" + destino.getEstado());
        }
    }

    @Test
    void debeConsultarDestinoPorEstado() {
        List<Destino> lstDestino = destinoService.findDestinoByEstado();

        for (Destino destino : lstDestino) {
            System.out.println(destino.getNombre() + "-" + destino.getEstado());
        }
    }

}
