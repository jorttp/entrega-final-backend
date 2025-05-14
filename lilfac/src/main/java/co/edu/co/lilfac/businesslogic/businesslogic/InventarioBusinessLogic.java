package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.InventarioDomain;

public interface InventarioBusinessLogic {
	
	void registrarNuevoProductoInventario(InventarioDomain inventario);
	void modificarInventarioExistente(UUID id, InventarioDomain inventario);
	void darBajaDefinitivamenteInventarioExistente(UUID id);
	InventarioDomain consultarInventarioPorId(UUID id);
	
}
