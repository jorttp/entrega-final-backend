package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.cliente.entity.ClienteEntityAssembler;
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
	public void registrarNuevoCliente(ClienteDomain cliente) throws LilfacException {
		var clienteEntity = ClienteEntityAssembler.getInstance().toEntity(cliente);
		factory.getClienteDAO().create(clienteEntity);
	}

	@Override
	public void modificarClienteExistente(UUID id, ClienteDomain cliente) throws LilfacException {
		var clienteEntity = ClienteEntityAssembler.getInstance().toEntity(cliente);
		factory.getClienteDAO().update(id, clienteEntity);
	}

	@Override
	public void darBajaDefinitivamenteClienteExistente(UUID id) throws LilfacException {
		factory.getClienteDAO().delete(id);
	}

	@Override
	public ClienteDomain consultarClientePorId(UUID id) throws LilfacException {
		var clienteEntity = factory.getClienteDAO().listById(id);
		return ClienteEntityAssembler.getInstance().toDomain(clienteEntity);
	}

	@Override
	public List<ClienteDomain> consultarClientes(ClienteDomain filtro) throws LilfacException {
		
		var clienteFilter = ClienteEntityAssembler.getInstance().toEntity(filtro);
		List<ClienteEntity> clienteEntities = factory.getClienteDAO().listByFIlter(clienteFilter);
		return ClienteEntityAssembler.getInstance().toDomain(clienteEntities);
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
