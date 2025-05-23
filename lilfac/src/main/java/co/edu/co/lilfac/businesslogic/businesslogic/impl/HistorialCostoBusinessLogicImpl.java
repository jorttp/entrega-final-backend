package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.HistorialCostoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.HistorialCostoEntity;

public class HistorialCostoBusinessLogicImpl implements HistorialCostoBusinessLogic {

	private DAOFactory factory;
	
	public HistorialCostoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public void registrarNuevoHistorialCosto(HistorialCostoDomain historialCosto) throws LilfacException {
		HistorialCostoEntity historialCostoEntity = null;
		factory.getHistorialCostoDAO().create(historialCostoEntity);
	}

	@Override
	public void modificarHistorialCostoExistente(UUID id, HistorialCostoDomain historialCosto) throws LilfacException {
		HistorialCostoEntity historialCostoEntity = null;
		factory.getHistorialCostoDAO().update(id, historialCostoEntity);
	}

	@Override
	public void darBajaDefinitivamenteHistorialCostoExistente(UUID id) throws LilfacException {
		HistorialCostoEntity historialCostoEntity = null;
		factory.getHistorialCostoDAO().delete(id);
	}

	@Override
	public HistorialCostoDomain consultarHistorialCostoPorId(UUID id) throws LilfacException {
		HistorialCostoEntity HistorialCostoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		HistorialCostoEntity HistorialCostoEntity = factory.getHistorialCostoDAO().listById(id);
		
		HistorialCostoDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<HistorialCostoDomain> consultarHistorialesCosto(HistorialCostoDomain filtro) throws LilfacException {
		
		HistorialCostoEntity HistorialCostoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<HistorialCostoEntity> HistorialCostoEntities = factory.getHistorialCostoDAO().listByFIlter(HistorialCostoFilter);
		
		List<HistorialCostoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
