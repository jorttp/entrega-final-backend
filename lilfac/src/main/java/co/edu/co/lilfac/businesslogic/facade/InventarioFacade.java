package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.CiudadDTO;
import co.edu.co.lilfac.dto.InventarioDTO;

public interface InventarioFacade {
	
	void registrarNuevaCiudad(CiudadDTO ciudad);
	void modificarInventarioExistente(UUID id, InventarioDTO inventario);
	void darBajaDefinitivamenteInventarioExistente(UUID id);
	CiudadDTO consultarInventarioPorId(UUID id);
	List<CiudadDTO> consultarCiudades(CiudadDTO filtro);

}
