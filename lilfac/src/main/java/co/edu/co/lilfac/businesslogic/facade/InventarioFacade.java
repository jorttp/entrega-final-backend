package co.edu.co.lilfac.businesslogic.facade;

import java.util.UUID;

import co.edu.co.lilfac.dto.InventarioDTO;

public interface InventarioFacade {
	
	void registrarNuevoProductoInventario(InventarioDTO inventario);
	void modificarInventarioExistente(UUID id, InventarioDTO inventario);
	void darBajaDefinitivamenteInventarioExistente(UUID id);
	InventarioDTO consultarInventarioPorId(UUID id);
	
}
