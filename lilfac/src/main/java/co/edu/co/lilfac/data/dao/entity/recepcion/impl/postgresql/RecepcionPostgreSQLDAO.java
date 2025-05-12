package co.edu.co.lilfac.data.dao.entity.recepcion.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.recepcion.RecepcionDAO;
import co.edu.co.lilfac.entity.RecepcionEntity;

public class RecepcionPostgreSQLDAO implements RecepcionDAO{
	
	private Connection conexion;
	
	public RecepcionPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(RecepcionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecepcionEntity> listByFIlter(RecepcionEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecepcionEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecepcionEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, RecepcionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
