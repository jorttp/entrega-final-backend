package co.edu.co.lilfac.businesslogic.facade;

import java.util.UUID;

import co.edu.co.lilfac.dto.EmpresaDTO;

public interface EmpresaFacade {
	
	void registrarInformacionEmpresa(EmpresaDTO empresa);
	void modificarEmpresaExistente(UUID id, EmpresaDTO empresa);
	EmpresaDTO consultarEmpresaPorId(UUID id);
	void confirmarTelefonoEmpresa(Integer telefonoEmpresa);
	void confirmarCorreoEmpresa(String correoEmpresa);

}
