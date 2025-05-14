package co.edu.co.lilfac.data.dao.entity.ciudad;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.CiudadEntity;

public interface CiudadDAO 
		extends CreateDAO<CiudadEntity>, RetrieveDAO<CiudadEntity, UUID>, UpdateDAO<CiudadEntity, UUID>, DeleteDAO<UUID>{

}
