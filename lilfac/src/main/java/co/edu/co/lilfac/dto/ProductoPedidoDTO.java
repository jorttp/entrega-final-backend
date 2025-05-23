package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;


public class ProductoPedidoDTO {
	
	private UUID id;
	private Integer cantidad; 
	private ProductoDTO producto;
	private PedidoDTO pedido;
	
	public ProductoPedidoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
		setProducto(ProductoDTO.obtenerValorDefecto());
		setPedido(PedidoDTO.obtenerValorDefecto());
	}
	
	public ProductoPedidoDTO(final UUID id) {
		setId(id);
		setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
		setProducto(ProductoDTO.obtenerValorDefecto());
		setPedido(PedidoDTO.obtenerValorDefecto());
	}
	
	public ProductoPedidoDTO(final UUID id, final Integer cantidad, final ProductoDTO producto, final PedidoDTO pedido) {
		setId(id);
		setCantidad(cantidad);
		setProducto(producto);
		setPedido(pedido);
	}
	
	public static ProductoPedidoDTO obtenerValorDefecto() {
		return new ProductoPedidoDTO();
	}
	
	public static ProductoPedidoDTO obtenerValorDefecto(final ProductoPedidoDTO productoPedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(productoPedido, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public ProductoPedidoDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	
	public ProductoPedidoDTO setCantidad(Integer cantidad) {
		this.cantidad = UtilNumerico.obtenerValorDefecto(cantidad);
		return this;
	}
	
	public ProductoDTO getProducto() {
		return producto;
	}

	public ProductoPedidoDTO setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
		return this;
	}
	
	public PedidoDTO getPedido() {
		return pedido;
	}

	public ProductoPedidoDTO setPedido(PedidoDTO pedido) {
		this.pedido = PedidoDTO.obtenerValorDefecto(pedido);
		return this;
	}

}
