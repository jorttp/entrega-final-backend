package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CategoriaEntity;

public class CategoriaBusinessLogicImpl implements CategoriaBusinessLogic {

	private DAOFactory factory;
	
	public CategoriaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaCategoria(CategoriaDomain categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCategoriaExistente(UUID id, CategoriaDomain categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCategoriaExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaDomain consultarCategoriaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaDomain> consultarCategorias(CategoriaDomain filtro) {
		
		CategoriaEntity categoriaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CategoriaEntity> categoriaEntities = factory.getCategoriaDAO().listByFIlter(categoriaFilter);
		
		List<CategoriaDomain> datosARetornar = null;
		return datosARetornar;
	}

}
