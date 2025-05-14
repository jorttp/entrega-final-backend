package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.DepartamentoEntity;

public class DepartamentoBusinessLogicImpl implements DepartamentoBusinessLogic {

	private DAOFactory factory;
	
	public DepartamentoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoDepartamento(DepartamentoDomain departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamenteDepartamentoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoDomain consultarDepartamentoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro) {
		
		DepartamentoEntity DepartamentoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<DepartamentoEntity> Departamentontities = factory.getDepartamentoDAO().listByFIlter(DepartamentoFilter);
		
		List<DepartamentoDomain> datosARetornar = null;
		return datosARetornar;
		
	}

}
