package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface ProductoBusinessLogic {
	
	void registrarNuevoProducto(ProductoDomain producto)throws LilfacException;
	void modificarProductoExistente(UUID id, ProductoDomain producto)throws LilfacException;
	void darBajaDefinitivamenteProductoExistente(UUID id)throws LilfacException;
	ProductoDomain consultarProductoPorId(UUID id)throws LilfacException;
	List<ProductoDomain> consultarProductos(ProductoDomain filtro)throws LilfacException;

}
