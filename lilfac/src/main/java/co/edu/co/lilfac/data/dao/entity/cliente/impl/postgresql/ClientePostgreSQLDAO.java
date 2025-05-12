package co.edu.co.lilfac.data.dao.entity.cliente.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.cliente.ClienteDAO;
import co.edu.co.lilfac.entity.ClienteEntity;

public class ClientePostgreSQLDAO implements ClienteDAO{
	
	private Connection conexion;
	
	public ClientePostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(ClienteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClienteEntity> listByFIlter(ClienteEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, ClienteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
