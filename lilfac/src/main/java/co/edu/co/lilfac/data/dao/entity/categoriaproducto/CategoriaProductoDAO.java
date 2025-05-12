package co.edu.co.lilfac.data.dao.entity.categoriaproducto;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.CategoriaProductoEntity;

public interface CategoriaProductoDAO 
		extends CreateDAO<CategoriaProductoEntity>, RetrieveDAO<CategoriaProductoEntity, UUID>, UpdateDAO<CategoriaProductoEntity, UUID>, DeleteDAO<UUID>{

}
