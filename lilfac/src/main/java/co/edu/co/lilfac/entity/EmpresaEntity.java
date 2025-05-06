package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class EmpresaEntity {
	private UUID id;
	private String nombre;
	private int nit;
	private int telefono;
	private String correo;
	private String direccion;
	private CiudadEntity ciudad;
	
	public EmpresaEntity () {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setNit(UtilNumerico.getInstance().obtenerValorDefecto());
		setTelefono(UtilNumerico.getInstance().obtenerValorDefecto());
		setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadEntity.obtenerValorDefecto());
	}
	
	public EmpresaEntity (final UUID id, final String nombre, final int nit, final int telefono, final String correo, final String direccion, final CiudadEntity ciudad) {
		setId(id);
		setNombre(nombre);
		setNit(nit);		
		setTelefono(telefono);
		setCorreo(correo);
		setDireccion(direccion);
		setCiudad(ciudad);
	}
	
	public static EmpresaEntity obtenerValorDefecto() {
		return new EmpresaEntity();
	}
	
	public static EmpresaEntity obtenerValorDefecto(final EmpresaEntity empresa ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(empresa, new EmpresaEntity());
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

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(final CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
	}


}
