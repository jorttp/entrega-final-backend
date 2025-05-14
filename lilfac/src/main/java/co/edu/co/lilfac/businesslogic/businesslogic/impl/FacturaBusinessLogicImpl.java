package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.FacturaEntity;

public class FacturaBusinessLogicImpl implements FacturaBusinessLogic {

	private DAOFactory factory;
	
	public FacturaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaFactura(FacturaDomain factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarFacturaExistente(UUID id, FacturaDomain factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteFacturaExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FacturaDomain consultarFacturaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaDomain> consultarFacturas(FacturaDomain filtro) {
		
		FacturaEntity FacturaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<FacturaEntity> FacturaEntities = factory.getFacturaDAO().listByFIlter(FacturaFilter);
		
		List<FacturaDomain> datosARetornar = null;
		return datosARetornar;
	}

}
