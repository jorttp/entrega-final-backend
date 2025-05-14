package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.DepartamentoDTO;

public interface DepartamentoFacade {
	
	void registrarNuevoDepartamento(DepartamentoDTO departamento);
	void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento);
	void darBajaDefinitivamenteDepartamentoExistente(UUID id);
	DepartamentoDTO consultarDepartamentoPorId(UUID id);
	List<DepartamentoDTO> consultarDepartamentos(DepartamentoDTO filtro);

}
