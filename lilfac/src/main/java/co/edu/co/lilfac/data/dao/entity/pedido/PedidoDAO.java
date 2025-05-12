package co.edu.co.lilfac.data.dao.entity.pedido;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.PedidoEntity;

public interface PedidoDAO 
		extends CreateDAO<PedidoEntity>, RetrieveDAO<PedidoEntity, UUID>, UpdateDAO<PedidoEntity, UUID>, DeleteDAO<UUID>{

}
