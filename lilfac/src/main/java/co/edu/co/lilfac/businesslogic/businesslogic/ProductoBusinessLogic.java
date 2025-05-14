package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;

public interface ProductoBusinessLogic {
	
	void registrarNuevoProducto(ProductoDomain producto);
	void modificarProductoExistente(UUID id, ProductoDomain producto);
	void darBajaDefinitivamenteProductoExistente(UUID id);
	ProductoDomain consultarProductoPorId(UUID id);
	List<ProductoDomain> consultarProductos(ProductoDomain filtro);

}
