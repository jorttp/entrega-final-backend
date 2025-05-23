package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CostoAdicionalBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CostoAdicionalBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CostoAdicionalFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CostoAdicionalDTO;

public class CostoAdicionalFacadeImpl implements CostoAdicionalFacade{

	
	private DAOFactory daoFactory;
	private CostoAdicionalBusinessLogic costoAdicionalBusinessLogic;
	
	public CostoAdicionalFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		costoAdicionalBusinessLogic = new CostoAdicionalBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoCostoAdicional(CostoAdicionalDTO costoAdicional) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CostoAdicionalDomain costoAdicionalDomain = null; //pasar de dto a domain
			costoAdicionalBusinessLogic.registrarNuevoCostoAdicional(costoAdicionalDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo costo adicional";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de un nuevo costo adicional";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDTO costoAdicional) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CostoAdicionalDomain costoAdicionalDomain = null; //pasar de dto a domain
			costoAdicionalBusinessLogic.modificarCostoAdicionalExistente(id, costoAdicionalDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el costo adicional con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el costo adicional con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteCostoAdicionalExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CostoAdicionalDomain costoAdicionalDomain = null; //pasar de dto a domain
			costoAdicionalBusinessLogic.darBajaDefinitivamenteCostoAdicionalExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el costo adicional con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el costo adicional con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public CostoAdicionalDTO consultarCostoAdicionalPorId(UUID id) throws LilfacException {
		try {
			var costoAdicionalDomainResultado = costoAdicionalBusinessLogic.consultarCostoAdicionalPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un costo Adicional con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un costo Adicional con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<CostoAdicionalDTO> consultarCostosAdicionales(CostoAdicionalDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
