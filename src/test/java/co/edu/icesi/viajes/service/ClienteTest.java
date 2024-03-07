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
    void debeConsultarClientePorEstado() {
        List<Cliente> lstCliente = ClienteService.findByEstadoOrderByNumeroIdentificacionAsc("A", Pageable.ofSize(1));

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }

    }

    @Test
    void debeConsultarClientePorCorreo() {
        List<Cliente> lstCliente = ClienteService.findByCorreoIgnoreCase("maria@example.com");

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getEstado());
        }
    }

    @Test
    void debeConsultarClientePorNumeroIdentificacion() {
        List<Cliente> lstCliente = ClienteService.findByNumeroIdentificacionLike("123456789");

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
    void debeConsultarClientePorFechaNacimiento() {

        Date newDate = new Date();
        newDate.setYear(1990);
        newDate.setMonth(4);
        newDate.setDate(15);
        System.out.println(newDate);
        List<Cliente> lstCliente = ClienteService.findByFechaNacimientoBetween(newDate, new Date());

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
        Page<ClienteDTO> lstCliente = ClienteService.consultarPorTipoID("CC", Pageable.unpaged());

        for (ClienteDTO Cliente : lstCliente) {
            System.out.println(Cliente.getNumeroIdentificacion() + "-" + Cliente.getNombre() + " " + Cliente.getPrimerApellido() );
        }
    }

    @Test
    void debeConsultarClientePorSexo() {
        List<Cliente> lstCliente = ClienteService.findBySexoOrderByFechaNacimiento("M");

        for (Cliente Cliente : lstCliente) {
            System.out.println(Cliente.getNombre() + "-" + Cliente.getFechaNacimiento());
        }
    }



}


