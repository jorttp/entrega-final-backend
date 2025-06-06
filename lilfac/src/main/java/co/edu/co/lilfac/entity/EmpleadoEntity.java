package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class EmpleadoEntity {
	private UUID id;
	private String nombre;
	private String apellido;
	private Integer cedula;
	private Integer telefono;
	private String correo;
	private boolean objetoVacio;
	
	public EmpleadoEntity () {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setApellido(UtilTexto.getInstance().obtenerValorDefecto());
		setCedula(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public EmpleadoEntity (final UUID id, final String nombre, final String apellido, final Integer cedula, final Integer telefono, final String correo) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setCedula(cedula);
		setTelefono(telefono);
		setCorreo(correo);
		
	}
	
	public static EmpleadoEntity obtenerValorDefecto() {
		return new EmpleadoEntity();
	}
	
	public static EmpleadoEntity obtenerValorDefecto(final EmpleadoEntity empleado ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(empleado, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(apellido);
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(final Integer cedula) {
		this.cedula = UtilNumerico.obtenerValorDefecto(cedula);
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(final Integer telefono) {
		this.telefono = UtilNumerico.obtenerValorDefecto(telefono);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}

}
