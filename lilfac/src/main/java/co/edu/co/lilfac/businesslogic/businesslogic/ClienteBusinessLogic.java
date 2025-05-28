package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface ClienteBusinessLogic {
	
	void registrarNuevoCliente(ClienteDomain cliente)throws LilfacException;
	void modificarClienteExistente(UUID id, ClienteDomain cliente)throws LilfacException;
	void darBajaDefinitivamenteClienteExistente(UUID id)throws LilfacException;
	ClienteDomain consultarClientePorId(UUID id)throws LilfacException;
	List<ClienteDomain> consultarClientes(ClienteDomain filtro)throws LilfacException;
}
