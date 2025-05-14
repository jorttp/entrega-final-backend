package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.ClienteDomain;

public interface ClienteBusinessLogic {
	
	void registrarNuevoCliente(ClienteDomain cliente);
	void modificarClienteExistente(UUID id, ClienteDomain cliente);
	void darBajaDefinitivamenteClienteExistente(UUID id);
	ClienteDomain consultarClientePorId(UUID id);
	List<ClienteDomain> consultarClientes(ClienteDomain filtro);
	void confirmarTelefonoCliente(Integer telefonoCliente);
	void confirmarCorreoCliente(String correoCliente);

}
