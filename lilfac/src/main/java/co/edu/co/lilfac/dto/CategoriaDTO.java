package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class CategoriaDTO {
	private UUID id;
	private String nombre;
	private String descripcion;
	
	public CategoriaDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public CategoriaDTO(final UUID id, final String nombre, final String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static CategoriaDTO obtenerValorDefecto() {
		return new CategoriaDTO();
	}
	
	public static CategoriaDTO obtenerValorDefecto(final CategoriaDTO categoria ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoria, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public CategoriaDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public CategoriaDTO setNombre(String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
		return this;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public CategoriaDTO setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
		return this;
	}

}
