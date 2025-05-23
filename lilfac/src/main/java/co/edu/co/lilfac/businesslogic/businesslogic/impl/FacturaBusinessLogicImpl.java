package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.FacturaEntity;

public class FacturaBusinessLogicImpl implements FacturaBusinessLogic {

	private DAOFactory factory;
	
	public FacturaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevaFactura(FacturaDomain factura) throws LilfacException {
		FacturaEntity facturaEntity = null;
		factory.getFacturaDAO().create(facturaEntity);
	}

	@Override
	public void modificarFacturaExistente(UUID id, FacturaDomain factura) throws LilfacException {
		FacturaEntity facturaEntity = null;
		factory.getFacturaDAO().update(id, facturaEntity);
	}

	@Override
	public void darBajaDefinitivamenteFacturaExistente(UUID id) throws LilfacException {
		FacturaEntity facturaEntity = null;
		factory.getFacturaDAO().delete(id);
	}

	@Override
	public FacturaDomain consultarFacturaPorId(UUID id) throws LilfacException {
		FacturaEntity FacturaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		FacturaEntity FacturaEntity = factory.getFacturaDAO().listById(id);
		
		FacturaDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<FacturaDomain> consultarFacturas(FacturaDomain filtro) throws LilfacException {
		
		FacturaEntity FacturaFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<FacturaEntity> FacturaEntities = factory.getFacturaDAO().listByFIlter(FacturaFilter);
		
		List<FacturaDomain> datosARetornar = null;
		return datosARetornar;
	}

}
