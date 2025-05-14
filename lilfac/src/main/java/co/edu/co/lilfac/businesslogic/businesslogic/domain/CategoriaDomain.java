package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class CategoriaDomain {
	private UUID id;
	private String nombre;
	private String descripcion;
	
	CategoriaDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public CategoriaDomain(final UUID id, final String nombre, final String descripcion) {
		setId(id);
		setNombre(nombre);
	}
	
	static CategoriaDomain obtenerValorDefecto() {
		return new CategoriaDomain();
	}
	
	public static CategoriaDomain obtenerValorDefecto(final CategoriaDomain categoria ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoria, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
	}

}
