package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.PedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.PedidoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.PedidoFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.PedidoDTO;

public class PedidoFacadeImpl implements PedidoFacade{

	
	private DAOFactory daoFactory;
	private PedidoBusinessLogic pedidoBusinessLogic;
	
	public PedidoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		pedidoBusinessLogic = new PedidoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevaPedido(PedidoDTO pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPedidoExistente(UUID id, PedidoDTO pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamentePedidoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PedidoDTO consultarPedidoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDTO> consultarPedidos(PedidoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
