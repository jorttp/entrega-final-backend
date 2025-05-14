package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.HistorialCostoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.HistorialCostoEntity;

public class HistorialCostoBusinessLogicImpl implements HistorialCostoBusinessLogic {

	private DAOFactory factory;
	
	public HistorialCostoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public void registrarNuevoHistorialCosto(HistorialCostoDomain historialCosto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarHistorialCostoExistente(UUID id, HistorialCostoDomain historialCosto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteHistorialCostoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HistorialCostoDomain consultarHistorialCostoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistorialCostoDomain> consultarHistorialesCosto(HistorialCostoDomain filtro) {
		
		HistorialCostoEntity HistorialCostoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<HistorialCostoEntity> HistorialCostoEntities = factory.getHistorialCostoDAO().listByFIlter(HistorialCostoFilter);
		
		List<HistorialCostoDomain> datosARetornar = null;
		return datosARetornar;
	}

}
