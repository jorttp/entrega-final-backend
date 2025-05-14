package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;

public interface CategoriaBusinessLogic {
	
	void registrarNuevaCategoria(CategoriaDomain categoria);
	void modificarCategoriaExistente(UUID id, CategoriaDomain categoria);
	void darBajaDefinitivamenteCategoriaExistente(UUID id);
	CategoriaDomain consultarCategoriaPorId(UUID id);
	List<CategoriaDomain> consultarCategorias(CategoriaDomain filtro);

}
