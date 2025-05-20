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
	public void registrarNuevoPais(PaisDomain pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPaisExistente(UUID id, PaisDomain pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamentePaisExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDomain consultarPaisPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDomain> consultarPaises(PaisDomain filtro) throws LilfacException {

		PaisEntity paisFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<PaisEntity> paisEntities = factory.getPaisDAO().listByFIlter(paisFilter);
		
		List<PaisDomain> datosARetornar = null; // MAGIA DE TRADUCIR DE entity-›domain
		return datosARetornar;
		
	}

}
