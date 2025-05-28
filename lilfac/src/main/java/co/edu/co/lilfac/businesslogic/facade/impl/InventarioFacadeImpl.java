package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.InventarioBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.inventario.dto.InventarioDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.InventarioDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.InventarioBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.InventarioFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.InventarioDTO;

public class InventarioFacadeImpl implements InventarioFacade{

	private DAOFactory daoFactory;
	private InventarioBusinessLogic inventarioBusinessLogic;
	
	public InventarioFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		inventarioBusinessLogic = new InventarioBusinessLogicImpl(daoFactory);

	} 
	
	@Override
	public void registrarNuevoProductoInventario(InventarioDTO inventario) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			InventarioDomain inventarioDomain = InventarioDTOAssembler.getInstance().toDomain(inventario);
			inventarioBusinessLogic.registrarNuevoProductoInventario(inventarioDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo inventario";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de un nuevo inventario";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInventarioExistente(UUID id, InventarioDTO inventario) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			InventarioDomain inventarioDomain = InventarioDTOAssembler.getInstance().toDomain(inventario);
			inventarioBusinessLogic.modificarInventarioExistente(id, inventarioDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el inventario con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el inventario con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteInventarioExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			inventarioBusinessLogic.darBajaDefinitivamenteInventarioExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el inventario con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el inventario con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public InventarioDTO consultarInventarioPorId(UUID id) throws LilfacException {
		try {
			var inventarioDomainResultado = inventarioBusinessLogic.consultarInventarioPorId(id);		
			return InventarioDTOAssembler.getInstance().toDto(inventarioDomainResultado);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un inventario con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un inventario con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}

	}

}
