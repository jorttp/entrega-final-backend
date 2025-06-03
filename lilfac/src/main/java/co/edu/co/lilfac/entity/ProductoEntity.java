package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class ProductoEntity {
	private UUID id;
	private String nombre;
	private Integer codigo;
	private String caracteristicas;
	private String estado;
	private boolean objetoVacio;
	
	public ProductoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());	
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public ProductoEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());	
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public ProductoEntity(final String nombre) {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(nombre);
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());	
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public ProductoEntity (final UUID id, final String nombre, final Integer codigo, final String caracteristicas, final String estado){
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setCaracteristicas(caracteristicas);
		setEstado(estado);
	}
	
	public static ProductoEntity obtenerValorDefecto() {
		return new ProductoEntity();
	}
	
	public static ProductoEntity obtenerValorDefecto(final ProductoEntity producto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(final Integer codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(final String caracteristicas) {
		this.caracteristicas = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(caracteristicas);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}
	
}
