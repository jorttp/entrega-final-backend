package co.edu.co.lilfac.data.dao.entity.pais;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.PaisEntity;

public interface PaisDAO 
		extends CreateDAO<PaisEntity>, RetrieveDAO<PaisEntity, UUID>, UpdateDAO<PaisEntity, UUID>, DeleteDAO<UUID>{

}
