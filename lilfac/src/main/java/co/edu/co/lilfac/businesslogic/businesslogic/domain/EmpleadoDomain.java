package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;

public class EmpleadoDomain {
	private int id;
	private String nombre;
	private String apellido;
	private int cedula;
	private int telefono;
	private String correo;
	
	EmpleadoDomain () {
		setId(UtilNumerico.getInstance().obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setApellido(UtilTexto.getInstance().obtenerValorDefecto());
		setCedula(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public EmpleadoDomain (final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo) {
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

	public int getId() {
		return id;
	}

	private void setId(final int id) {
		this.id = UtilNumerico.obtenerValorDefecto(id);
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

	public int getCedula() {
		return cedula;
	}

	private void setCedula(final int cedula) {
		this.cedula = UtilNumerico.obtenerValorDefecto(cedula);
	}

	public int getTelefono() {
		return telefono;
	}

	private void setTelefono(final int telefono) {
		this.telefono = UtilNumerico.obtenerValorDefecto(telefono);
	}

	public String getCorreo() {
		return correo;
	}

	private void setCorreo(final String correo) {
		this.correo = correo;
	}

}
