package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.RecepcionBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.RecepcionDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.RecepcionBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.RecepcionFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.RecepcionDTO;

public class RecepcionFacadeImpl implements RecepcionFacade{

	
	private DAOFactory daoFactory;
	private RecepcionBusinessLogic recepcionBusinessLogic;
	
	public RecepcionFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		recepcionBusinessLogic = new RecepcionBusinessLogicImpl(daoFactory);
	} 

	
	@Override
	public void registrarNuevaRecepcion(RecepcionDTO recepcion) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			RecepcionDomain recepcionDomain = null; //pasar de dto a domain
			recepcionBusinessLogic.registrarNuevaRecepcion(recepcionDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva recepcion";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de ingresar la informacion de una nueva recepcion";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarRecepcionExistente(UUID id, RecepcionDTO recepcion) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			RecepcionDomain recepcionDomain = null; //pasar de dto a domain
			recepcionBusinessLogic.modificarRecepcionExistente(id, recepcionDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de la recepcion con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de la recepcion con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteRecepcionExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			RecepcionDomain recepcionDomain = null; //pasar de dto a domain
			recepcionBusinessLogic.darBajaDefinitivamenteRecepcionExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de la recepcion con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de la recepcion con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public RecepcionDTO consultarRecepcionPorId(UUID id) throws LilfacException {
		try {
			var recepcionDomainResultado = recepcionBusinessLogic.consultarRecepcionPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de una recepcion con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de una recepcion con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<RecepcionDTO> consultarRecepciones(RecepcionDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
