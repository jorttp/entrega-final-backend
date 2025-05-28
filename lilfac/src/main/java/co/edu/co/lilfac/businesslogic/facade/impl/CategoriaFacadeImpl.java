package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoria.dto.CategoriaDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CategoriaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CategoriaFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CategoriaDTO;

public class CategoriaFacadeImpl implements CategoriaFacade{
	
	private DAOFactory daoFactory;
	private CategoriaBusinessLogic categoriaBusinessLogic;
	
	public CategoriaFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		categoriaBusinessLogic = new CategoriaBusinessLogicImpl(daoFactory);
	} 

	@Override
	public void registrarNuevaCategoria(CategoriaDTO categoria) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CategoriaDomain categoriaDomain = CategoriaDTOAssembler.getInstance().toDomain(categoria);
			categoriaBusinessLogic.registrarNuevaCategoria(categoriaDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva categoria";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de una nueva categoria";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarCategoriaExistente(UUID id, CategoriaDTO categoria) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			CategoriaDomain categoriaDomain = CategoriaDTOAssembler.getInstance().toDomain(categoria);
			categoriaBusinessLogic.modificarCategoriaExistente(id, categoriaDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de una categoria con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de una categoria con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteCategoriaExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			categoriaBusinessLogic.darBajaDefinitivamenteCategoriaExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de la categoria con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de la categoria con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public CategoriaDTO consultarCategoriaPorId(UUID id) throws LilfacException {
		try {
			var categoriaDomainResultado = categoriaBusinessLogic.consultarCategoriaPorId(id);
			return CategoriaDTOAssembler.getInstance().toDto(categoriaDomainResultado);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de la categoria con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la informacion de la categoria con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<CategoriaDTO> consultarCategorias(CategoriaDTO filtro) throws LilfacException {
		try {
			var categoriaFilter = CategoriaDTOAssembler.getInstance().toDomain(filtro);
			List<CategoriaDomain> categoriasDomain = categoriaBusinessLogic.consultarCategorias(categoriaFilter);
			return CategoriaDTOAssembler.getInstance().toDto(categoriasDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de las categorias";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de las categorias";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
