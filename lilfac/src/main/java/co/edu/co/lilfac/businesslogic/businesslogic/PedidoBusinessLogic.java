package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface PedidoBusinessLogic {
	
	void registrarNuevoPedido(PedidoDomain pedido)throws LilfacException;
	void modificarPedidoExistente(UUID id, PedidoDomain pedido)throws LilfacException;
	void darBajaDefinitivamentePedidoExistente(UUID id)throws LilfacException;
	PedidoDomain consultarPedidoPorId(UUID id)throws LilfacException;
	List<PedidoDomain> consultarPedidos(PedidoDomain filtro)throws LilfacException;

}
