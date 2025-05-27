package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;


public class ProductoPedidoDomain {
	
	private UUID id;
	private Integer cantidad; 
	private ProductoDomain producto;
	private PedidoDomain pedido;
	
	ProductoPedidoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
		setProducto(ProductoDomain.obtenerValorDefecto());
		setPedido(PedidoDomain.obtenerValorDefecto());
	}
	
	public ProductoPedidoDomain(final UUID id) {
		setId(id);
		setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
		setProducto(ProductoDomain.obtenerValorDefecto());
		setPedido(PedidoDomain.obtenerValorDefecto());
	}
	
	public ProductoPedidoDomain(final UUID id, final Integer cantidad, final ProductoDomain producto, final PedidoDomain pedido) {
		setId(id);
		setCantidad(cantidad);
		setProducto(producto);
		setPedido(pedido);
	}
	
	static ProductoPedidoDomain obtenerValorDefecto() {
		return new ProductoPedidoDomain();
	}
	
	public static ProductoPedidoDomain obtenerValorDefecto(final ProductoPedidoDomain productoPedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(productoPedido, obtenerValorDefecto());
	}


	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public Integer getCantidad() {
		return cantidad;
	}
	
	private void setCantidad(Integer cantidad) {
		this.cantidad = UtilNumerico.obtenerValorDefecto(cantidad);
	}
	
	public ProductoDomain getProducto() {
		return producto;
	}

	private void setProducto(ProductoDomain producto) {
		this.producto = ProductoDomain.obtenerValorDefecto(producto);
	}
	
	public PedidoDomain getPedido() {
		return pedido;
	}

	private void setPedido(PedidoDomain pedido) {
		this.pedido = PedidoDomain.obtenerValorDefecto(pedido);
	}

}
