package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.CategoriaDTO;

public interface CategoriaFacade {
	
	void registrarNuevaCategoria(CategoriaDTO categoria)throws LilfacException;
	void modificarCategoriaExistente(UUID id, CategoriaDTO categoria)throws LilfacException;
	void darBajaDefinitivamenteCategoriaExistente(UUID id)throws LilfacException;
	CategoriaDTO consultarCategoriaPorId(UUID id)throws LilfacException;
	List<CategoriaDTO> consultarCategorias(CategoriaDTO filtro)throws LilfacException;

}
