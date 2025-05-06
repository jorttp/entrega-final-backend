package co.edo.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.onlinetest.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.co.onlinetest.crosscutting.utilitarios.UtilUUID;

public final class ProductoEntity {
	private UUID id;
	private String nombre;
	private int codigo;
	private String caracteristicas;
	
	public ProductoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());		
	}
	
	public ProductoEntity (final UUID id, final String nombre, final int codigo, final String caracteristicas){
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setCaracteristicas(caracteristicas);
	}
	
	public static ProductoEntity obtenerValorDefecto() {
		return new ProductoEntity();
	}
	
	public static ProductoEntity obtenerValorDefecto(final ProductoEntity producto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(producto, new ProductoEntity());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(final int codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(final String caracteristicas) {
		this.caracteristicas = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(caracteristicas);
	}
	
}
