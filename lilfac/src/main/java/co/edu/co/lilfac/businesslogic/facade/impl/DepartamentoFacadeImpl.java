package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.DepartamentoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.DepartamentoDTO;

public class DepartamentoFacadeImpl implements DepartamentoFacade{

	private DAOFactory daoFactory;
	private DepartamentoBusinessLogic departamentoBusinessLogic;
	
	public DepartamentoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		departamentoBusinessLogic = new DepartamentoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoDepartamento(DepartamentoDTO departamento) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			DepartamentoDomain departamentoDomain = null; //pasar de dto a domain
			departamentoBusinessLogic.registrarNuevoDepartamento(departamentoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo departamento";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de un nuevo departamento";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			DepartamentoDomain departamentoDomain = null; //pasar de dto a domain
			departamentoBusinessLogic.modificarDepartamentoExistente(id, departamentoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el departamento con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el departamento con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			DepartamentoDomain departamentoDomain = null; //pasar de dto a domain
			departamentoBusinessLogic.darBajaDefinitivamenteDepartamentoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el departamento con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el departamento con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public DepartamentoDTO consultarDepartamentoPorId(UUID id) throws LilfacException {
		try {
			var departamentoDomainResultado = departamentoBusinessLogic.consultarDepartamentoPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un departamento con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un departamento con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<DepartamentoDTO> consultarDepartamentos(DepartamentoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
