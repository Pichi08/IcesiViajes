package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoDestino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TipoDestinoTest {

    @Autowired
    private TipoDestinoService tipoDestinoService;

    @Test
    void debeRetornarListaDeTiposDestino() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        System.out.println("\n\nLista de tipos destino");
        for(TipoDestino tipoDestino : lstTipoDestino) {
            System.out.println(tipoDestino.getCodigo() + "-" + tipoDestino.getEstado());
        }
    }

    @Test
    void debeRetornarTipoDestinoPorId() {
        Optional<TipoDestino> tipoDestino = tipoDestinoService.findById(2);
        System.out.println("\n\nTipo destino por id 2");
        System.out.println(tipoDestino.get().getNombre());
    }

    @Test
    void debeGuardarUnDestino() {
        TipoDestino tipoDestino = new TipoDestino();
        Date date = new Date();

        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();
        Integer id = lstTipoDestino.size() + 2;

        tipoDestino.setIdTide(id);
        tipoDestino.setNombre("Eiffel Tower");
        tipoDestino.setDescripcion("Huele maluco pero es linda");
        tipoDestino.setCodigo("EFT");
        tipoDestino.setEstado("A");
        tipoDestino.setFechaCreacion(date);
        tipoDestino.setFechaModificacion(null);
        tipoDestino.setUsuModificador("CLOPEZ");
        tipoDestino.setUsuCreador("CLOPEZ");

        try {
            tipoDestinoService.save(tipoDestino);
            System.out.println("\n\nTipo destino guardado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void debeActualizarUnDestino() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        Optional<TipoDestino> updateDestino = tipoDestinoService.findById(lstTipoDestino.get(lstTipoDestino.size() - 1).getIdTide());

        updateDestino.get().setNombre("Nueva Eiffel Tower");
        updateDestino.get().setDescripcion("Ahora huele rico pero no es linda");
        updateDestino.get().setCodigo("NEFT");
        updateDestino.get().setEstado("A");

        try {
            tipoDestinoService.update(updateDestino.get());
            System.out.println("\n\nTipo destino actualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Test
    void debeEliminarUnDestino() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        Optional<TipoDestino> tipoDestino = tipoDestinoService.findById(lstTipoDestino.get(lstTipoDestino.size() - 1).getIdTide());

        try{
            tipoDestinoService.delete(tipoDestino.get());
            System.out.println("\n\nTipo destino eliminado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void debeEliminarDestinoPorId() {
        TipoDestino tipoDestino = new TipoDestino();
        Date date = new Date();

        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();
        Integer id = lstTipoDestino.size() + 2;

        tipoDestino.setIdTide(id);
        tipoDestino.setNombre("Prueba eliminar");
        tipoDestino.setDescripcion("Es una prueba");
        tipoDestino.setCodigo("PRU");
        tipoDestino.setEstado("F");
        tipoDestino.setFechaCreacion(date);
        tipoDestino.setFechaModificacion(null);
        tipoDestino.setUsuModificador("PI");
        tipoDestino.setUsuCreador("PICHI");

        try {
            tipoDestinoService.save(tipoDestino);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            tipoDestinoService.deleteById(lstTipoDestino.get(lstTipoDestino.size() - 1).getIdTide());
            System.out.println("\n\nTipo destino eliminado por id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void debeContarTiposDestino() {
        Long count = tipoDestinoService.count();
        System.out.println("\n\nCantidad de tipos destino: " + count);
    }

    @Test
    void debeEncontrarPorCodigo() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findByCodigo("PLAYA");

        for(TipoDestino tipoDestino : lstTipoDestino) {
            System.out.println(tipoDestino.getNombre());
        }
    }

    @Test
    void debeEncontrarPorCodigoYEstado() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findByCodigoAndEstado("PLAYA", "A");

        for(TipoDestino tipoDestino : lstTipoDestino) {
            System.out.println(tipoDestino.getNombre());
        }
    }

    @Test
    void debeMostrarTiposDestinoOrdenadosPorNombre() {
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findByOrderByNombreAsc();

        for(TipoDestino tipoDestino : lstTipoDestino) {
            System.out.println(tipoDestino.getNombre());
        }
    }

}
