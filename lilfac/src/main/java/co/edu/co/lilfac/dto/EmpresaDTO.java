package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

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
		return UtilObjeto.getInstance().obtenerValorDefecto(empresa, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public EmpresaDTO setId(final UUID id) {
		this.id =  UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public EmpresaDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
		return this;
	}

	public int getNit() {
		return nit;
	}

	public EmpresaDTO setNit(final int nit) {
		this.nit = UtilNumerico.obtenerValorDefecto(nit);
		return this;
	}

	public int getTelefono() {
		return telefono;
	}

	public EmpresaDTO setTelefono(final int telefono) {
		this.telefono =UtilNumerico.obtenerValorDefecto(telefono);
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public EmpresaDTO setCorreo(final String correo) {
		this.correo = correo;
		return this;
	}

	public String getDireccion() {
		return direccion;
	}

	public EmpresaDTO setDireccion(final String direccion) {
		this.direccion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccion);
		return this;
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public EmpresaDTO setCiudad(final CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
		return this;
	}


}
