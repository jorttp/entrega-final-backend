package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.ProductoDTO;

public interface ProductoFacade {
	
	void registrarNuevoProducto(ProductoDTO producto)throws LilfacException;
	void modificarProductoExistente(UUID id, ProductoDTO producto)throws LilfacException;
	void darBajaDefinitivamenteProductoExistente(UUID id)throws LilfacException;
	ProductoDTO consultarProductoPorId(UUID id)throws LilfacException;
	List<ProductoDTO> consultarProductosFiltro(ProductoDTO filtro)throws LilfacException;
	List<ProductoDTO>consultarProductos()throws LilfacException;
}
