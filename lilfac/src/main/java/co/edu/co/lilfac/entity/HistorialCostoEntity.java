package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilBoolean;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class HistorialCostoEntity {
	private UUID id;
	private int codigo;
	private String fechaInicio;
	private String fechaFin;
	private boolean estado;
	private float costo;
	private ProductoEntity producto;
	
	public HistorialCostoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setFechaInicio(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaFin(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilBoolean.getInstance().obtenerValorDefecto());
		setCosto(UtilFloat.getInstance().obtenerValorDefecto());
		setProducto(ProductoEntity.obtenerValorDefecto());
	}
	
	public HistorialCostoEntity(final UUID id, final int codigo, final String fechaInicio, final String fechaFin, final boolean estado, final float costo, final ProductoEntity producto) {
		setId(id);
		setCodigo(codigo);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setEstado(estado);
		setCosto(costo);
		setProducto(producto);
	}
	
	public static HistorialCostoEntity obtenerValorDefecto() {
		return new HistorialCostoEntity();
	}
	
	public static HistorialCostoEntity obtenerValorDefecto(final HistorialCostoEntity historialCosto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(historialCosto, new HistorialCostoEntity());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = UtilTexto.getInstance().obtenerValorDefecto(fechaInicio);
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = UtilTexto.getInstance().obtenerValorDefecto(fechaFin);
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = UtilBoolean.obtenerValorDefecto(estado);
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = ProductoEntity.obtenerValorDefecto(producto);
	}

}
