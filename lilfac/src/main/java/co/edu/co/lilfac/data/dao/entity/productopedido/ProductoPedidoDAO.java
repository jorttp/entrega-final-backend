package co.edu.co.lilfac.data.dao.entity.productopedido;

import java.util.UUID;

import co.edu.co.lilfac.data.dao.entity.CreateDAO;
import co.edu.co.lilfac.data.dao.entity.DeleteDAO;
import co.edu.co.lilfac.data.dao.entity.RetrieveDAO;
import co.edu.co.lilfac.data.dao.entity.UpdateDAO;
import co.edu.co.lilfac.entity.ProductoPedidoEntity;

public interface ProductoPedidoDAO 
		extends CreateDAO<ProductoPedidoEntity>, RetrieveDAO<ProductoPedidoEntity, UUID>, UpdateDAO<ProductoPedidoEntity, UUID>, DeleteDAO<UUID>{

}
