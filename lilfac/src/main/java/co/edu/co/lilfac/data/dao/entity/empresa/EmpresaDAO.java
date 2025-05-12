package co.edu.co.lilfac.data.dao.entity.empresa;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.EmpresaEntity;

public interface EmpresaDAO 
		extends CreateDAO<EmpresaEntity>, RetrieveDAO<EmpresaEntity, UUID>, UpdateDAO<EmpresaEntity, UUID>, DeleteDAO<UUID>{

}
