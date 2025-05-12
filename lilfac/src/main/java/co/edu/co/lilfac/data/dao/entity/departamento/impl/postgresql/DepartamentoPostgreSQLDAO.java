package co.edu.co.lilfac.data.dao.entity.departamento.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.co.lilfac.entity.DepartamentoEntity;

public class DepartamentoPostgreSQLDAO implements DepartamentoDAO{
	
	private Connection conexion;
	
	public DepartamentoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(DepartamentoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DepartamentoEntity> listByFIlter(DepartamentoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, DepartamentoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
