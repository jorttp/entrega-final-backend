package co.edo.co.lilfac.dto;

import co.edu.co.onlinetest.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilTexto;

public final class UsuarioDTO {
	private int id;
	private String nombre;
	private String apellido;
	private int cedula;
	private int telefono;
	private String correo;
	
	public UsuarioDTO () {
		setId(UtilNumerico.getInstance().obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setApellido(UtilTexto.getInstance().obtenerValorDefecto());
		setCedula(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public UsuarioDTO (final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setCedula(cedula);
		setTelefono(telefono);
		setCorreo(correo);
	}
	
	public static UsuarioDTO obtenerValorDefecto() {
		return new UsuarioDTO();
	}
	
	public static UsuarioDTO obtenerValorDefecto(final UsuarioDTO usuario ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(usuario, new UsuarioDTO());
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
