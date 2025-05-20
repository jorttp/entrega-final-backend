package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.EmpleadoDTO;

public interface EmpleadoFacade {
	
	void registrarNuevoEmpleado(EmpleadoDTO empleado)throws LilfacException;
	void modificarEmpleadoExistente(UUID id, EmpleadoDTO empleado)throws LilfacException;
	void darBajaDefinitivamenteEmpleadoExistente(UUID id)throws LilfacException;
	EmpleadoDTO consultarEmpleadoPorId(UUID id)throws LilfacException;
	List<EmpleadoDTO> consultarEmpleados(EmpleadoDTO filtro)throws LilfacException;
	void confirmarTelefonoEmpleado(UUID id, Integer telefonoEmpleado)throws LilfacException;
	void confirmarCorreoEmpleado(UUID id, String correoEmpleado)throws LilfacException;

}
