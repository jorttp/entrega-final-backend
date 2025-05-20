package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.RecepcionDTO;

public interface RecepcionFacade {
	
	void registrarNuevaRecepcion(RecepcionDTO recepcion)throws LilfacException;
	void modificarRecepcionExistente(UUID id, RecepcionDTO recepcion)throws LilfacException;
	void darBajaDefinitivamenteRecepcionExistente(UUID id)throws LilfacException;
	RecepcionDTO consultarRecepcionPorId(UUID id)throws LilfacException;
	List<RecepcionDTO> consultarRecepciones(RecepcionDTO filtro)throws LilfacException;

}
