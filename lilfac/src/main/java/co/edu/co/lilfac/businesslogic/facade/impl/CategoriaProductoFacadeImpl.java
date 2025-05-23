package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CategoriaProductoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CategoriaProductoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;

public class CategoriaProductoFacadeImpl implements CategoriaProductoFacade{

	
	private DAOFactory daoFactory;
	private CategoriaProductoBusinessLogic categoriaProductoBusinessLogic;
	
	public CategoriaProductoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		categoriaProductoBusinessLogic = new CategoriaProductoBusinessLogicImpl(daoFactory);
	} 

	
	@Override
	public void registrarNuevaCategoriaProducto(CategoriaProductoDTO categoriaProducto) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CategoriaProductoDomain categoriaProductoDomain = null; //pasar de dto a domain
			categoriaProductoBusinessLogic.registrarNuevaCategoriaProducto(categoriaProductoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva categoria de producto";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de una nueva categoria de producto";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDTO categoriaProducto) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CategoriaProductoDomain categoriaProductoDomain = null; //pasar de dto a domain
			categoriaProductoBusinessLogic.modificarCategoriaProductoExistente(id, categoriaProductoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de la categoria de producto con el identificaro ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de la categoria de producto con el identificaro ingresados";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteCategoriaProductoExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CategoriaProductoDomain categoriaProductoDomain = null; //pasar de dto a domain
			categoriaProductoBusinessLogic.darBajaDefinitivamenteCategoriaProductoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de la categoria de producto con el identificaro ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de la categoria de producto con el identificaro ingresados";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public CategoriaProductoDTO consultarCategoriaProductoPorId(UUID id) throws LilfacException {
		try {
			var categoriaProductoDomainResultado = categoriaProductoBusinessLogic.consultarCategoriaProductoPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de una categoria de producto con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de una categoria de producto con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<CategoriaProductoDTO> consultarCategoriasProducto(CategoriaProductoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
