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
	private EmpleadoDTO empleado;
	
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
		setEmpleado(EmpleadoDTO.obtenerValorDefecto());
	}
	
	public PedidoDTO(final UUID id, final String fechaReserva, final String fechaVencimiento, final String direccionEntrega, final float costo, final float abono, final float restante, final CiudadDTO ciudad, final ClienteDTO cliente, final EmpleadoDTO empleado) {
		setId(id);
		setFechaReserva(fechaReserva);
		setFechaVencimiento(fechaVencimiento);
		setDireccionEntrega(direccionEntrega);
		setCosto(costo);
		setAbono(abono);
		setRestante(restante);
		setCiudad(ciudad);
		setCliente(cliente);
		setEmpleado(empleado);
	}
	
	public static PedidoDTO obtenerValorDefecto() {
		return new PedidoDTO();
	}
	
	public static PedidoDTO obtenerValorDefecto(final PedidoDTO pedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pedido, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public PedidoDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public PedidoDTO setFechaReserva(String fechaReserva) {
		this.fechaReserva = UtilTexto.getInstance().obtenerValorDefecto(fechaReserva);
		return this;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public PedidoDTO setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = UtilTexto.getInstance().obtenerValorDefecto(fechaVencimiento);
		return this;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public PedidoDTO setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionEntrega);
		return this;
	}

	public float getCosto() {
		return costo;
	}

	public PedidoDTO setCosto(float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
		return this;
	}

	public float getAbono() {
		return abono;
	}

	public PedidoDTO setAbono(float abono) {
		this.abono = UtilFloat.obtenerValorDefecto(abono);
		return this;
	}

	public float getRestante() {
		return restante;
	}

	public PedidoDTO setRestante(float restante) {
		this.restante = UtilFloat.obtenerValorDefecto(restante);
		return this;
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public PedidoDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
		return this;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public PedidoDTO setCliente(ClienteDTO cliente) {
		this.cliente = ClienteDTO.obtenerValorDefecto(cliente);
		return this;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public PedidoDTO setEmpleado(EmpleadoDTO empleado) {
		this.empleado = EmpleadoDTO.obtenerValorDefecto(empleado);
		return this;
	}

}
