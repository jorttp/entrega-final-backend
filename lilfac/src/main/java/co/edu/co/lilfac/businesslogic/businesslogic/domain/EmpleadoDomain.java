package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class EmpleadoDomain {
	private UUID id;
	private String nombre;
	private String apellido;
	private Integer cedula;
	private Integer telefono;
	private String correo;
	
	EmpleadoDomain () {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setApellido(UtilTexto.getInstance().obtenerValorDefecto());
		setCedula(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public EmpleadoDomain (final UUID id, final String nombre, final String apellido, final Integer cedula, final Integer telefono, final String correo) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setCedula(cedula);
		setTelefono(telefono);
		setCorreo(correo);
		
	}
	
	static EmpleadoDomain obtenerValorDefecto() {
		return new EmpleadoDomain();
	}
	
	public static EmpleadoDomain obtenerValorDefecto(final EmpleadoDomain empleado ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(empleado, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public String getApellido() {
		return apellido;
	}

	private void setApellido(final String apellido) {
		this.apellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellido);
	}

	public Integer getCedula() {
		return cedula;
	}

	private void setCedula(final Integer cedula) {
		this.cedula = UtilNumerico.obtenerValorDefecto(cedula);
	}

	public Integer getTelefono() {
		return telefono;
	}

	private void setTelefono(final Integer telefono) {
		this.telefono = UtilNumerico.obtenerValorDefecto(telefono);
	}

	public String getCorreo() {
		return correo;
	}

	private void setCorreo(final String correo) {
		this.correo = correo;
	}

}
