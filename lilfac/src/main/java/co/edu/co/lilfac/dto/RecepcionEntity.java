package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class RecepcionEntity {
	private UUID id;
	private String fecha;
	private String estado;
	private String direccion;
	private CiudadDTO ciudad;
	private EmpleadoDTO empleado;
	private EntregaDTO entrega;
	
	public RecepcionEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setFecha(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccion(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
		setEmpleado(EmpleadoDTO.obtenerValorDefecto());
		setEntrega(EntregaDTO.obtenerValorDefecto());
	}
	
	public RecepcionEntity(final UUID id, final String fecha, final String estado, final String direccion, final CiudadDTO ciudad, final EmpleadoDTO empleado, final EntregaDTO entrega) {
		setId(id);
		setFecha(fecha);
		setEstado(estado);
		setDireccion(direccion);
		setCiudad(ciudad);
		setEmpleado(empleado);
		setEntrega(entrega);
	}
	
	public static RecepcionEntity obtenerValorDefecto() {
		return new RecepcionEntity();
	}
	
	public static RecepcionEntity obtenerValorDefecto(final RecepcionEntity pedido ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(pedido, new RecepcionEntity());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = UtilTexto.getInstance().obtenerValorDefecto(fecha);
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDTO empleado) {
		this.empleado = EmpleadoDTO.obtenerValorDefecto(empleado);
	}

	public EntregaDTO getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaDTO entrega) {
		this.entrega = EntregaDTO.obtenerValorDefecto(entrega);
	}

}
