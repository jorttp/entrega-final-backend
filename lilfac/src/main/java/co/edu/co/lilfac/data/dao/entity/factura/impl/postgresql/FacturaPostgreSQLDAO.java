package co.edu.co.lilfac.data.dao.entity.factura.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.factura.FacturaDAO;
import co.edu.co.lilfac.entity.FacturaEntity;

public class FacturaPostgreSQLDAO implements FacturaDAO{
	
	private Connection conexion;
	
	public FacturaPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(FacturaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FacturaEntity> listByFIlter(FacturaEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, FacturaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
