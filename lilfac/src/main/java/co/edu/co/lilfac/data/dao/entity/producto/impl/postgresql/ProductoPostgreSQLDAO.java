package co.edu.co.lilfac.data.dao.entity.producto.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.producto.ProductoDAO;
import co.edu.co.lilfac.entity.ProductoEntity;

public class ProductoPostgreSQLDAO implements ProductoDAO{
	
	private Connection conexion;
	
	public ProductoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}


	@Override
	public void create(ProductoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductoEntity> listByFIlter(ProductoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, ProductoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
