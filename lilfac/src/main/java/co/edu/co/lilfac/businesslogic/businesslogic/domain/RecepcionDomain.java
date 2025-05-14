package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class RecepcionDomain {
	private UUID id;
	private String fecha;
	private String estado;
	private String direccion;
	private CiudadDomain ciudad;
	private EmpleadoDomain empleado;
	private EntregaDomain entrega;
	
	RecepcionDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setFecha(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccion(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDomain.obtenerValorDefecto());
		setEmpleado(EmpleadoDomain.obtenerValorDefecto());
		setEntrega(EntregaDomain.obtenerValorDefecto());
	}
	
	public RecepcionDomain(final UUID id, final String fecha, final String estado, final String direccion, final CiudadDomain ciudad, final EmpleadoDomain empleado, final EntregaDomain entrega) {
		setId(id);
		setFecha(fecha);
		setEstado(estado);
		setDireccion(direccion);
		setCiudad(ciudad);
		setEmpleado(empleado);
		setEntrega(entrega);
	}
	
	static RecepcionDomain obtenerValorDefecto() {
		return new RecepcionDomain();
	}
	
	public static RecepcionDomain obtenerValorDefecto(final RecepcionDomain recepcion ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(recepcion, obtenerValorDefecto());
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

	public EntregaDomain getEntrega() {
		return entrega;
	}

	private void setEntrega(EntregaDomain entrega) {
		this.entrega = EntregaDomain.obtenerValorDefecto(entrega);
	}

}
