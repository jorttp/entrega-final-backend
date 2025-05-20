package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface CategoriaProductoBusinessLogic {
	
	void registrarNuevaCategoriaProducto(CategoriaProductoDomain categoriaProducto)throws LilfacException;
	void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDomain categoriaProducto)throws LilfacException;
	void darBajaDefinitivamenteCategoriaProductoExistente(UUID id)throws LilfacException;
	CategoriaProductoDomain consultarCategoriaProductoPorId(UUID id)throws LilfacException;
	List<CategoriaProductoDomain> consultarCategoriasProducto(CategoriaProductoDomain filtro)throws LilfacException;

}
