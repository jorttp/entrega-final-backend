package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpleadoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface EmpleadoBusinessLogic {
	
	void registrarNuevoEmpleado(EmpleadoDomain empleado)throws LilfacException;
	void modificarEmpleadoExistente(UUID id, EmpleadoDomain empleado)throws LilfacException;
	void darBajaDefinitivamenteEmpleadoExistente(UUID id)throws LilfacException;
	EmpleadoDomain consultarEmpleadoPorId(UUID id)throws LilfacException;
	List<EmpleadoDomain> consultarEmpleados(EmpleadoDomain filtro)throws LilfacException;
	void confirmarTelefonoEmpleado(Integer telefonoEmpleado)throws LilfacException;
	void confirmarCorreoEmpleado(String correoEmpleado)throws LilfacException;

}
