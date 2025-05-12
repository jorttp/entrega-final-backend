package co.edu.co.lilfac.data.dao.entity.pais.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.pais.PaisDAO;
import co.edu.co.lilfac.entity.PaisEntity;

public class PaisPostgreSQLDAO implements PaisDAO{
	
	private Connection conexion;
	
	public PaisPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisEntity> listByFIlter(PaisEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
