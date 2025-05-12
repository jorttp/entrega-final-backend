package co.edu.co.lilfac.data.dao.entity.inventario;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.InventarioEntity;

public interface InventarioDAO 
		extends CreateDAO<InventarioEntity>, RetrieveDAO<InventarioEntity, UUID>, UpdateDAO<InventarioEntity, UUID>, DeleteDAO<UUID>{

}
