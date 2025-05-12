package co.edu.co.lilfac.data.dao.entity.ciudad;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.DepartamentoEntity;

public interface CiudadDAO 
		extends CreateDAO<DepartamentoEntity>, RetrieveDAO<DepartamentoEntity, UUID>, UpdateDAO<DepartamentoEntity, UUID>, DeleteDAO<UUID>{

}
