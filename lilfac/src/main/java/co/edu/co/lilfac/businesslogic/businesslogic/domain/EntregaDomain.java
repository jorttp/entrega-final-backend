package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class EntregaDomain {
	private UUID id;
	private String fecha;
	private String estado;
	private String direccion;
	private CiudadDomain ciudad;
	private EmpleadoDomain empleado;
	private PedidoDomain pedido;
	
	EntregaDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setFecha(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccion(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDomain.obtenerValorDefecto());
		setEmpleado(EmpleadoDomain.obtenerValorDefecto());
		setPedido(PedidoDomain.obtenerValorDefecto());
	}
	
	public EntregaDomain(final UUID id, final String fecha, final String estado, final String direccion, final CiudadDomain ciudad, final EmpleadoDomain empleado, final PedidoDomain pedido) {
		setId(id);
		setFecha(fecha);
		setEstado(estado);
		setDireccion(direccion);
		setCiudad(ciudad);
		setEmpleado(empleado);
		setPedido(pedido);
	}
	
	static EntregaDomain obtenerValorDefecto() {
		return new EntregaDomain();
	}
	
	public static EntregaDomain obtenerValorDefecto(final EntregaDomain entrega ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(entrega, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getFecha() {
		return fecha;
	}

	private void setFecha(String fecha) {
		this.fecha = UtilTexto.getInstance().obtenerValorDefecto(fecha);
	}
	
	public String getEstado() {
		return estado;
	}

	private void setEstado(String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
	}

	public CiudadDomain getCiudad() {
		return ciudad;
	}

	private void setCiudad(CiudadDomain ciudad) {
		this.ciudad = CiudadDomain.obtenerValorDefecto(ciudad);
	}

	public EmpleadoDomain getEmpleado() {
		return empleado;
	}

	private void setEmpleado(EmpleadoDomain empleado) {
		this.empleado = EmpleadoDomain.obtenerValorDefecto(empleado);
	}

	public PedidoDomain getPedido() {
		return pedido;
	}

	private void setPedido(PedidoDomain pedido) {
		this.pedido = PedidoDomain.obtenerValorDefecto(pedido);
	}

}
