package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface CostoAdicionalBusinessLogic {
	
	void registrarNuevoCostoAdicional(CostoAdicionalDomain costoAdicional)throws LilfacException;
	void modificarCostoAdicionalExistente(UUID id, CostoAdicionalDomain costoAdicional)throws LilfacException;
	void darBajaDefinitivamenteCostoAdicionalExistente(UUID id)throws LilfacException;
	CostoAdicionalDomain consultarCostoAdicionalPorId(UUID id)throws LilfacException;
	List<CostoAdicionalDomain> consultarCostosAdicionales(CostoAdicionalDomain filtro)throws LilfacException;

}
