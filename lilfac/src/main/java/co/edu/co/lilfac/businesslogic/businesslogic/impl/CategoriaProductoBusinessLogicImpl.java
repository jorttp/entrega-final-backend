package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CategoriaProductoEntity;

public class CategoriaProductoBusinessLogicImpl implements CategoriaProductoBusinessLogic {

	private DAOFactory factory;
	
	public CategoriaProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaCategoriaProducto(CategoriaProductoDomain categoriaProducto) throws LilfacException {
		CategoriaProductoEntity categoriaProdcutoEntity = null;
		factory.getCategoriaProductoDAO().create(categoriaProdcutoEntity);
	}

	@Override
	public void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDomain categoriaProducto) throws LilfacException {
		CategoriaProductoEntity categoriaProdcutoEntity = null;
		factory.getCategoriaProductoDAO().update(id, categoriaProdcutoEntity);
	}

	@Override
	public void darBajaDefinitivamenteCategoriaProductoExistente(UUID id) throws LilfacException {
		CategoriaProductoEntity categoriaProdcutoEntity = null;
		factory.getCategoriaProductoDAO().delete(id);
	}

	@Override
	public CategoriaProductoDomain consultarCategoriaProductoPorId(UUID id) throws LilfacException {
		CategoriaProductoEntity categoriaProductoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		CategoriaProductoEntity categoriaProductoEntity = factory.getCategoriaProductoDAO().listById(id);
		
		CategoriaProductoDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<CategoriaProductoDomain> consultarCategoriasProducto(CategoriaProductoDomain filtro) throws LilfacException {
		
		CategoriaProductoEntity categoriaProductoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CategoriaProductoEntity> categoriaProductoEntities = factory.getCategoriaProductoDAO().listByFIlter(categoriaProductoFilter);
		
		List<CategoriaProductoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
