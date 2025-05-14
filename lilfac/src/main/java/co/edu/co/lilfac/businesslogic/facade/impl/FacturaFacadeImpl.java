package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.FacturaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.FacturaFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.FacturaDTO;

public class FacturaFacadeImpl implements FacturaFacade{

	
	private DAOFactory daoFactory;
	private FacturaBusinessLogic facturaBusinessLogic;
	
	public FacturaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		facturaBusinessLogic = new FacturaBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevaFactura(FacturaDTO factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarFacturaExistente(UUID id, FacturaDTO factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteFacturaExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FacturaDTO consultarFacturaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaDTO> consultarFacturas(FacturaDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
