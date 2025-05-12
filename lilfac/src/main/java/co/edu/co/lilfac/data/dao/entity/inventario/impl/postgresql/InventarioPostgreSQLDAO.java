package co.edu.co.lilfac.data.dao.entity.inventario.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.inventario.InventarioDAO;
import co.edu.co.lilfac.entity.InventarioEntity;

public class InventarioPostgreSQLDAO implements InventarioDAO{
	
	private Connection conexion;
	
	public InventarioPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}


	@Override
	public void create(InventarioEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InventarioEntity> listByFIlter(InventarioEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventarioEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventarioEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, InventarioEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
