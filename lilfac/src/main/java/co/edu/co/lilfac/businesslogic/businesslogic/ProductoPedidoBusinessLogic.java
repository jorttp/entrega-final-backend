package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoPedidoDomain;

public interface ProductoPedidoBusinessLogic {
	
	void registrarNuevoProductoPedido(ProductoPedidoDomain productoPedido);
	void modificarProductoPedidoExistente(UUID id, ProductoPedidoDomain productoPedido);
	void darBajaDefinitivamenteProductoPedidoExistente(UUID id);
	ProductoPedidoDomain consultarProductoPedidoPorId(UUID id);
	List<ProductoPedidoDomain> consultarProductosPedidos(ProductoPedidoDomain filtro);

}
