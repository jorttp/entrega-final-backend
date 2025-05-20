package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EmpleadoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.EmpleadoBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.EmpleadoFacade;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.EmpleadoDTO;

public class EmpleadoFacadeImpl implements EmpleadoFacade{

	private DAOFactory daoFactory;
	private EmpleadoBusinessLogic empleadoBusinessLogic;
	
	public EmpleadoFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		empleadoBusinessLogic = new EmpleadoBusinessLogicImpl(daoFactory);
	} 
	
	@Override
	public void registrarNuevoEmpleado(EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEmpleadoExistente(UUID id, EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteEmpleadoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpleadoDTO consultarEmpleadoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoDTO> consultarEmpleados(EmpleadoDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmarTelefonoEmpleado(UUID id, Integer telefonoEmpleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarCorreoEmpleado(UUID id, String correoEmpleado) {
		// TODO Auto-generated method stub
		
	}

}
