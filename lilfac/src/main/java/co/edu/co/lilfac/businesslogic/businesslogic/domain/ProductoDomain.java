package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class ProductoDomain {
	private UUID id;
	private String nombre;
	private Integer codigo;
	private String caracteristicas;
	private String estado;
	
	public ProductoDomain(final String nombre) {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(nombre);
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());	
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	public ProductoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());	
		setEstado(UtilTexto.getInstance().obtenerValorDefecto());
	}
	
	
	public ProductoDomain (final UUID id, final String nombre, final Integer codigo, final String caracteristicas, final String estado){
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setCaracteristicas(caracteristicas);
		setEstado(estado);
	}
	
	static ProductoDomain obtenerValorDefecto() {
		return new ProductoDomain();
	}
	
	public static ProductoDomain obtenerValorDefecto(final ProductoDomain producto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public Integer getCodigo() {
		return codigo;
	}

	private void setCodigo(final Integer codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	private void setCaracteristicas(final String caracteristicas) {
		this.caracteristicas = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(caracteristicas);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(estado);
	}
	
}
