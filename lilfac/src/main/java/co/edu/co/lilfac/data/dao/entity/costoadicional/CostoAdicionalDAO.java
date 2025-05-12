package co.edu.co.lilfac.data.dao.entity.costoadicional;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.CostoAdicionalEntity;

public interface CostoAdicionalDAO 
		extends CreateDAO<CostoAdicionalEntity>, RetrieveDAO<CostoAdicionalEntity, UUID>, UpdateDAO<CostoAdicionalEntity, UUID>, DeleteDAO<UUID>{

}
