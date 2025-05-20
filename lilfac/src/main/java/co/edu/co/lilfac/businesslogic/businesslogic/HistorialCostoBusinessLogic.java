package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface HistorialCostoBusinessLogic {
	
	void registrarNuevoHistorialCosto(HistorialCostoDomain historialCosto)throws LilfacException;
	void modificarHistorialCostoExistente(UUID id, HistorialCostoDomain historialCosto)throws LilfacException;
	void darBajaDefinitivamenteHistorialCostoExistente(UUID id)throws LilfacException;
	HistorialCostoDomain consultarHistorialCostoPorId(UUID id)throws LilfacException;
	List<HistorialCostoDomain> consultarHistorialesCosto(HistorialCostoDomain filtro)throws LilfacException;

}
