package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.ProductoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.ProductoFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.ProductoDTO;

public class ProductoFacadeImpl implements ProductoFacade{

	
	private DAOFactory daoFactory;
	private ProductoBusinessLogic productoBusinessLogic;
	
	public ProductoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		productoBusinessLogic = new ProductoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoProducto(ProductoDTO producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProductoExistente(UUID id, ProductoDTO producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteProductoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoDTO consultarProductoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO> consultarProductos(ProductoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
