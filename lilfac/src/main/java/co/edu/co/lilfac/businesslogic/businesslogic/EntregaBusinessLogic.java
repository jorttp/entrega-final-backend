package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface EntregaBusinessLogic {
	
	void registrarNuevaEntrega(EntregaDomain entrega)throws LilfacException;
	void modificarEntregaExistente(UUID id, EntregaDomain entrega)throws LilfacException;
	void darBajaDefinitivamenteEntregaExistente(UUID id)throws LilfacException;
	EntregaDomain consultarEntregaPorId(UUID id)throws LilfacException;
	List<EntregaDomain> consultarEntregas(EntregaDomain filtro)throws LilfacException;

}
