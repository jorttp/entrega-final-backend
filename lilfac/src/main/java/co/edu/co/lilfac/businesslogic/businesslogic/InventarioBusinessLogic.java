package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.InventarioDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface InventarioBusinessLogic {
	
	void registrarNuevoProductoInventario(InventarioDomain inventario)throws LilfacException;
	void modificarInventarioExistente(UUID id, InventarioDomain inventario)throws LilfacException;
	void darBajaDefinitivamenteInventarioExistente(UUID id)throws LilfacException;
	InventarioDomain consultarInventarioPorId(UUID id)throws LilfacException;
	
}
