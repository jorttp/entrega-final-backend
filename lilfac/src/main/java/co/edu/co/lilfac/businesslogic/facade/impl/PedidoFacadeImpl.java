package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.PedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.dto.PedidoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.PedidoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.PedidoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.PedidoDTO;

public class PedidoFacadeImpl implements PedidoFacade{

	
	private DAOFactory daoFactory;
	private PedidoBusinessLogic pedidoBusinessLogic;
	
	public PedidoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		pedidoBusinessLogic = new PedidoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoPedido(PedidoDTO pedido) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			PedidoDomain pedidoDomain = PedidoDTOAssembler.getInstance().toDomain(pedido);
			pedidoBusinessLogic.registrarNuevoPedido(pedidoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo pedido";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de ingresar la informacion de un nuevo pedido";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarPedidoExistente(UUID id, PedidoDTO pedido) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			PedidoDomain pedidoDomain = PedidoDTOAssembler.getInstance().toDomain(pedido);
			pedidoBusinessLogic.modificarPedidoExistente(id, pedidoDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de el pedido con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de el pedido con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamentePedidoExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			pedidoBusinessLogic.darBajaDefinitivamentePedidoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de el pedido con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de el pedido con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PedidoDTO consultarPedidoPorId(UUID id) throws LilfacException {
		try {
			var pedidoDomainResultado = pedidoBusinessLogic.consultarPedidoPorId(id);		
			return PedidoDTOAssembler.getInstance().toDto(pedidoDomainResultado);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de un pedido con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de un pedido con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<PedidoDTO> consultarPedidos(PedidoDTO filtro) throws LilfacException {
		try {
			var pedidoFilter = PedidoDTOAssembler.getInstance().toDomain(filtro);
			List<PedidoDomain> pedidosDomain = pedidoBusinessLogic.consultarPedidos(pedidoFilter);
			return PedidoDTOAssembler.getInstance().toDto(pedidosDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de los pedidos";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de los pedidos";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
