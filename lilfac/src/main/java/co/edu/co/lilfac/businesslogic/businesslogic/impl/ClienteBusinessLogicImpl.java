package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.ClienteEntity;

public class ClienteBusinessLogicImpl implements ClienteBusinessLogic {

private DAOFactory factory;
	
	public ClienteBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoCliente(ClienteDomain cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarClienteExistente(UUID id, ClienteDomain cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteClienteExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDomain consultarClientePorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDomain> consultarClientes(ClienteDomain filtro) throws LilfacException {
		
		ClienteEntity ClienteFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<ClienteEntity> ClienteEntities = factory.getClienteDAO().listByFIlter(ClienteFilter);
		
		List<ClienteDomain> datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public void confirmarTelefonoCliente(Integer telefonoCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarCorreoCliente(String correoCliente) {
		// TODO Auto-generated method stub
		
	}

}
