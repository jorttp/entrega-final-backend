package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CostoAdicionalBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.CostoAdicionalBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.CostoAdicionalFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.CostoAdicionalDTO;

public class CostoAdicionalFacadeImpl implements CostoAdicionalFacade{

	
	private DAOFactory daoFactory;
	private CostoAdicionalBusinessLogic costoAdicionalBusinessLogic;
	
	public CostoAdicionalFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		costoAdicionalBusinessLogic = new CostoAdicionalBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevoCostoAdicional(CostoAdicionalDTO costoAdicional) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDTO costoAdicional) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCostoAdicionalExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CostoAdicionalDTO consultarCostoAdicionalPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostoAdicionalDTO> consultarCostosAdicionales(CostoAdicionalDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
