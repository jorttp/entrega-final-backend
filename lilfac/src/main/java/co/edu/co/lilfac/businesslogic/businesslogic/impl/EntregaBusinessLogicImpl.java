package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EntregaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.EntregaEntity;

public class EntregaBusinessLogicImpl implements EntregaBusinessLogic {
	
	private DAOFactory factory;
	
	public EntregaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaEntrega(EntregaDomain entrega) throws LilfacException {
		EntregaEntity entregaEntity = null;
		factory.getEntregaDAO().create(entregaEntity);
	}

	@Override
	public void modificarEntregaExistente(UUID id, EntregaDomain entrega) throws LilfacException {
		EntregaEntity entregaEntity = null;
		factory.getEntregaDAO().update(id, entregaEntity);
	}

	@Override
	public void darBajaDefinitivamenteEntregaExistente(UUID id) throws LilfacException {
		EntregaEntity entregaEntity = null;
		factory.getEntregaDAO().delete(id);
	}

	@Override
	public EntregaDomain consultarEntregaPorId(UUID id) throws LilfacException {
		EntregaEntity EntregaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		EntregaEntity EntregaEntity = factory.getEntregaDAO().listById(id);
		
		EntregaDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<EntregaDomain> consultarEntregas(EntregaDomain filtro) throws LilfacException {
		
		EntregaEntity EntregaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<EntregaEntity> EntregaEntities = factory.getEntregaDAO().listByFIlter(EntregaFilter);
		
		List<EntregaDomain> datosARetornar = null;
		return datosARetornar;
	}

}
