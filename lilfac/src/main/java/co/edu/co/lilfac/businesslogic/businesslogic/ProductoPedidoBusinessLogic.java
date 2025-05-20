package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoPedidoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface ProductoPedidoBusinessLogic {
	
	void registrarNuevoProductoPedido(ProductoPedidoDomain productoPedido)throws LilfacException;
	void modificarProductoPedidoExistente(UUID id, ProductoPedidoDomain productoPedido)throws LilfacException;
	void darBajaDefinitivamenteProductoPedidoExistente(UUID id)throws LilfacException;
	ProductoPedidoDomain consultarProductoPedidoPorId(UUID id)throws LilfacException;
	List<ProductoPedidoDomain> consultarProductosPedidos(ProductoPedidoDomain filtro)throws LilfacException;

}
