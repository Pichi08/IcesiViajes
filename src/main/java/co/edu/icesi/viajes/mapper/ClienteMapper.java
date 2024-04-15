package co.edu.icesi.viajes.mapper;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClienteMapper {

    //Crea los mappings para convertir de Cliente a ClienteDTO y viceversa
//    @Mapping(source = "tiipoDocumento.idTiid", target = "idTiid")
//    ClienteDTO clienteToClienteDTO(Cliente cliente);

//    @Mapping(source = "idTiid", target = "tiipoDocumento.idTiid")
//    Cliente clienteDTOToCliente(ClienteDTO clienteDTO);
//    List<ClienteDTO> clientesToClienteDTOs(List<Cliente> clientes);
//    List<Cliente> clienteDTOsToClientes(List<ClienteDTO> clienteDTOs);

}
