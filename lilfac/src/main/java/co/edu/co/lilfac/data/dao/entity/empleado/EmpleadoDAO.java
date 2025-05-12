package co.edu.co.lilfac.data.dao.entity.empleado;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.EmpleadoEntity;

public interface EmpleadoDAO 
		extends CreateDAO<EmpleadoEntity>, RetrieveDAO<EmpleadoEntity, UUID>, UpdateDAO<EmpleadoEntity, UUID>, DeleteDAO<UUID>{

}
