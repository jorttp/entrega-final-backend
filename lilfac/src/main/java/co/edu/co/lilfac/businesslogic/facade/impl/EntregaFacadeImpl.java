package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EntregaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.EntregaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.EntregaFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.EntregaDTO;

public class EntregaFacadeImpl implements EntregaFacade{

	private DAOFactory daoFactory;
	private EntregaBusinessLogic entregaBusinessLogic;
	
	public EntregaFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		entregaBusinessLogic = new EntregaBusinessLogicImpl(daoFactory);
	} 
	

	@Override
	public void registrarNuevaEntrega(EntregaDTO entrega) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEntregaExistente(UUID id, EntregaDTO entrega) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteEntregaExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntregaDTO consultarEntregaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntregaDTO> consultarEntregas(EntregaDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
