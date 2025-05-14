package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class PedidoDomain {
	private UUID id;
	private String fechaReserva;
	private String fechaVencimiento;
	private String direccionEntrega;
	private float costo;
	private float abono;
	private float restante;
	private CiudadDomain ciudad;
	private ClienteDomain cliente;
	private EmpleadoDomain empleado;
	
	PedidoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setFechaReserva(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaVencimiento(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccionEntrega(UtilTexto.getInstance().obtenerValorDefecto());
		setCosto(UtilFloat.getInstance().obtenerValorDefecto());
		setAbono(UtilFloat.getInstance().obtenerValorDefecto());
		setRestante(UtilFloat.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDomain.obtenerValorDefecto());
		setCliente(ClienteDomain.obtenerValorDefecto());
		setEmpleado(EmpleadoDomain.obtenerValorDefecto());
	}
	
	public PedidoDomain(final UUID id, final String fechaReserva, final String fechaVencimiento, final String direccionEntrega, final float costo, final float abono, final float restante, final CiudadDomain ciudad, final ClienteDomain cliente, final EmpleadoDomain empleado) {
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
	
	static PedidoDomain obtenerValorDefecto() {
		return new PedidoDomain();
	}
	
	public static PedidoDomain obtenerValorDefecto(final PedidoDomain pedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pedido, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	private void setFechaReserva(String fechaReserva) {
		this.fechaReserva = UtilTexto.getInstance().obtenerValorDefecto(fechaReserva);
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	private void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = UtilTexto.getInstance().obtenerValorDefecto(fechaVencimiento);
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	private void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionEntrega);
	}

	public float getCosto() {
		return costo;
	}

	private void setCosto(float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public float getAbono() {
		return abono;
	}

	private void setAbono(float abono) {
		this.abono = UtilFloat.obtenerValorDefecto(abono);
	}

	public float getRestante() {
		return restante;
	}

	private void setRestante(float restante) {
		this.restante = UtilFloat.obtenerValorDefecto(restante);
	}

	public CiudadDomain getCiudad() {
		return ciudad;
	}

	private void setCiudad(CiudadDomain ciudad) {
		this.ciudad = CiudadDomain.obtenerValorDefecto(ciudad);
	}

	public ClienteDomain getCliente() {
		return cliente;
	}

	private void setCliente(ClienteDomain cliente) {
		this.cliente = ClienteDomain.obtenerValorDefecto(cliente);
	}

	public EmpleadoDomain getEmpleado() {
		return empleado;
	}

	private void setEmpleado(EmpleadoDomain empleado) {
		this.empleado = EmpleadoDomain.obtenerValorDefecto(empleado);
	}

}
