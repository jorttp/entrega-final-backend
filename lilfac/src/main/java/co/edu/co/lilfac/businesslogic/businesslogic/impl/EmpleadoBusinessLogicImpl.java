package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EmpleadoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.entity.EmpleadoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpleadoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.EmpleadoEntity;

public class EmpleadoBusinessLogicImpl implements EmpleadoBusinessLogic {

	private DAOFactory factory;
	
	public EmpleadoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoEmpleado(EmpleadoDomain empleado) throws LilfacException {
		var empleadoEntity = EmpleadoEntityAssembler.getInstance().toEntity(empleado);
		factory.getEmpleadoDAO().create(empleadoEntity);
	}

	@Override
	public void modificarEmpleadoExistente(UUID id, EmpleadoDomain empleado) throws LilfacException {
		var empleadoEntity = EmpleadoEntityAssembler.getInstance().toEntity(empleado);
		factory.getEmpleadoDAO().update(id, empleadoEntity);
	}

	@Override
	public void darBajaDefinitivamenteEmpleadoExistente(UUID id) throws LilfacException {
		factory.getEmpleadoDAO().delete(id);
	}

	@Override
	public EmpleadoDomain consultarEmpleadoPorId(UUID id) throws LilfacException {
		var empleadoEntity = factory.getEmpleadoDAO().listById(id);
		return EmpleadoEntityAssembler.getInstance().toDomain(empleadoEntity);
	}

	@Override
	public List<EmpleadoDomain> consultarEmpleados(EmpleadoDomain filtro) throws LilfacException {
		var empleadoFilter = EmpleadoEntityAssembler.getInstance().toEntity(filtro);
		List<EmpleadoEntity> empleadoEntities = factory.getEmpleadoDAO().listByFIlter(empleadoFilter);
		return EmpleadoEntityAssembler.getInstance().toDomain(empleadoEntities);
	}

}
