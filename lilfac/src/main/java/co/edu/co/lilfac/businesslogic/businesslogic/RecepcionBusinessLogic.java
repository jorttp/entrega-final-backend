package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.RecepcionDomain;

public interface RecepcionBusinessLogic {
	
	void registrarNuevaRecepcion(RecepcionDomain recepcion);
	void modificarRecepcionExistente(UUID id, RecepcionDomain recepcion);
	void darBajaDefinitivamenteRecepcionExistente(UUID id);
	RecepcionDomain consultarRecepcionPorId(UUID id);
	List<RecepcionDomain> consultarRecepciones(RecepcionDomain filtro);

}
