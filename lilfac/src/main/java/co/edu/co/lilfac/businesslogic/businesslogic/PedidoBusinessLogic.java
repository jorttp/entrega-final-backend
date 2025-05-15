package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.PedidoDomain;

public interface PedidoBusinessLogic {
	
	void registrarNuevoPedido(PedidoDomain pedido);
	void modificarPedidoExistente(UUID id, PedidoDomain pedido);
	void darBajaDefinitivamentePedidoExistente(UUID id);
	PedidoDomain consultarPedidoPorId(UUID id);
	List<PedidoDomain> consultarPedidos(PedidoDomain filtro);

}
