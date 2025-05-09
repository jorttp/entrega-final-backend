package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class RecepcionDTO {
	private UUID id;
	private String fecha;
	private String estado;
	private String direccion;
	private CiudadDTO ciudad;
	private EmpleadoDTO empleado;
	private EntregaDTO entrega;
	
	public RecepcionDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setFecha(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccion(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
		setEmpleado(EmpleadoDTO.obtenerValorDefecto());
		setEntrega(EntregaDTO.obtenerValorDefecto());
	}
	
	public RecepcionDTO(final UUID id, final String fecha, final String estado, final String direccion, final CiudadDTO ciudad, final EmpleadoDTO empleado, final EntregaDTO entrega) {
		setId(id);
		setFecha(fecha);
		setEstado(estado);
		setDireccion(direccion);
		setCiudad(ciudad);
		setEmpleado(empleado);
		setEntrega(entrega);
	}
	
	public static RecepcionDTO obtenerValorDefecto() {
		return new RecepcionDTO();
	}
	
	public static RecepcionDTO obtenerValorDefecto(final RecepcionDTO recepcion ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(recepcion, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public RecepcionDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getFecha() {
		return fecha;
	}

	public RecepcionDTO setFecha(String fecha) {
		this.fecha = UtilTexto.getInstance().obtenerValorDefecto(fecha);
		return this;
	}
	
	public String getEstado() {
		return estado;
	}

	public RecepcionDTO setEstado(String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
		return this;
	}

	public String getDireccion() {
		return direccion;
	}

	public RecepcionDTO setDireccion(String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
		return this;
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public RecepcionDTO setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
		return this;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public RecepcionDTO setEmpleado(EmpleadoDTO empleado) {
		this.empleado = EmpleadoDTO.obtenerValorDefecto(empleado);
		return this;
	}

	public EntregaDTO getEntrega() {
		return entrega;
	}

	public RecepcionDTO setEntrega(EntregaDTO entrega) {
		this.entrega = EntregaDTO.obtenerValorDefecto(entrega);
		return this;
	}

}
