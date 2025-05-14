package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CostoAdicionalBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CostoAdicionalEntity;

public class CostoAdicionalBusinessLogicImpl implements CostoAdicionalBusinessLogic {

	private DAOFactory factory;
	
	public CostoAdicionalBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoCostoAdicional(CostoAdicionalDomain costoAdicional) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDomain costoAdicional) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCostoAdicionalExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CostoAdicionalDomain consultarCostoAdicionalPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostoAdicionalDomain> consultarCostosAdicionales(CostoAdicionalDomain filtro) {
		
		CostoAdicionalEntity CostoAdicionalFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CostoAdicionalEntity> CostoAdicionalEntities = factory.getCostoAdicionalDAO().listByFIlter(CostoAdicionalFilter);
		
		List<CostoAdicionalDomain> datosARetornar = null;
		return datosARetornar;
	}

}
