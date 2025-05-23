package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.DepartamentoEntity;

public class DepartamentoBusinessLogicImpl implements DepartamentoBusinessLogic {

	private DAOFactory factory;
	
	public DepartamentoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoDepartamento(DepartamentoDomain departamento) throws LilfacException {
		DepartamentoEntity departamentoEntity = null;
		factory.getDepartamentoDAO().create(departamentoEntity);
	}

	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento) throws LilfacException {
		DepartamentoEntity departamentoEntity = null;
		factory.getDepartamentoDAO().update(id, departamentoEntity);
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) throws LilfacException {
		DepartamentoEntity departamentoEntity = null;
		factory.getDepartamentoDAO().delete(id);
	}

	@Override
	public DepartamentoDomain consultarDepartamentoPorId(UUID id) throws LilfacException {
		DepartamentoEntity DepartamentoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		DepartamentoEntity Departamentontities = factory.getDepartamentoDAO().listById(id);
		
		DepartamentoDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro) throws LilfacException {
		
		DepartamentoEntity DepartamentoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<DepartamentoEntity> Departamentontities = factory.getDepartamentoDAO().listByFIlter(DepartamentoFilter);
		
		List<DepartamentoDomain> datosARetornar = null;
		return datosARetornar;
		
	}

}
