package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpresaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface EmpresaBusinessLogic {
	
	void registrarInformacionEmpresa(EmpresaDomain empresa)throws LilfacException;
	void modificarEmpresaExistente(UUID id, EmpresaDomain empresa)throws LilfacException;
	EmpresaDomain consultarEmpresaPorId(UUID id)throws LilfacException;
	void confirmarTelefonoEmpresa(Integer telefonoEmpresa)throws LilfacException;
	void confirmarCorreoEmpresa(String correoEmpresa)throws LilfacException;

}
