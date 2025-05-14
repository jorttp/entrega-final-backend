package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.ProductoEntity;

public class ProductoBusinessLogicImpl implements ProductoBusinessLogic {

	private DAOFactory factory;
	
	public ProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoProducto(ProductoDomain producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProductoExistente(UUID id, ProductoDomain producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteProductoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoDomain consultarProductoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDomain> consultarProductos(ProductoDomain filtro) {
		
		ProductoEntity ProductoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<ProductoEntity> ProductoEntities = factory.getProductoDAO().listByFIlter(ProductoFilter);
		
		List<ProductoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
