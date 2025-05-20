package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.ProductoPedidoDTO;

public interface ProductoPedidoFacade {
	
	void registrarNuevoProductoPedido(ProductoPedidoDTO productoPedido)throws LilfacException;
	void modificarProductoPedidoExistente(UUID id, ProductoPedidoDTO productoPedido)throws LilfacException;
	void darBajaDefinitivamenteProductoPedidoExistente(UUID id)throws LilfacException;
	ProductoPedidoDTO consultarProductoPedidoPorId(UUID id)throws LilfacException;
	List<ProductoPedidoDTO> consultarProductosPedidos(ProductoPedidoDTO filtro)throws LilfacException;

}
