package co.edu.co.lilfac.dto;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;

public class EmpleadoDTO {
	private int id;
	private String nombre;
	private String apellido;
	private int cedula;
	private int telefono;
	private String correo;
	
	public EmpleadoDTO () {
		setId(UtilNumerico.getInstance().obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setApellido(UtilTexto.getInstance().obtenerValorDefecto());
		setCedula(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public EmpleadoDTO (final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo) {
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
		return UtilObjeto.getInstance().obtenerValorDefecto(empleado, new EmpleadoDTO());
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = UtilNumerico.obtenerValorDefecto(id);
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

	public int getCedula() {
		return cedula;
	}

	public void setCedula(final int cedula) {
		this.cedula = UtilNumerico.obtenerValorDefecto(cedula);
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(final int telefono) {
		this.telefono = UtilNumerico.obtenerValorDefecto(telefono);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

}
