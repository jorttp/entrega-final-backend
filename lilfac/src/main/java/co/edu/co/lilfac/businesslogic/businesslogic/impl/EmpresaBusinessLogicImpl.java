package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EmpresaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpleadoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpresaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.entity.EmpleadoEntity;
import co.edu.co.lilfac.entity.EmpresaEntity;

public class EmpresaBusinessLogicImpl implements EmpresaBusinessLogic {
	
	private DAOFactory factory;
	
	public EmpresaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void registrarInformacionEmpresa(EmpresaDomain empresa) throws LilfacException {
		EmpresaEntity empresaEntity = null;
		factory.getEmpresaDAO().create(empresaEntity);
	}

	@Override
	public void modificarEmpresaExistente(UUID id, EmpresaDomain empresa) throws LilfacException {
		EmpresaEntity empresaEntity = null;
		factory.getEmpresaDAO().update(id, empresaEntity);
	}

	@Override
	public EmpresaDomain consultarEmpresaPorId(UUID id) throws LilfacException {
		EmpresaEntity EmpleadoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		EmpresaEntity EmpleadoEntity = factory.getEmpresaDAO().listById(id);
		
		EmpresaDomain datosARetornar = null;
		return datosARetornar;
	}

	@Override
	public void confirmarTelefonoEmpresa(Integer telefonoEmpresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarCorreoEmpresa(String correoEmpresa) {
		// TODO Auto-generated method stub
		
	}

}
