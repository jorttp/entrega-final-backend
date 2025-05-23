package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.PaisEntity;

public class PaisBusinessLogicImpl implements PaisBusinessLogic {

	private DAOFactory factory;
	
	public PaisBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoPais(PaisDomain pais) throws LilfacException {
		PaisEntity paisEntity = null; //convertir de domain a entity
		factory.getPaisDAO().create(paisEntity);
	}

	@Override
	public void modificarPaisExistente(UUID id, PaisDomain pais) throws LilfacException {
		PaisEntity paisEntity = null; //convertir de domain a entity
		factory.getPaisDAO().update(id, paisEntity);
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) throws LilfacException {
		PaisEntity paisEntity = null; //convertir de domain a entity
		factory.getPaisDAO().delete(id);
	}

	@Override
	public PaisDomain consultarPaisPorId(UUID id) throws LilfacException {
		PaisEntity paisFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		PaisEntity paisEntity = factory.getPaisDAO().listById(id);
		
		PaisDomain datosARetornar = null; // MAGIA DE TRADUCIR DE entity-›domain
		return datosARetornar;
	}

	@Override
	public List<PaisDomain> consultarPaises(PaisDomain filtro) throws LilfacException {

		PaisEntity paisFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<PaisEntity> paisEntities = factory.getPaisDAO().listByFIlter(paisFilter);
		
		List<PaisDomain> datosARetornar = null; // MAGIA DE TRADUCIR DE entity-›domain
		return datosARetornar;
		
	}

}
