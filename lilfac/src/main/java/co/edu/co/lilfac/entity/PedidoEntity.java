package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class PedidoEntity {
	private UUID id;
	private String fechaReserva;
	private String fechaVencimiento;
	private String direccionEntrega;
	private Float costo;
	private Float abono;
	private Float restante;
	private CiudadEntity ciudad;
	private ClienteEntity cliente;
	private EmpleadoEntity empleado;
	private boolean objetoVacio;
	
	public PedidoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setFechaReserva(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaVencimiento(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccionEntrega(UtilTexto.getInstance().obtenerValorDefecto());
		setCosto(UtilFloat.getInstance().obtenerValorDefecto());
		setAbono(UtilFloat.getInstance().obtenerValorDefecto());
		setRestante(UtilFloat.getInstance().obtenerValorDefecto());
		setCiudad(CiudadEntity.obtenerValorDefecto());
		setCliente(ClienteEntity.obtenerValorDefecto());
		setEmpleado(EmpleadoEntity.obtenerValorDefecto());
	}
	
	public PedidoEntity(final UUID id, final String fechaReserva, final String fechaVencimiento, final String direccionEntrega, final Float costo, final Float abono, final Float restante, final CiudadEntity ciudad, final ClienteEntity cliente, final EmpleadoEntity empleado) {
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
	
	public static PedidoEntity obtenerValorDefecto() {
		return new PedidoEntity();
	}
	
	public static PedidoEntity obtenerValorDefecto(final PedidoEntity pedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pedido, obtenerValorDefecto());
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

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public Float getAbono() {
		return abono;
	}

	public void setAbono(Float abono) {
		this.abono = UtilFloat.obtenerValorDefecto(abono);
	}

	public Float getRestante() {
		return restante;
	}

	public void setRestante(Float restante) {
		this.restante = UtilFloat.obtenerValorDefecto(restante);
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = ClienteEntity.obtenerValorDefecto(cliente);
	}

	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = EmpleadoEntity.obtenerValorDefecto(empleado);
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}

}
