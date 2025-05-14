package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;

public interface CategoriaProductoBusinessLogic {
	
	void registrarNuevaCategoriaProducto(CategoriaProductoDomain categoriaProducto);
	void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDomain categoriaProducto);
	void darBajaDefinitivamenteCategoriaProductoExistente(UUID id);
	CategoriaProductoDomain consultarCategoriaProductoPorId(UUID id);
	List<CategoriaProductoDomain> consultarCategoriasProducto(CategoriaProductoDomain filtro);

}
