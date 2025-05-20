package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoPedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoPedidoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.ProductoPedidoEntity;

public class ProductoPedidoBusinessLogicImpl implements ProductoPedidoBusinessLogic {

	private DAOFactory factory;
	
	public ProductoPedidoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoProductoPedido(ProductoPedidoDomain productoPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProductoPedidoExistente(UUID id, ProductoPedidoDomain productoPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteProductoPedidoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoPedidoDomain consultarProductoPedidoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoPedidoDomain> consultarProductosPedidos(ProductoPedidoDomain filtro) throws LilfacException {
		
		ProductoPedidoEntity ProductoPedidoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<ProductoPedidoEntity> ProductoPedidoEntities = factory.getProductoPedidoDAO().listByFIlter(ProductoPedidoFilter);
		
		List<ProductoPedidoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
