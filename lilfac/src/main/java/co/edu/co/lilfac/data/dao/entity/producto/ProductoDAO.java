package co.edu.co.lilfac.data.dao.entity.producto;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.ProductoEntity;

public interface ProductoDAO 
		extends CreateDAO<ProductoEntity>, RetrieveDAO<ProductoEntity, UUID>, UpdateDAO<ProductoEntity, UUID>, DeleteDAO<UUID>{

}
