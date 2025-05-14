package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CiudadDomain;

public interface CiudadBusinessLogic {
	
	void registrarNuevaCiudad(CiudadDomain ciudad);
	void modificarCiudadExistente(UUID id, CiudadDomain ciudad);
	void darBajaDefinitivamenteCiudadExistente(UUID id);
	CiudadDomain consultarCiudadPorId(UUID id);
	List<CiudadDomain> consultarCiudades(CiudadDomain filtro);

}
