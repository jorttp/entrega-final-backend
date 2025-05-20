package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.InventarioBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.InventarioBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.InventarioFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.InventarioDTO;

public class InventarioFacadeImpl implements InventarioFacade{

	private DAOFactory daoFactory;
	private InventarioBusinessLogic inventarioBusinessLogic;
	
	public InventarioFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		inventarioBusinessLogic = new InventarioBusinessLogicImpl();
		
		//REVISAR EL ARGUMENTO DE new InventarioBusinessLogicImpl()
	} 
	
	@Override
	public void registrarNuevoProductoInventario(InventarioDTO inventario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarInventarioExistente(UUID id, InventarioDTO inventario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteInventarioExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InventarioDTO consultarInventarioPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
