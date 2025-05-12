package co.edu.co.lilfac.data.dao.entity.historialcosto;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.HistorialCostoEntity;

public interface HistorialCostoDAO 
		extends CreateDAO<HistorialCostoEntity>, RetrieveDAO<HistorialCostoEntity, UUID>, UpdateDAO<HistorialCostoEntity, UUID>, DeleteDAO<UUID>{

}
