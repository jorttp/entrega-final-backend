package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.CategoriaProductoDTO;

public interface CategoriaProductoFacade {
	
	void registrarNuevaCategoriaProducto(CategoriaProductoDTO categoriaProducto);
	void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDTO categoriaProducto);
	void darBajaDefinitivamenteCategoriaProductoExistente(UUID id);
	CategoriaProductoDTO consultarCategoriaProductoPorId(UUID id);
	List<CategoriaProductoDTO> consultarCategoriasProducto(CategoriaProductoDTO filtro);

}
