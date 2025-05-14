package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.HistorialCostoDTO;

public interface HistorialCostoFacade {
	
	void registrarNuevoHistorialCosto(HistorialCostoDTO historialCosto);
	void modificarHistorialCostoExistente(UUID id, HistorialCostoDTO historialCosto);
	void darBajaDefinitivamenteHistorialCostoExistente(UUID id);
	HistorialCostoDTO consultarHistorialCostoPorId(UUID id);
	List<HistorialCostoDTO> consultarHistorialesCosto(HistorialCostoDTO filtro);

}
