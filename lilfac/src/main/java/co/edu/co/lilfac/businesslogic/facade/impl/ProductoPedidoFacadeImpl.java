package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoPedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoPedidoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.ProductoPedidoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.ProductoPedidoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.ProductoPedidoDTO;

public class ProductoPedidoFacadeImpl implements ProductoPedidoFacade{

	private DAOFactory daoFactory;
	private ProductoPedidoBusinessLogic productoPedidoBusinessLogic;
	
	public ProductoPedidoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		productoPedidoBusinessLogic = new ProductoPedidoBusinessLogicImpl(daoFactory);
	} 
	
	@Override
	public void registrarNuevoProductoPedido(ProductoPedidoDTO productoPedido) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ProductoPedidoDomain productoPedidoDomain = null; //pasar de dto a domain
			productoPedidoBusinessLogic.registrarNuevoProductoPedido(productoPedidoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo producto Pedido";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de ingresar la informacion de un nuevo producto Pedido";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarProductoPedidoExistente(UUID id, ProductoPedidoDTO productoPedido) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ProductoPedidoDomain productoPedidoDomain = null; //pasar de dto a domain
			productoPedidoBusinessLogic.modificarProductoPedidoExistente(id, productoPedidoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el producto Pedido con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el producto Pedido con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteProductoPedidoExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			ProductoPedidoDomain productoPedidoDomain = null; //pasar de dto a domain
			productoPedidoBusinessLogic.darBajaDefinitivamenteProductoPedidoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el producto Pedido con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el producto Pedido con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ProductoPedidoDTO consultarProductoPedidoPorId(UUID id) throws LilfacException {
		try {
			var productoPedidoDomainResultado = productoPedidoBusinessLogic.consultarProductoPedidoPorId(id);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un producto Pedido con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un producto Pedido con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		return null;//convertir de domain a dto
	}

	@Override
	public List<ProductoPedidoDTO> consultarProductosPedidos(ProductoPedidoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
