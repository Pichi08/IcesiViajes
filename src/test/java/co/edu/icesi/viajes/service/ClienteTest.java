package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteService ClienteService;

    @Test
    void debeGuardarClientes() throws Exception {
        Cliente Cliente = new Cliente();
        Cliente.setIdClie(1);
        Cliente.setNumeroIdentificacion("123");
        Cliente.setPrimerApellido("Perez");
        Cliente.setSegundoApellido("Perez");
        Cliente.setNombre("Juan");
        Cliente.setTelefono1("123");
        Cliente.setTelefono2("123");
        Cliente.setCorreo("algo@algo.com");
        Cliente.setSexo("M");
        Cliente.setFechaNacimiento(new Date());
        Cliente.setFechaCreacion(new Date());
        Cliente.setFechaModificacion(new Date());
        Cliente.setUsuCreador("admin");
        Cliente.setUsuModificador("admin");
        Cliente.setEstado("A");
        Cliente.setIdTiid(1);

//        ClienteService.save(Cliente);
    }

    @Test
    void debeConsultarClientePorEstado() {
        List<Cliente> lstCliente = ClienteService.findByEstadoOrderByNumeroIdentificacionAsc("A", Pageable.ofSize(1));

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }

    }

    @Test
    void debeConsultarClientePorCorreo() {
        List<Cliente> lstCliente = ClienteService.findByCorreoIgnoreCase("algo@algo.com");

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeConsultarClientePorNumeroIdentificacion() {
        List<Cliente> lstCliente = ClienteService.findByNumeroIdentificacionLike("123");

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeConsultarClientePorNombre() {
        List<Cliente> lstCliente = ClienteService.findByNombreLikeIgnoreCase("Juan");

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeRetornarListaDeClientes() {
        List<Cliente> lstCliente = ClienteService.findAll();

        System.out.println("\n\nLista de clientes");
        for(Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNombre() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeConsultarClientePorFechaCreacion() {
        List<Cliente> lstCliente = ClienteService.findByFechaCreacionBetween(new Date(), new Date());

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeContarClientesPorEstado() {
        Long count = ClienteService.countByEstado("A");

        System.out.println("Cantidad de clientes: " + count);
    }

    @Test
    void debeConsultarPorPrimerYSegundoApellido() {
        List<Cliente> lstCliente = ClienteService.findByPrimerApellidoAndSegundoApellido("Perez", "Perez");

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeRetornarUnCliente() {
        Page<ClienteDTO> lstCliente = ClienteService.consultarPorTipoID("CC", Pageable.ofSize(1));

        for (ClienteDTO Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }


}


