package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.HistorialCostoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.HistorialCostoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.HistorialCostoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.HistorialCostoDTO;

public class HistorialCostoFacadeImpl implements HistorialCostoFacade{

	
	private DAOFactory daoFactory;
	private HistorialCostoBusinessLogic historialCostoBusinessLogic;
	
	public HistorialCostoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		historialCostoBusinessLogic = new HistorialCostoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoHistorialCosto(HistorialCostoDTO historialCosto) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			HistorialCostoDomain historialCostoDomain = null; //pasar de dto a domain
			historialCostoBusinessLogic.registrarNuevoHistorialCosto(historialCostoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo historial de costos";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de un nuevo historial de costos";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarHistorialCostoExistente(UUID id, HistorialCostoDTO historialCosto) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			HistorialCostoDomain historialCostoDomain = null; //pasar de dto a domain
			historialCostoBusinessLogic.modificarHistorialCostoExistente(id, historialCostoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el historial de costos con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el historial de costos con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteHistorialCostoExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			HistorialCostoDomain historialCostoDomain = null; //pasar de dto a domain
			historialCostoBusinessLogic.darBajaDefinitivamenteHistorialCostoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el historial de costos con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el historial de costos con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public HistorialCostoDTO consultarHistorialCostoPorId(UUID id) throws LilfacException {
		try {
			var historialCostoDomainResultado = historialCostoBusinessLogic.consultarHistorialCostoPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un historial Costo con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un historial Costo con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<HistorialCostoDTO> consultarHistorialesCosto(HistorialCostoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
