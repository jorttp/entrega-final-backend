package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EntregaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.EntregaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.EntregaFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.EntregaDTO;

public class EntregaFacadeImpl implements EntregaFacade{

	private DAOFactory daoFactory;
	private EntregaBusinessLogic entregaBusinessLogic;
	
	public EntregaFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		entregaBusinessLogic = new EntregaBusinessLogicImpl(daoFactory);
	} 
	

	@Override
	public void registrarNuevaEntrega(EntregaDTO entrega) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			EntregaDomain entregaDomain = null; //pasar de dto a domain
			entregaBusinessLogic.registrarNuevaEntrega(entregaDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva entrega";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de una nueva entrega";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarEntregaExistente(UUID id, EntregaDTO entrega) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			EntregaDomain entregaDomain = null; //pasar de dto a domain
			entregaBusinessLogic.modificarEntregaExistente(id, entregaDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de la entrega con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de la entrega con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteEntregaExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			EntregaDomain entregaDomain = null; //pasar de dto a domain
			entregaBusinessLogic.darBajaDefinitivamenteEntregaExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de la entrega con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de la entrega con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public EntregaDTO consultarEntregaPorId(UUID id) throws LilfacException {
		try {
			var entregaDomainResultado = entregaBusinessLogic.consultarEntregaPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de una entrega con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de una entrega con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<EntregaDTO> consultarEntregas(EntregaDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
