package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.DepartamentoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.DepartamentoDTO;

public class DepartamentoFacadeImpl implements DepartamentoFacade{

	private DAOFactory daoFactory;
	private DepartamentoBusinessLogic departamentoBusinessLogic;
	
	public DepartamentoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		departamentoBusinessLogic = new DepartamentoBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoDepartamento(DepartamentoDTO departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoDTO consultarDepartamentoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDTO> consultarDepartamentos(DepartamentoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
