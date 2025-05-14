package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;

public interface HistorialCostoBusinessLogic {
	
	void registrarNuevoHistorialCosto(HistorialCostoDomain historialCosto);
	void modificarHistorialCostoExistente(UUID id, HistorialCostoDomain historialCosto);
	void darBajaDefinitivamenteHistorialCostoExistente(UUID id);
	HistorialCostoDomain consultarHistorialCostoPorId(UUID id);
	List<HistorialCostoDomain> consultarHistorialesCosto(HistorialCostoDomain filtro);

}
