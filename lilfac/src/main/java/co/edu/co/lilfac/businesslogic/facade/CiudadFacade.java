package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.CiudadDTO;

public interface CiudadFacade {
	
	void registrarNuevaCiudad(CiudadDTO ciudad);
	void modificarCiudadExistente(UUID id, CiudadDTO ciudad);
	void darBajaDefinitivamenteCiudadExistente(UUID id);
	CiudadDTO consultarCiudadPorId(UUID id);
	List<CiudadDTO> consultarCiudades(CiudadDTO filtro);

}
