package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class EmpresaDomain {
	private UUID id;
	private String nombre;
	private int nit;
	private int telefono;
	private String correo;
	private String direccion;
	private CiudadDomain ciudad;
	
	EmpresaDomain () {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setNit(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDomain.obtenerValorDefecto());
	}
	
	public EmpresaDomain (final UUID id, final String nombre, final int nit, final int telefono, final String correo, final String direccion, final CiudadDomain ciudad) {
		setId(id);
		setNombre(nombre);
		setNit(nit);		
		setTelefono(telefono);
		setCorreo(correo);
		setDireccion(direccion);
		setCiudad(ciudad);
	}
	
	static EmpresaDomain obtenerValorDefecto() {
		return new EmpresaDomain();
	}
	
	public static EmpresaDomain obtenerValorDefecto(final EmpresaDomain empresa ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(empresa, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id =  UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public int getNit() {
		return nit;
	}

	private void setNit(final int nit) {
		this.nit = UtilNumerico.obtenerValorDefecto(nit);
	}

	public int getTelefono() {
		return telefono;
	}

	private void setTelefono(final int telefono) {
		this.telefono =UtilNumerico.obtenerValorDefecto(telefono);
	}

	public String getCorreo() {
		return correo;
	}

	private void setCorreo(final String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(final String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
	}

	public CiudadDomain getCiudad() {
		return ciudad;
	}

	private void setCiudad(final CiudadDomain ciudad) {
		this.ciudad = CiudadDomain.obtenerValorDefecto(ciudad);
	}


}
