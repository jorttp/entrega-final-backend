package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.RecepcionDTO;

public interface RecepcionFacade {
	
	void registrarNuevaRecepcion(RecepcionDTO recepcion);
	void modificarRecepcionExistente(UUID id, RecepcionDTO recepcion);
	void darBajaDefinitivamenteRecepcionExistente(UUID id);
	RecepcionDTO consultarRecepcionPorId(UUID id);
	List<RecepcionDTO> consultarRecepciones(RecepcionDTO filtro);

}
