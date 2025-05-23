package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.PedidoDTO;

public interface PedidoFacade {
	
	void registrarNuevoPedido(PedidoDTO pedido)throws LilfacException;
	void modificarPedidoExistente(UUID id, PedidoDTO pedido)throws LilfacException;
	void darBajaDefinitivamentePedidoExistente(UUID id)throws LilfacException;
	PedidoDTO consultarPedidoPorId(UUID id)throws LilfacException;
	List<PedidoDTO> consultarPedidos(PedidoDTO filtro)throws LilfacException;

}
