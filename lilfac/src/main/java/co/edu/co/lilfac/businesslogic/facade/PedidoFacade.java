package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.PedidoDTO;

public interface PedidoFacade {
	
	void registrarNuevaPedido(PedidoDTO pedido);
	void modificarPedidoExistente(UUID id, PedidoDTO pedido);
	void darBajaDefinitivamentePedidoExistente(UUID id);
	PedidoDTO consultarPedidoPorId(UUID id);
	List<PedidoDTO> consultarPedidos(PedidoDTO filtro);

}
