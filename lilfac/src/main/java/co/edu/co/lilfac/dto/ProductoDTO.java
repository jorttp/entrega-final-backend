package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class ProductoDTO {
	private UUID id;
	private String nombre;
	private int codigo;
	private String caracteristicas;
	private String estado;
	
	public ProductoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public ProductoDTO (final UUID id, final String nombre, final int codigo, final String caracteristicas, final String estado){
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setCaracteristicas(caracteristicas);
		setEstado(estado);
	}
	
	public static ProductoDTO obtenerValorDefecto() {
		return new ProductoDTO();
	}
	
	public static ProductoDTO obtenerValorDefecto(final ProductoDTO producto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public ProductoDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ProductoDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
		return this;
	}

	public int getCodigo() {
		return codigo;
	}

	public ProductoDTO setCodigo(final int codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
		return this;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public ProductoDTO setCaracteristicas(final String caracteristicas) {
		this.caracteristicas = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(caracteristicas);
		return this;
	}

	public String getEstado() {
		return estado;
	}

	public ProductoDTO setEstado(final String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
		return this;
	}
	
	
}
