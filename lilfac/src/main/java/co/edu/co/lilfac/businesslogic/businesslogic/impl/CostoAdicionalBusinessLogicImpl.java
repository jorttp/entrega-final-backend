package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CostoAdicionalBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CostoAdicionalEntity;

public class CostoAdicionalBusinessLogicImpl implements CostoAdicionalBusinessLogic {

	private DAOFactory factory;
	
	public CostoAdicionalBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoCostoAdicional(CostoAdicionalDomain costoAdicional) throws LilfacException {
		CostoAdicionalEntity costoAdicionalEntity = null;
		factory.getCostoAdicionalDAO().create(costoAdicionalEntity);
	}

	@Override
	public void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDomain costoAdicional) throws LilfacException {
		CostoAdicionalEntity costoAdicionalEntity = null;
		factory.getCostoAdicionalDAO().update(id, costoAdicionalEntity);
	}

	@Override
	public void darBajaDefinitivamenteCostoAdicionalExistente(UUID id) throws LilfacException {
		CostoAdicionalEntity costoAdicionalEntity = null;
		factory.getCostoAdicionalDAO().delete(id);
	}

	@Override
	public CostoAdicionalDomain consultarCostoAdicionalPorId(UUID id) throws LilfacException {
		CostoAdicionalEntity CostoAdicionalFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		CostoAdicionalEntity CostoAdicionalEntity = factory.getCostoAdicionalDAO().listById(id);
		
		CostoAdicionalDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<CostoAdicionalDomain> consultarCostosAdicionales(CostoAdicionalDomain filtro) throws LilfacException {
		
		CostoAdicionalEntity CostoAdicionalFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CostoAdicionalEntity> CostoAdicionalEntities = factory.getCostoAdicionalDAO().listByFIlter(CostoAdicionalFilter);
		
		List<CostoAdicionalDomain> datosARetornar = null;
		return datosARetornar;
	}

}
