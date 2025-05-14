package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EmpleadoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpleadoDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.EmpleadoEntity;

public class EmpleadoBusinessLogicImpl implements EmpleadoBusinessLogic {

	private DAOFactory factory;
	
	public EmpleadoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoEmpleado(EmpleadoDomain empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEmpleadoExistente(UUID id, EmpleadoDomain empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteEmpleadoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpleadoDomain consultarEmpleadoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoDomain> consultarEmpleados(EmpleadoDomain filtro) {
		EmpleadoEntity EmpleadoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<EmpleadoEntity> EmpleadoEntities = factory.getEmpleadoDAO().listByFIlter(EmpleadoFilter);
		
		List<EmpleadoDomain> datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public void confirmarTelefonoEmpleado(Integer telefonoEmpleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarCorreoEmpleado(String correoEmpleado) {
		// TODO Auto-generated method stub
		
	}

}
