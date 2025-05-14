package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.EntregaDTO;

public interface EntregaFacade {
	
	void registrarNuevaEntrega(EntregaDTO entrega);
	void modificarEntregaExistente(UUID id, EntregaDTO entrega);
	void darBajaDefinitivamenteEntregaExistente(UUID id);
	EntregaDTO consultarEntregaPorId(UUID id);
	List<EntregaDTO> consultarEntregas(EntregaDTO filtro);

}
