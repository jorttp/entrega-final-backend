package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EntregaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.EntregaEntity;

public class EntregaBusinessLogicImpl implements EntregaBusinessLogic {
	
	private DAOFactory factory;
	
	public EntregaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaEntrega(EntregaDomain entrega) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEntregaExistente(UUID id, EntregaDomain entrega) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteEntregaExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntregaDomain consultarEntregaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntregaDomain> consultarEntregas(EntregaDomain filtro) {
		
		EntregaEntity EntregaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<EntregaEntity> EntregaEntities = factory.getEntregaDAO().listByFIlter(EntregaFilter);
		
		List<EntregaDomain> datosARetornar = null;
		return datosARetornar;
	}

}
