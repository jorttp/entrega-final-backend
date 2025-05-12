package co.edu.co.lilfac.data.dao.entity.entrega;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.EntregaEntity;

public interface EntregaDAO 
		extends CreateDAO<EntregaEntity>, RetrieveDAO<EntregaEntity, UUID>, UpdateDAO<EntregaEntity, UUID>, DeleteDAO<UUID>{

}
