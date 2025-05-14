package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.RecepcionBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.RecepcionBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.RecepcionFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.RecepcionDTO;

public class RecepcionFacadeImpl implements RecepcionFacade{

	
	private DAOFactory daoFactory;
	private RecepcionBusinessLogic recepcionBusinessLogic;
	
	public RecepcionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		recepcionBusinessLogic = new RecepcionBusinessLogicImpl(daoFactory);
	} 

	
	@Override
	public void registrarNuevaRecepcion(RecepcionDTO recepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarRecepcionExistente(UUID id, RecepcionDTO recepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteRecepcionExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecepcionDTO consultarRecepcionPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecepcionDTO> consultarRecepciones(RecepcionDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
