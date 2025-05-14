package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;

public interface EntregaBusinessLogic {
	
	void registrarNuevaEntrega(EntregaDomain entrega);
	void modificarEntregaExistente(UUID id, EntregaDomain entrega);
	void darBajaDefinitivamenteEntregaExistente(UUID id);
	EntregaDomain consultarEntregaPorId(UUID id);
	List<EntregaDomain> consultarEntregas(EntregaDomain filtro);

}
