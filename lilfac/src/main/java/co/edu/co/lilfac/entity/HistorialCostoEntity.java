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
	private Integer codigo;
	private String fechaInicio;
	private String fechaFin;
	private Boolean estado;
	private Float costo;
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
	
	public HistorialCostoEntity(final UUID id, final Integer codigo, final String fechaInicio, final String fechaFin, final Boolean estado, final Float costo, final ProductoEntity producto) {
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
		return UtilObjeto.getInstance().obtenerValorDefecto(historialCosto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = UtilBoolean.obtenerValorDefecto(estado);
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = ProductoEntity.obtenerValorDefecto(producto);
	}

}
