package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.RecepcionBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.RecepcionDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.RecepcionEntity;

public class RecepcionBusinessLogicImpl implements RecepcionBusinessLogic{

	
	private DAOFactory factory;
	
	public RecepcionBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaRecepcion(RecepcionDomain recepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarRecepcionExistente(UUID id, RecepcionDomain recepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteRecepcionExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecepcionDomain consultarRecepcionPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecepcionDomain> consultarRecepciones(RecepcionDomain filtro) throws LilfacException {
		
		RecepcionEntity RecepcionFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<RecepcionEntity> RecepcionEntities = factory.getRecepcionDAO().listByFIlter(RecepcionFilter);
		
		List<RecepcionDomain> datosARetornar = null;
		return datosARetornar;
	}

}
