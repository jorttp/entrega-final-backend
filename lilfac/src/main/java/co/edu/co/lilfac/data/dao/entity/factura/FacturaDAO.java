package co.edu.co.lilfac.data.dao.entity.factura;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.FacturaEntity;

public interface FacturaDAO 
		extends CreateDAO<FacturaEntity>, RetrieveDAO<FacturaEntity, UUID>, UpdateDAO<FacturaEntity, UUID>, DeleteDAO<UUID>{

}
