package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class CategoriaEntity {
	private UUID id;
	private String nombre;
	private String descripcion;
	private boolean objetoVacio;
	
	public CategoriaEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
	}
	public CategoriaEntity(final String nombre) {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(nombre);
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public CategoriaEntity(final UUID id, final String nombre, final String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static CategoriaEntity obtenerValorDefecto() {
		return new CategoriaEntity();
	}
	
	public static CategoriaEntity obtenerValorDefecto(final CategoriaEntity categoria ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoria, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
	}
	
	public boolean isObjetoVacio() {
		return objetoVacio;
	}

}
