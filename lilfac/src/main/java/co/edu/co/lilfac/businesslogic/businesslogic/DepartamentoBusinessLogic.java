package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.DepartamentoDomain;

public interface DepartamentoBusinessLogic {
	
	void registrarNuevoDepartamento(DepartamentoDomain departamento);
	void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento);
	void darBajaDefinitivamenteDepartamentoExistente(UUID id);
	DepartamentoDomain consultarDepartamentoPorId(UUID id);
	List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro);

}
