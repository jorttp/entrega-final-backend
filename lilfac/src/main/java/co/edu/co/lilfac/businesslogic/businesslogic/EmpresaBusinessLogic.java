package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpresaDomain;

public interface EmpresaBusinessLogic {
	
	void registrarInformacionEmpresa(EmpresaDomain empresa);
	void modificarEmpresaExistente(UUID id, EmpresaDomain empresa);
	EmpresaDomain consultarEmpresaPorId(UUID id);
	void confirmarTelefonoEmpresa(Integer telefonoEmpresa);
	void confirmarCorreoEmpresa(String correoEmpresa);

}
