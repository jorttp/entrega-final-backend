package co.edu.co.lilfac.data.dao.entity.historialcosto.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.historialcosto.HistorialCostoDAO;
import co.edu.co.lilfac.entity.HistorialCostoEntity;

public class HistorialCostoPostgreSQLDAO implements HistorialCostoDAO{
	
	private Connection conexion;
	
	public HistorialCostoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(HistorialCostoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HistorialCostoEntity> listByFIlter(HistorialCostoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistorialCostoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialCostoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, HistorialCostoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
