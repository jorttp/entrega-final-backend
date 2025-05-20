package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CategoriaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CategoriaFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CategoriaDTO;

public class CategoriaFacadeImpl implements CategoriaFacade{
	
	private DAOFactory daoFactory;
	private CategoriaBusinessLogic categoriaBusinessLogic;
	
	public CategoriaFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		categoriaBusinessLogic = new CategoriaBusinessLogicImpl(daoFactory);
	} 

	@Override
	public void registrarNuevaCategoria(CategoriaDTO categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCategoriaExistente(UUID id, CategoriaDTO categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCategoriaExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaDTO consultarCategoriaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaDTO> consultarCategorias(CategoriaDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
