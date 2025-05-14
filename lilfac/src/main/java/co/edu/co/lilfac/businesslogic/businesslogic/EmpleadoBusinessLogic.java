package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpleadoDomain;

public interface EmpleadoBusinessLogic {
	
	void registrarNuevoEmpleado(EmpleadoDomain empleado);
	void modificarEmpleadoExistente(UUID id, EmpleadoDomain empleado);
	void darBajaDefinitivamenteEmpleadoExistente(UUID id);
	EmpleadoDomain consultarEmpleadoPorId(UUID id);
	List<EmpleadoDomain> consultarEmpleados(EmpleadoDomain filtro);
	void confirmarTelefonoEmpleado(Integer telefonoEmpleado);
	void confirmarCorreoEmpleado(String correoEmpleado);

}
