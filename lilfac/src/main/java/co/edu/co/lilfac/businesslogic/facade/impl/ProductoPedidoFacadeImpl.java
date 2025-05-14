package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoPedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.ProductoPedidoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.ProductoPedidoFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.ProductoPedidoDTO;

public class ProductoPedidoFacadeImpl implements ProductoPedidoFacade{

	private DAOFactory daoFactory;
	private ProductoPedidoBusinessLogic productoPedidoBusinessLogic;
	
	public ProductoPedidoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		productoPedidoBusinessLogic = new ProductoPedidoBusinessLogicImpl(daoFactory);
	} 
	
	@Override
	public void registrarNuevoProductoPedido(ProductoPedidoDTO productoPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProductoPedidoExistente(UUID id, ProductoPedidoDTO productoPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteProductoPedidoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoPedidoDTO consultarProductoPedidoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoPedidoDTO> consultarProductosPedidos(ProductoPedidoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
