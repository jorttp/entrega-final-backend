package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.InventarioBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.InventarioDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.HistorialCostoEntity;
import co.edu.co.lilfac.entity.InventarioEntity;

public class InventarioBusinessLogicImpl implements InventarioBusinessLogic {
	
private DAOFactory factory;
	
	public InventarioBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void registrarNuevoProductoInventario(InventarioDomain inventario) throws LilfacException {
		InventarioEntity inventarioEntity = null;
		factory.getInventarioDAO().create(inventarioEntity);
	}

	@Override
	public void modificarInventarioExistente(UUID id, InventarioDomain inventario) throws LilfacException {
		InventarioEntity inventarioEntity = null;
		factory.getInventarioDAO().update(id, inventarioEntity);
	}

	@Override
	public void darBajaDefinitivamenteInventarioExistente(UUID id) throws LilfacException {
		InventarioEntity inventarioEntity = null;
		factory.getInventarioDAO().delete(id);
	}

	@Override
	public InventarioDomain consultarInventarioPorId(UUID id) throws LilfacException {
		InventarioEntity InventarioFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		InventarioEntity InventarioCostoEntity = factory.getInventarioDAO().listById(id);
		
		InventarioDomain datosARetornar = null;
		return datosARetornar;
	}

}
