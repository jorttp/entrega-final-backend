package co.edu.co.lilfac.data.dao.entity.empleado.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.empleado.EmpleadoDAO;
import co.edu.co.lilfac.entity.EmpleadoEntity;

public class EmpleadoPostgreSQLDAO implements EmpleadoDAO{
	
	private Connection conexion;
	
	public EmpleadoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(EmpleadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpleadoEntity> listByFIlter(EmpleadoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, EmpleadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
