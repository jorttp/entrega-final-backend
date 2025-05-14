package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.CostoAdicionalDTO;

public interface CostoAdicionalFacade {
	
	void registrarNuevoCostoAdicional(CostoAdicionalDTO costoAdicional);
	void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDTO costoAdicional);
	void darBajaDefinitivamenteCostoAdicionalExistente(UUID id);
	CostoAdicionalDTO consultarCostoAdicionalPorId(UUID id);
	List<CostoAdicionalDTO> consultarCostosAdicionales(CostoAdicionalDTO filtro);

}
