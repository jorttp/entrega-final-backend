package co.edu.co.lilfac.entity;

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
	private CiudadEntity ciudad;
	private EmpleadoEntity empleado;
	private EntregaEntity entrega;
	
	public RecepcionEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setFecha(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
		setDireccion(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadEntity.obtenerValorDefecto());
		setEmpleado(EmpleadoEntity.obtenerValorDefecto());
		setEntrega(EntregaEntity.obtenerValorDefecto());
	}
	
	public RecepcionEntity(final UUID id, final String fecha, final String estado, final String direccion, final CiudadEntity ciudad, final EmpleadoEntity empleado, final EntregaEntity entrega) {
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

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
	}

	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = EmpleadoEntity.obtenerValorDefecto(empleado);
	}

	public EntregaEntity getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaEntity entrega) {
		this.entrega = EntregaEntity.obtenerValorDefecto(entrega);
	}

}
