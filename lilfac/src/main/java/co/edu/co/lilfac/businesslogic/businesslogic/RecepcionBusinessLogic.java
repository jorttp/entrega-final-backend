package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.RecepcionDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface RecepcionBusinessLogic {
	
	void registrarNuevaRecepcion(RecepcionDomain recepcion)throws LilfacException;
	void modificarRecepcionExistente(UUID id, RecepcionDomain recepcion)throws LilfacException;
	void darBajaDefinitivamenteRecepcionExistente(UUID id)throws LilfacException;
	RecepcionDomain consultarRecepcionPorId(UUID id)throws LilfacException;
	List<RecepcionDomain> consultarRecepciones(RecepcionDomain filtro)throws LilfacException;

}
