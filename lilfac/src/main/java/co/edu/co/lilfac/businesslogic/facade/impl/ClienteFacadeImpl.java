package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.ClienteBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.ClienteFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.ClienteDTO;

public class ClienteFacadeImpl implements ClienteFacade{

	private DAOFactory daoFactory;
	private ClienteBusinessLogic clienteBusinessLogic;
	
	public ClienteFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		clienteBusinessLogic = new ClienteBusinessLogicImpl(daoFactory);
	} 
	
	@Override
	public void registrarNuevoCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarClienteExistente(UUID id, ClienteDTO cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteClienteExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDTO consultarClientePorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> consultarClientes(ClienteDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmarTelefonoCliente(UUID id, Integer telefonoCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarCorreoCliente(UUID id, String correoCliente) {
		// TODO Auto-generated method stub
		
	}

}
