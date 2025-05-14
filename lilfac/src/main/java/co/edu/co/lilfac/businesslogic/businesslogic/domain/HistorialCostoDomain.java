package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilBoolean;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class HistorialCostoDomain {
	private UUID id;
	private int codigo;
	private String fechaInicio;
	private String fechaFin;
	private boolean estado;
	private float costo;
	private ProductoDomain producto;
	
	HistorialCostoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setFechaInicio(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaFin(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilBoolean.getInstance().obtenerValorDefecto());
		setCosto(UtilFloat.getInstance().obtenerValorDefecto());
		setProducto(ProductoDomain.obtenerValorDefecto());
	}
	
	public HistorialCostoDomain(final UUID id, final int codigo, final String fechaInicio, final String fechaFin, final boolean estado, final float costo, final ProductoDomain producto) {
		setId(id);
		setCodigo(codigo);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setEstado(estado);
		setCosto(costo);
		setProducto(producto);
	}
	
	static HistorialCostoDomain obtenerValorDefecto() {
		return new HistorialCostoDomain();
	}
	
	public static HistorialCostoDomain obtenerValorDefecto(final HistorialCostoDomain historialCosto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(historialCosto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	private void setFechaInicio(String fechaInicio) {
		this.fechaInicio = UtilTexto.getInstance().obtenerValorDefecto(fechaInicio);
	}

	public String getFechaFin() {
		return fechaFin;
	}

	private void setFechaFin(String fechaFin) {
		this.fechaFin = UtilTexto.getInstance().obtenerValorDefecto(fechaFin);
	}

	public boolean isEstado() {
		return estado;
	}

	private void setEstado(boolean estado) {
		this.estado = UtilBoolean.obtenerValorDefecto(estado);
	}

	public float getCosto() {
		return costo;
	}

	private void setCosto(float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public ProductoDomain getProducto() {
		return producto;
	}

	private void setProducto(ProductoDomain producto) {
		this.producto = ProductoDomain.obtenerValorDefecto(producto);
	}

}
