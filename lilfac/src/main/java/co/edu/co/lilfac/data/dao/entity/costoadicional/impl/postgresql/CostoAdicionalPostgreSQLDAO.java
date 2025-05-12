package co.edu.co.lilfac.data.dao.entity.costoadicional.impl.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.costoadicional.CostoAdicionalDAO;
import co.edu.co.lilfac.entity.CostoAdicionalEntity;

public class CostoAdicionalPostgreSQLDAO implements CostoAdicionalDAO{
	
	private Connection conexion;
	
	public CostoAdicionalPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(CostoAdicionalEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CostoAdicionalEntity> listByFIlter(CostoAdicionalEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostoAdicionalEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CostoAdicionalEntity listById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UUID id, CostoAdicionalEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
