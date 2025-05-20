package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;

public interface CategoriaProductoFacade {
	
	void registrarNuevaCategoriaProducto(CategoriaProductoDTO categoriaProducto)throws LilfacException;
	void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDTO categoriaProducto)throws LilfacException;
	void darBajaDefinitivamenteCategoriaProductoExistente(UUID id)throws LilfacException;
	CategoriaProductoDTO consultarCategoriaProductoPorId(UUID id)throws LilfacException;
	List<CategoriaProductoDTO> consultarCategoriasProducto(CategoriaProductoDTO filtro)throws LilfacException;

}
