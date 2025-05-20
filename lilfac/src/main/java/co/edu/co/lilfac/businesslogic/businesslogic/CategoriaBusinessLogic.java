package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface CategoriaBusinessLogic {
	
	void registrarNuevaCategoria(CategoriaDomain categoria) throws LilfacException;
	void modificarCategoriaExistente(UUID id, CategoriaDomain categoria)throws LilfacException;
	void darBajaDefinitivamenteCategoriaExistente(UUID id)throws LilfacException;
	CategoriaDomain consultarCategoriaPorId(UUID id)throws LilfacException;
	List<CategoriaDomain> consultarCategorias(CategoriaDomain filtro)throws LilfacException;

}
