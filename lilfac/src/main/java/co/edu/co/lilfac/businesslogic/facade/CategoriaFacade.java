package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.CategoriaDTO;

public interface CategoriaFacade {
	
	void registrarNuevaCategoria(CategoriaDTO categoria);
	void modificarCategoriaExistente(UUID id, CategoriaDTO categoria);
	void darBajaDefinitivamenteCategoriaExistente(UUID id);
	CategoriaDTO consultarCategoriaPorId(UUID id);
	List<CategoriaDTO> consultarCategorias(CategoriaDTO filtro);

}
