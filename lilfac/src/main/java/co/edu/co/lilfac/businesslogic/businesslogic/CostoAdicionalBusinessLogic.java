package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;

public interface CostoAdicionalBusinessLogic {
	
	void registrarNuevoCostoAdicional(CostoAdicionalDomain costoAdicional);
	void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDomain costoAdicional);
	void darBajaDefinitivamenteCostoAdicionalExistente(UUID id);
	CostoAdicionalDomain consultarCostoAdicionalPorId(UUID id);
	List<CostoAdicionalDomain> consultarCostosAdicionales(CostoAdicionalDomain filtro);

}
