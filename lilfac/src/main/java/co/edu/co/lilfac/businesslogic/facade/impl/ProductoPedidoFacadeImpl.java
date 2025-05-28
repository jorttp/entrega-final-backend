package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoPedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.productopedido.dto.ProductoPedidoDTOAssembler;
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
			ProductoPedidoDomain productoPedidoDomain = ProductoPedidoDTOAssembler.getInstance().toDomain(productoPedido);
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
			ProductoPedidoDomain productoPedidoDomain = ProductoPedidoDTOAssembler.getInstance().toDomain(productoPedido);
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
			return ProductoPedidoDTOAssembler.getInstance().toDto(productoPedidoDomainResultado);
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

	}

	@Override
	public List<ProductoPedidoDTO> consultarProductosPedidos(ProductoPedidoDTO filtro) throws LilfacException {
		try {
			var productoPedidoFilter = ProductoPedidoDTOAssembler.getInstance().toDomain(filtro);
			List<ProductoPedidoDomain> productosPedidosDomain = productoPedidoBusinessLogic.consultarProductosPedidos(productoPedidoFilter);
			return ProductoPedidoDTOAssembler.getInstance().toDto(productosPedidosDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de los productos pedidos";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de los productos pedidos";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
