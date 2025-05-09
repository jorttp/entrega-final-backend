package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;


public class ProductoPedidoEntity {
	
	private UUID id;
	private int cantidad; 
	private ProductoEntity producto;
	private PedidoEntity pedido;
	
	public ProductoPedidoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
		setProducto(ProductoEntity.obtenerValorDefecto());
		setPedido(PedidoEntity.obtenerValorDefecto());
	}
	
	public ProductoPedidoEntity(final UUID id) {
		setId(id);
		setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
		setProducto(ProductoEntity.obtenerValorDefecto());
		setPedido(PedidoEntity.obtenerValorDefecto());
	}
	
	public ProductoPedidoEntity(final UUID id, final int cantidad, final ProductoEntity producto, final PedidoEntity pedido) {
		setId(id);
		setCantidad(cantidad);
		setProducto(producto);
		setPedido(pedido);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = UtilNumerico.obtenerValorDefecto(cantidad);
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = ProductoEntity.obtenerValorDefecto(producto);
	}
	
	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = PedidoEntity.obtenerValorDefecto(pedido);
	}

}
