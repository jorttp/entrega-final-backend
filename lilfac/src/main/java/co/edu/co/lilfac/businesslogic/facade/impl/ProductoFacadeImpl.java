package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.ProductoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.ProductoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.ProductoDTO;

public class ProductoFacadeImpl implements ProductoFacade{

	
	private DAOFactory daoFactory;
	private ProductoBusinessLogic productoBusinessLogic;
	
	public ProductoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		productoBusinessLogic = new ProductoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoProducto(ProductoDTO producto) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ProductoDomain productoDomain = ProductoDTOAssembler.getInstance().toDomain(producto);
			productoBusinessLogic.registrarNuevoProducto(productoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo producto";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de ingresar la informacion de un nuevo producto";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarProductoExistente(UUID id, ProductoDTO producto) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ProductoDomain productoDomain = ProductoDTOAssembler.getInstance().toDomain(producto);
			productoBusinessLogic.modificarProductoExistente(id, productoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el producto con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el producto con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteProductoExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			productoBusinessLogic.darBajaDefinitivamenteProductoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el producto con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el producto con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ProductoDTO consultarProductoPorId(UUID id) throws LilfacException {
		try {
			var productoDomainResultado = productoBusinessLogic.consultarProductoPorId(id);		
			return ProductoDTOAssembler.getInstance().toDto(productoDomainResultado);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un producto con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un producto con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<ProductoDTO> consultarProductosFiltro(ProductoDTO filtro) throws LilfacException {
		try {
			var productoFilter = ProductoDTOAssembler.getInstance().toDomain(filtro);
			List<ProductoDomain> productosDomain = productoBusinessLogic.consultarProductosFiltro(productoFilter);
			return ProductoDTOAssembler.getInstance().toDto(productosDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de los productos";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de los productos";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}


	@Override
	public List<ProductoDTO> consultarProductos() throws LilfacException {
		try {
			daoFactory.abrirConexion();
			List<ProductoDomain> productosDomain = productoBusinessLogic.consultarProductos();
			return ProductoDTOAssembler.getInstance().toDto(productosDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de los productos";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de los productos";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
