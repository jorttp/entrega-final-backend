package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class PedidoDTO {
	private UUID id;
	private String fechaReserva;
	private String fechaVencimiento;
	private String direccionEntrega;
	private float costo;
	private float abono;
	private float restante;
	private CiudadDTO ciudad;
	private ClienteDTO cliente;
	private ProductoDTO producto;
	
	public PedidoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setFechaReserva(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaVencimiento(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccionEntrega(UtilTexto.getInstance().obtenerValorDefecto());
		setCosto(UtilFloat.getInstance().obtenerValorDefecto());
		setAbono(UtilFloat.getInstance().obtenerValorDefecto());
		setRestante(UtilFloat.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
		setCliente(ClienteDTO.obtenerValorDefecto());
		setProducto(ProductoDTO.obtenerValorDefecto());
	}
	
	public PedidoDTO(final UUID id, final String fechaReserva, final String fechaVencimiento, final String direccionEntrega, final float costo, final float abono, final float restante, final CiudadDTO ciudad, final ClienteDTO cliente, final ProductoDTO producto) {
		setId(id);
		setFechaReserva(fechaReserva);
		setFechaVencimiento(fechaVencimiento);
		setDireccionEntrega(direccionEntrega);
		setCosto(costo);
		setAbono(abono);
		setRestante(restante);
		setCiudad(ciudad);
		setCliente(cliente);
		setProducto(producto);
	}
	
	public static PedidoDTO obtenerValorDefecto() {
		return new PedidoDTO();
	}
	
	public static PedidoDTO obtenerValorDefecto(final PedidoDTO pedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pedido, new PedidoDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = UtilTexto.getInstance().obtenerValorDefecto(fechaReserva);
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = UtilTexto.getInstance().obtenerValorDefecto(fechaVencimiento);
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionEntrega);
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public float getAbono() {
		return abono;
	}

	public void setAbono(float abono) {
		this.abono = UtilFloat.obtenerValorDefecto(abono);
	}

	public float getRestante() {
		return restante;
	}

	public void setRestante(float restante) {
		this.restante = UtilFloat.obtenerValorDefecto(restante);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = ClienteDTO.obtenerValorDefecto(cliente);
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
	}

}
