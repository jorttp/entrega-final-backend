package co.edo.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.onlinetest.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilUUID;

public final class EmpresaDTO {
	private UUID id;
	private String nombre;
	private int nit;
	private int telefono;
	private String correo;
	private String direccion;
	private CiudadDTO ciudad;
	
	public EmpresaDTO () {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setNit(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
	}
	
	public EmpresaDTO (final UUID id, final String nombre, final int nit, final int telefono, final String correo, final String direccion, final CiudadDTO ciudad) {
		setId(id);
		setNombre(nombre);
		setNit(nit);		
		setTelefono(telefono);
		setCorreo(correo);
		setDireccion(direccion);
		setCiudad(ciudad);
	}
	
	public static EmpresaDTO obtenerValorDefecto() {
		return new EmpresaDTO();
	}
	
	public static EmpresaDTO obtenerValorDefecto(final EmpresaDTO empresa ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(empresa, new EmpresaDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id =  UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public int getNit() {
		return nit;
	}

	public void setNit(final int nit) {
		this.nit = UtilNumerico.obtenerValorDefecto(nit);
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(final int telefono) {
		this.telefono =UtilNumerico.obtenerValorDefecto(telefono);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(final String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(final CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
	}


}
