package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.ClienteDTO;

public interface ClienteFacade {
	
	void registrarNuevoCliente(ClienteDTO cliente)throws LilfacException;
	void modificarClienteExistente(UUID id, ClienteDTO cliente)throws LilfacException;
	void darBajaDefinitivamenteClienteExistente(UUID id)throws LilfacException;
	ClienteDTO consultarClientePorId(UUID id)throws LilfacException;
	List<ClienteDTO> consultarClientes(ClienteDTO filtro)throws LilfacException;

}
