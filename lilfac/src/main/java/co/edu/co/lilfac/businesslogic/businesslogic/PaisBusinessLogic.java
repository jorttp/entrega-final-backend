package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface PaisBusinessLogic {
	
	void registrarNuevoPais(PaisDomain pais)throws LilfacException;
	void modificarPaisExistente(UUID id, PaisDomain pais)throws LilfacException;
	void darBajaDefinitivamentePaisExistente(UUID id)throws LilfacException;
	PaisDomain consultarPaisPorId(UUID id)throws LilfacException;
	List<PaisDomain> consultarPaises(PaisDomain filtro)throws LilfacException;

}
