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
	public void registrarNuevaRecepcion(RecepcionDomain recepcion) throws LilfacException {
		RecepcionEntity recepcionEntity = null;
		factory.getRecepcionDAO().create(recepcionEntity);
	}

	@Override
	public void modificarRecepcionExistente(UUID id, RecepcionDomain recepcion) throws LilfacException {
		RecepcionEntity recepcionEntity = null;
		factory.getRecepcionDAO().update(id, recepcionEntity);
	}

	@Override
	public void darBajaDefinitivamenteRecepcionExistente(UUID id) throws LilfacException {
		RecepcionEntity recepcionEntity = null;
		factory.getRecepcionDAO().delete(id);
	}

	@Override
	public RecepcionDomain consultarRecepcionPorId(UUID id) throws LilfacException {
		RecepcionEntity RecepcionFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		RecepcionEntity RecepcionEntity = factory.getRecepcionDAO().listById(id);
		
		RecepcionDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<RecepcionDomain> consultarRecepciones(RecepcionDomain filtro) throws LilfacException {
		
		RecepcionEntity RecepcionFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<RecepcionEntity> RecepcionEntities = factory.getRecepcionDAO().listByFIlter(RecepcionFilter);
		
		List<RecepcionDomain> datosARetornar = null;
		return datosARetornar;
	}

}
