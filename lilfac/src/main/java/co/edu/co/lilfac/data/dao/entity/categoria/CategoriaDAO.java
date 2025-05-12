package co.edu.co.lilfac.data.dao.entity.categoria;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.CategoriaEntity;

public interface CategoriaDAO 
		extends CreateDAO<CategoriaEntity>, RetrieveDAO<CategoriaEntity, UUID>, UpdateDAO<CategoriaEntity, UUID>, DeleteDAO<UUID>{

}
