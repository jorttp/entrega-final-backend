package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.ProductoPedidoDTO;

public interface ProductoPedidoFacade {
	
	void registrarNuevoProductoPedido(ProductoPedidoDTO productoPedido);
	void modificarProductoPedidoExistente(UUID id, ProductoPedidoDTO productoPedido);
	void darBajaDefinitivamenteProductoPedidoExistente(UUID id);
	ProductoPedidoDTO consultarProductoPedidoPorId(UUID id);
	List<ProductoPedidoDTO> consultarProductosPedidos(ProductoPedidoDTO filtro);

}
