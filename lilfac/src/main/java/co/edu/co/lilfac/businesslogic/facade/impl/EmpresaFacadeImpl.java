package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.EmpresaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.EmpresaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.EmpresaFacade;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.EmpresaDTO;

public class EmpresaFacadeImpl implements EmpresaFacade{

	private DAOFactory daoFactory;
	private EmpresaBusinessLogic empresaBusinessLogic;
	
	public EmpresaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		empresaBusinessLogic = new EmpresaBusinessLogicImpl();
		
		//REVISAR EL ARGUMENTO DE new InventarioBusinessLogicImpl()
	} 
	
	@Override
	public void registrarInformacionEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarEmpresaExistente(UUID id, EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpresaDTO consultarEmpresaPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmarTelefonoEmpresa(UUID id, Integer telefonoEmpresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarCorreoEmpresa(UUID id, String correoEmpresa) {
		// TODO Auto-generated method stub
		
	}

}
