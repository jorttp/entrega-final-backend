package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.EmpleadoDTO;

public interface EmpleadoFacade {
	
	void registrarNuevoEmpleado(EmpleadoDTO empleado);
	void modificarEmpleadoExistente(UUID id, EmpleadoDTO empleado);
	void darBajaDefinitivamenteEmpleadoExistente(UUID id);
	EmpleadoDTO consultarEmpleadoPorId(UUID id);
	List<EmpleadoDTO> consultarEmpleados(EmpleadoDTO filtro);

}
