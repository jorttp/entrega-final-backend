package co.edu.co.lilfac.data.dao.entity.categoria.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.categoria.CategoriaDAO;
import co.edu.co.lilfac.entity.CategoriaEntity;

public class CategoriaPostgreSQLDAO implements CategoriaDAO{
	
	private Connection conexion;
	
	public CategoriaPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(CategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriaEntity> listByFIlter(CategoriaEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, CategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
