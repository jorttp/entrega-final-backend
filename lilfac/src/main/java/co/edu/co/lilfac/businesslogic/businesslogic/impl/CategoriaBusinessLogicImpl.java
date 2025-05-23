package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CategoriaEntity;
import co.edu.co.lilfac.entity.PaisEntity;

public class CategoriaBusinessLogicImpl implements CategoriaBusinessLogic {

	private DAOFactory factory;
	
	public CategoriaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaCategoria(CategoriaDomain categoria) throws LilfacException {
		CategoriaEntity categoriaEntity = null; //convertir de domain a entity
		factory.getCategoriaDAO().create(categoriaEntity);
	}

	@Override
	public void modificarCategoriaExistente(UUID id, CategoriaDomain categoria) throws LilfacException {
		CategoriaEntity categoriaEntity = null; //convertir de domain a entity
		factory.getCategoriaDAO().update(id, categoriaEntity);
	}

	@Override
	public void darBajaDefinitivamenteCategoriaExistente(UUID id) throws LilfacException {
		CategoriaEntity categoriaEntity = null; //convertir de domain a entity
		factory.getCategoriaDAO().delete(id);
	}

	@Override
	public CategoriaDomain consultarCategoriaPorId(UUID id) throws LilfacException {
		CategoriaEntity categoriaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		CategoriaEntity categoriaentity = factory.getCategoriaDAO().listById(id);
		
		CategoriaDomain datosARetornar = null; // MAGIA DE TRADUCIR DE entity-›domain
		return datosARetornar;
	}

	@Override
	public List<CategoriaDomain> consultarCategorias(CategoriaDomain filtro) throws LilfacException {
		
		CategoriaEntity categoriaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CategoriaEntity> categoriaEntities = factory.getCategoriaDAO().listByFIlter(categoriaFilter);
		
		List<CategoriaDomain> datosARetornar = null;
		return datosARetornar;
	}

}
