package co.edu.co.lilfac.businesslogic.facade;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.EmpresaDTO;

public interface EmpresaFacade {
	
	void registrarInformacionEmpresa(EmpresaDTO empresa)throws LilfacException;
	void modificarEmpresaExistente(UUID id, EmpresaDTO empresa)throws LilfacException;
	EmpresaDTO consultarEmpresaPorId(UUID id)throws LilfacException;
	void confirmarTelefonoEmpresa(UUID id, Integer telefonoEmpresa)throws LilfacException;
	void confirmarCorreoEmpresa(UUID id, String correoEmpresa)throws LilfacException;

}
