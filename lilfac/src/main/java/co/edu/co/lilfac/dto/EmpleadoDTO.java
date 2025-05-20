package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class EmpleadoDTO {
	private UUID id;
	private String nombre;
	private String apellido;
	private int cedula;
	private int telefono;
	private String correo;
	
	public EmpleadoDTO () {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setApellido(UtilTexto.getInstance().obtenerValorDefecto());
		setCedula(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public EmpleadoDTO (final UUID id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setCedula(cedula);
		setTelefono(telefono);
		setCorreo(correo);
		
	}
	
	public static EmpleadoDTO obtenerValorDefecto() {
		return new EmpleadoDTO();
	}
	
	public static EmpleadoDTO obtenerValorDefecto(final EmpleadoDTO empleado ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(empleado, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public EmpleadoDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public EmpleadoDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
		return this;
	}

	public String getApellido() {
		return apellido;
	}

	public EmpleadoDTO setApellido(final String apellido) {
		this.apellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellido);
		return this;
	}

	public int getCedula() {
		return cedula;
	}

	public EmpleadoDTO setCedula(final int cedula) {
		this.cedula = UtilNumerico.obtenerValorDefecto(cedula);
		return this;
	}

	public int getTelefono() {
		return telefono;
	}

	public EmpleadoDTO setTelefono(final int telefono) {
		this.telefono = UtilNumerico.obtenerValorDefecto(telefono);
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public EmpleadoDTO setCorreo(final String correo) {
		this.correo = correo;
		return this;
	}

}
