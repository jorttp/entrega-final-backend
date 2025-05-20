package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.CostoAdicionalDTO;

public interface CostoAdicionalFacade {
	
	void registrarNuevoCostoAdicional(CostoAdicionalDTO costoAdicional)throws LilfacException;
	void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDTO costoAdicional)throws LilfacException;
	void darBajaDefinitivamenteCostoAdicionalExistente(UUID id)throws LilfacException;
	CostoAdicionalDTO consultarCostoAdicionalPorId(UUID id)throws LilfacException;
	List<CostoAdicionalDTO> consultarCostosAdicionales(CostoAdicionalDTO filtro)throws LilfacException;

}
