package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.HistorialCostoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.HistorialCostoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.HistorialCostoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.HistorialCostoDTO;

public class HistorialCostoFacadeImpl implements HistorialCostoFacade{

	
	private DAOFactory daoFactory;
	private HistorialCostoBusinessLogic historialCostoBusinessLogic;
	
	public HistorialCostoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		historialCostoBusinessLogic = new HistorialCostoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoHistorialCosto(HistorialCostoDTO historialCosto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarHistorialCostoExistente(UUID id, HistorialCostoDTO historialCosto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteHistorialCostoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HistorialCostoDTO consultarHistorialCostoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistorialCostoDTO> consultarHistorialesCosto(HistorialCostoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
