package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pais.dto.PaisDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.PaisBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.PaisFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.PaisDTO;

public class PaisFacadeImpl implements PaisFacade{
	
	private DAOFactory daoFactory;
	private PaisBusinessLogic paisBusinessLogic;
	
	public PaisFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		paisBusinessLogic = new PaisBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoPais(PaisDTO pais) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			PaisDomain paisDomain = PaisDTOAssembler.getInstance().toDomain(pais);
			paisBusinessLogic.registrarNuevoPais(paisDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo país";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de ingresar la informacion de un nuevo pais";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarPaisExistente(UUID id, PaisDTO pais) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			PaisDomain paisDomain = PaisDTOAssembler.getInstance().toDomain(pais);
			paisBusinessLogic.modificarPaisExistente(id, paisDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información del país con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información del país con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			paisBusinessLogic.darBajaDefinitivamentePaisExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información del país con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información del país con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PaisDTO consultarPaisPorId(UUID id) throws LilfacException {
		try {
			var paisDomainResultado = paisBusinessLogic.consultarPaisPorId(id);		
			return PaisDTOAssembler.getInstance().toDto(paisDomainResultado);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un pais con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un pais con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<PaisDTO> consultarPaises(PaisDTO filtro) throws LilfacException {
		try {
			var paisFilter = PaisDTOAssembler.getInstance().toDomain(filtro);
			List<PaisDomain> paisesDomain = paisBusinessLogic.consultarPaises(paisFilter);
			return PaisDTOAssembler.getInstance().toDto(paisesDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de los paises";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de los paises";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
