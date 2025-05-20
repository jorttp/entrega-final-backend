package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.HistorialCostoDTO;

public interface HistorialCostoFacade {
	
	void registrarNuevoHistorialCosto(HistorialCostoDTO historialCosto)throws LilfacException;
	void modificarHistorialCostoExistente(UUID id, HistorialCostoDTO historialCosto)throws LilfacException;
	void darBajaDefinitivamenteHistorialCostoExistente(UUID id)throws LilfacException;
	HistorialCostoDTO consultarHistorialCostoPorId(UUID id)throws LilfacException;
	List<HistorialCostoDTO> consultarHistorialesCosto(HistorialCostoDTO filtro)throws LilfacException;

}
