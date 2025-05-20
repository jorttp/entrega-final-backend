package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CategoriaProductoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CategoriaProductoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;

public class CategoriaProductoFacadeImpl implements CategoriaProductoFacade{

	
	private DAOFactory daoFactory;
	private CategoriaProductoBusinessLogic categoriaProductoBusinessLogic;
	
	public CategoriaProductoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		categoriaProductoBusinessLogic = new CategoriaProductoBusinessLogicImpl(daoFactory);
	} 

	
	@Override
	public void registrarNuevaCategoriaProducto(CategoriaProductoDTO categoriaProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDTO categoriaProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCategoriaProductoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaProductoDTO consultarCategoriaProductoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoDTO> consultarCategoriasProducto(CategoriaProductoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
