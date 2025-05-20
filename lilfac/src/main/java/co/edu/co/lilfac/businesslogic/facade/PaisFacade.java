package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.PaisDTO;

public interface PaisFacade {
	
	void registrarNuevoPais(PaisDTO pais)throws LilfacException;
	void modificarPaisExistente(UUID id, PaisDTO pais)throws LilfacException;
	void darBajaDefinitivamentePaisExistente(UUID id)throws LilfacException;
	PaisDTO consultarPaisPorId(UUID id)throws LilfacException;
	List<PaisDTO> consultarPaises(PaisDTO filtro)throws LilfacException;

}
