package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class EntregaDTO {
	private UUID id;
	private String fecha;
	private String estado;
	private String direccion;
	private CiudadDTO ciudad;
	private EmpleadoDTO empleado;
	private PedidoDTO pedido;
	
	public EntregaDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setFecha(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccion(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
		setEmpleado(EmpleadoDTO.obtenerValorDefecto());
		setPedido(PedidoDTO.obtenerValorDefecto());
	}
	
	public EntregaDTO(final UUID id, final String fecha, final String estado, final String direccion, final CiudadDTO ciudad, final EmpleadoDTO empleado, final PedidoDTO pedido) {
		setId(id);
		setFecha(fecha);
		setEstado(estado);
		setDireccion(direccion);
		setCiudad(ciudad);
		setEmpleado(empleado);
		setPedido(pedido);
	}
	
	public static EntregaDTO obtenerValorDefecto() {
		return new EntregaDTO();
	}
	
	public static EntregaDTO obtenerValorDefecto(final EntregaDTO entrega ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(entrega, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public EntregaDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getFecha() {
		return fecha;
	}

	public EntregaDTO setFecha(String fecha) {
		this.fecha = UtilTexto.getInstance().obtenerValorDefecto(fecha);
		return this;
	}
	
	public String getEstado() {
		return estado;
	}

	public EntregaDTO setEstado(String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
		return this;
	}

	public String getDireccion() {
		return direccion;
	}

	public EntregaDTO setDireccion(String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
		return this;
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public EntregaDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
		return this;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public EntregaDTO setEmpleado(EmpleadoDTO empleado) {
		this.empleado = EmpleadoDTO.obtenerValorDefecto(empleado);
		return this;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public EntregaDTO setPedido(PedidoDTO pedido) {
		this.pedido = PedidoDTO.obtenerValorDefecto(pedido);
		return this;
	}

}
