package co.edu.co.lilfac.data.dao.entity.empresa.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.empresa.EmpresaDAO;
import co.edu.co.lilfac.entity.EmpresaEntity;

public class EmpresaPostgreSQLDAO implements EmpresaDAO{
	
	private Connection conexion;
	
	public EmpresaPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}


	@Override
	public void create(EmpresaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpresaEntity> listByFIlter(EmpresaEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpresaEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpresaEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, EmpresaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
