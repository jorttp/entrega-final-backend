package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CiudadBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CiudadFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CiudadDTO;

public class CiudadFacadeImpl implements CiudadFacade {
	
	private DAOFactory daoFactory;
	private CiudadBusinessLogic ciudadBusinessLogic;
	
	public CiudadFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		ciudadBusinessLogic = new CiudadBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevaCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiudadExistente(UUID id, CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCiudadExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadDTO consultarCiudadPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDTO> consultarCiudades(CiudadDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
