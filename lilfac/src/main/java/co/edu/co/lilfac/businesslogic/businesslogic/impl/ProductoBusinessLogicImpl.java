package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.ProductoEntity;

public class ProductoBusinessLogicImpl implements ProductoBusinessLogic {

	private DAOFactory factory;
	
	public ProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoProducto(ProductoDomain producto) throws LilfacException {
		ProductoEntity productoEntity = null;
		factory.getProductoDAO().create(productoEntity);
	}

	@Override
	public void modificarProductoExistente(UUID id, ProductoDomain producto) throws LilfacException {
		ProductoEntity productoEntity = null;
		factory.getProductoDAO().update(id, productoEntity);
	}

	@Override
	public void darBajaDefinitivamenteProductoExistente(UUID id) throws LilfacException {
		ProductoEntity productoEntity = null;
		factory.getProductoDAO().delete(id);
	}

	@Override
	public ProductoDomain consultarProductoPorId(UUID id) throws LilfacException {
		ProductoEntity ProductoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		ProductoEntity ProductoEntity = factory.getProductoDAO().listById(id);
		
		ProductoDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<ProductoDomain> consultarProductos(ProductoDomain filtro) throws LilfacException {
		
		ProductoEntity ProductoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<ProductoEntity> ProductoEntities = factory.getProductoDAO().listByFIlter(ProductoFilter);
		
		List<ProductoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
