package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EmpresaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empresa.entity.EmpresaEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpresaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;

public class EmpresaBusinessLogicImpl implements EmpresaBusinessLogic {
	
	private DAOFactory factory;
	
	public EmpresaBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void registrarInformacionEmpresa(EmpresaDomain empresa) throws LilfacException {
		var empresaEntity = EmpresaEntityAssembler.getInstance().toEntity(empresa);
		factory.getEmpresaDAO().create(empresaEntity);
	}

	@Override
	public void modificarEmpresaExistente(UUID id, EmpresaDomain empresa) throws LilfacException {
		var empresaEntity = EmpresaEntityAssembler.getInstance().toEntity(empresa);
		factory.getEmpresaDAO().update(id, empresaEntity);
	}

	@Override
	public EmpresaDomain consultarEmpresaPorId(UUID id) throws LilfacException {
		var empresaEntity = factory.getEmpresaDAO().listById(id);
		return EmpresaEntityAssembler.getInstance().toDomain(empresaEntity);
	}


}
