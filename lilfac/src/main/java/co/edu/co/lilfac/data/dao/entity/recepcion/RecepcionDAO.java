package co.edu.co.lilfac.data.dao.entity.recepcion;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.RecepcionEntity;

public interface RecepcionDAO 
		extends CreateDAO<RecepcionEntity>, RetrieveDAO<RecepcionEntity, UUID>, UpdateDAO<RecepcionEntity, UUID>, DeleteDAO<UUID>{

}
