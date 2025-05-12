package co.edu.co.lilfac.data.dao.entity.cliente;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.ClienteEntity;

public interface ClienteDAO 
		extends CreateDAO<ClienteEntity>, RetrieveDAO<ClienteEntity, UUID>, UpdateDAO<ClienteEntity, UUID>, DeleteDAO<UUID>{

}
