package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.ClienteBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.ClienteFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.ClienteDTO;

public class ClienteFacadeImpl implements ClienteFacade{

	private DAOFactory daoFactory;
	private ClienteBusinessLogic clienteBusinessLogic;
	
	public ClienteFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		clienteBusinessLogic = new ClienteBusinessLogicImpl(daoFactory);
	} 
	
	@Override
	public void registrarNuevoCliente(ClienteDTO cliente) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ClienteDomain clienteDomain = null; //pasar de dto a domain
			clienteBusinessLogic.registrarNuevoCliente(clienteDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo cliente";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de un nuevo cliente";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarClienteExistente(UUID id, ClienteDTO cliente) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ClienteDomain clienteDomain = null; //pasar de dto a domain
			clienteBusinessLogic.modificarClienteExistente(id, clienteDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el cliente con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el cliente con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteClienteExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ClienteDomain clienteDomain = null; //pasar de dto a domain
			clienteBusinessLogic.darBajaDefinitivamenteClienteExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el cliente con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el cliente con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ClienteDTO consultarClientePorId(UUID id) throws LilfacException {
		try {
			var clienteDomainResultado = clienteBusinessLogic.consultarClientePorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un cliente con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un cliente con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
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
