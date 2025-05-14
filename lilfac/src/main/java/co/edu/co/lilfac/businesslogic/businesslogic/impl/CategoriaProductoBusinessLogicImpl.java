package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CategoriaProductoEntity;

public class CategoriaProductoBusinessLogicImpl implements CategoriaProductoBusinessLogic {

	private DAOFactory factory;
	
	public CategoriaProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaCategoriaProducto(CategoriaProductoDomain categoriaProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDomain categoriaProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCategoriaProductoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaProductoDomain consultarCategoriaProductoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoDomain> consultarCategoriasProducto(CategoriaProductoDomain filtro) {
		
		CategoriaProductoEntity categoriaProductoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CategoriaProductoEntity> categoriaProductoEntities = factory.getCategoriaProductoDAO().listByFIlter(categoriaProductoFilter);
		
		List<CategoriaProductoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
