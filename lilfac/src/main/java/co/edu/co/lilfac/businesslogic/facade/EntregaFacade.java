package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.EntregaDTO;

public interface EntregaFacade {
	
	void registrarNuevaEntrega(EntregaDTO entrega)throws LilfacException;
	void modificarEntregaExistente(UUID id, EntregaDTO entrega)throws LilfacException;
	void darBajaDefinitivamenteEntregaExistente(UUID id)throws LilfacException;
	EntregaDTO consultarEntregaPorId(UUID id)throws LilfacException;
	List<EntregaDTO> consultarEntregas(EntregaDTO filtro)throws LilfacException;

}
