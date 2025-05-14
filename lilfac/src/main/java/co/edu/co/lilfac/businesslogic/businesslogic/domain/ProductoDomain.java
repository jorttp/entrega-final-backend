package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class ProductoDomain {
	private UUID id;
	private String nombre;
	private int codigo;
	private String caracteristicas;
	
	ProductoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setCaracteristicas(UtilTexto.getInstance().obtenerValorDefecto());		
	}
	
	public ProductoDomain (final UUID id, final String nombre, final int codigo, final String caracteristicas){
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setCaracteristicas(caracteristicas);
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

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(final int codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	private void setCaracteristicas(final String caracteristicas) {
		this.caracteristicas = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(caracteristicas);
	}
	
}
