package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.ClienteDTO;

public interface ClienteFacade {
	
	void registrarNuevoCliente(ClienteDTO cliente);
	void modificarClienteExistente(UUID id, ClienteDTO cliente);
	void darBajaDefinitivamenteClienteExistente(UUID id);
	ClienteDTO consultarClientePorId(UUID id);
	List<ClienteDTO> consultarClientes(ClienteDTO filtro);
	void confirmarTelefonoCliente(UUID id, Integer telefonoCliente);
	void confirmarCorreoCliente(UUID id, String correoCliente);

}
