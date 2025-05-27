package co.edu.co.lilfac.businesslogic.businesslogic.assembler.productopedido.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.entity.PedidoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoPedidoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.ProductoPedidoEntity;

public class ProductoPedidoEntityAssembler implements EntityAssembler<ProductoPedidoEntity, ProductoPedidoDomain>{
	
	private static final ProductoPedidoEntityAssembler INSTANCE = new ProductoPedidoEntityAssembler();
	
	private ProductoPedidoEntityAssembler(){
		super();
	}
	
	public static ProductoPedidoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public ProductoPedidoEntity toEntity(final ProductoPedidoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? ProductoPedidoEntity.obtenerValorDefecto() : 
			new ProductoPedidoEntity(domain.getId(), domain.getCantidad(), ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()), PedidoEntityAssembler.getInstance().toEntity(domain.getPedido()));
	}

	@Override
	public ProductoPedidoDomain toDomain(final ProductoPedidoEntity entity) {
		var productoPedidoEntityAEnsamblar = ProductoPedidoEntity.obtenerValorDefecto(entity);
		return new ProductoPedidoDomain(productoPedidoEntityAEnsamblar.getId(), productoPedidoEntityAEnsamblar.getCantidad(), ProductoEntityAssembler.getInstance().toDomain(productoPedidoEntityAEnsamblar.getProducto()), PedidoEntityAssembler.getInstance().toDomain(productoPedidoEntityAEnsamblar.getPedido()));
	}

	@Override
	public List<ProductoPedidoDomain> toDomain(List<ProductoPedidoEntity> entityList) {
		var listaResultado = new ArrayList<ProductoPedidoDomain>();
		
		for (ProductoPedidoEntity productoPedidoEntity : entityList) {
			listaResultado.add(toDomain(productoPedidoEntity));
		}
		return listaResultado;
	}

}
