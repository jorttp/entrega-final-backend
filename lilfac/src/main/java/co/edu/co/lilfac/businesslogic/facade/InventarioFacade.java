package co.edu.co.lilfac.businesslogic.facade;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.InventarioDTO;

public interface InventarioFacade {
	
	void registrarNuevoProductoInventario(InventarioDTO inventario)throws LilfacException;
	void modificarInventarioExistente(UUID id, InventarioDTO inventario)throws LilfacException;
	void darBajaDefinitivamenteInventarioExistente(UUID id)throws LilfacException;
	InventarioDTO consultarInventarioPorId(UUID id)throws LilfacException;
	
}
