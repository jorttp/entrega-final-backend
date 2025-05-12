package co.edu.co.lilfac.data.dao.entity.pedido.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.pedido.PedidoDAO;
import co.edu.co.lilfac.entity.PedidoEntity;

public class PedidoPostgreSQLDAO implements PedidoDAO{
	
	private Connection conexion;
	
	public PedidoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(PedidoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PedidoEntity> listByFIlter(PedidoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, PedidoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
