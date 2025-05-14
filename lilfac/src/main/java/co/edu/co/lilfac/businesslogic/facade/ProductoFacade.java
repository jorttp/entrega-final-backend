package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.ProductoDTO;

public interface ProductoFacade {
	
	void registrarNuevoProducto(ProductoDTO producto);
	void modificarProductoExistente(UUID id, ProductoDTO producto);
	void darBajaDefinitivamenteProductoExistente(UUID id);
	ProductoDTO consultarProductoPorId(UUID id);
	List<ProductoDTO> consultarProductos(ProductoDTO filtro);

}
