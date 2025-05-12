package co.edu.co.lilfac.data.dao.entity.entrega.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.entrega.EntregaDAO;
import co.edu.co.lilfac.entity.EntregaEntity;

public class EntregaPostgreSQLDAO implements EntregaDAO{
	
	private Connection conexion;
	
	public EntregaPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(EntregaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntregaEntity> listByFIlter(EntregaEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntregaEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntregaEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, EntregaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
