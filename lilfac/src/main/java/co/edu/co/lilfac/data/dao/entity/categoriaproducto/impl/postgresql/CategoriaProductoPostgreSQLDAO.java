package co.edu.co.lilfac.data.dao.entity.categoriaproducto.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.categoriaproducto.CategoriaProductoDAO;
import co.edu.co.lilfac.entity.CategoriaProductoEntity;

public class CategoriaProductoPostgreSQLDAO implements CategoriaProductoDAO{
	
	private Connection conexion;
	
	public CategoriaProductoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(CategoriaProductoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriaProductoEntity> listByFIlter(CategoriaProductoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaProductoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, CategoriaProductoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
