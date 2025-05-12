package co.edu.co.lilfac.data.dao.entity.productopedido.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.productopedido.ProductoPedidoDAO;
import co.edu.co.lilfac.entity.ProductoPedidoEntity;

public class ProductoPedidoPostgreSQLDAO implements ProductoPedidoDAO{
	
	private Connection conexion;
	
	public ProductoPedidoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(ProductoPedidoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductoPedidoEntity> listByFIlter(ProductoPedidoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoPedidoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoPedidoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, ProductoPedidoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
