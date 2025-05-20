package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CiudadEntity;

public class CiudadBusinessLogicImpl implements CiudadBusinessLogic {

	private DAOFactory factory;
	
	public CiudadBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaCiudad(CiudadDomain ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiudadExistente(UUID id, CiudadDomain ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteCiudadExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadDomain consultarCiudadPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDomain> consultarCiudades(CiudadDomain filtro) throws LilfacException {
		
		CiudadEntity CiudadFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<CiudadEntity> CiudadEntities = factory.getCiudadDAO().listByFIlter(CiudadFilter);
		
		List<CiudadDomain> datosARetornar = null;
		return datosARetornar;
	}

}
