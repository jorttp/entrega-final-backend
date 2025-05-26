package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilBoolean;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class HistorialCostoDTO {
	private UUID id;
	private Integer codigo;
	private String fechaInicio;
	private String fechaFin;
	private Boolean estado;
	private Float costo;
	private ProductoDTO producto;
	
	public HistorialCostoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigo(UtilNumerico.getInstance().obtenerValorDefecto());
		setFechaInicio(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaFin(UtilTexto.getInstance().obtenerValorDefecto());
		setEstado(UtilBoolean.getInstance().obtenerValorDefecto());
		setCosto(UtilFloat.getInstance().obtenerValorDefecto());
		setProducto(ProductoDTO.obtenerValorDefecto());
	}
	
	public HistorialCostoDTO(final UUID id, final Integer codigo, final String fechaInicio, final String fechaFin, final Boolean estado, final Float costo, final ProductoDTO producto) {
		setId(id);
		setCodigo(codigo);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setEstado(estado);
		setCosto(costo);
		setProducto(producto);
	}
	
	public static HistorialCostoDTO obtenerValorDefecto() {
		return new HistorialCostoDTO();
	}
	
	public static HistorialCostoDTO obtenerValorDefecto(final HistorialCostoDTO historialCosto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(historialCosto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public HistorialCostoDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public HistorialCostoDTO setCodigo(Integer codigo) {
		this.codigo = UtilNumerico.obtenerValorDefecto(codigo);
		return this;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public HistorialCostoDTO setFechaInicio(String fechaInicio) {
		this.fechaInicio = UtilTexto.getInstance().obtenerValorDefecto(fechaInicio);
		return this;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public HistorialCostoDTO setFechaFin(String fechaFin) {
		this.fechaFin = UtilTexto.getInstance().obtenerValorDefecto(fechaFin);
		return this;
	}

	public Boolean isEstado() {
		return estado;
	}

	public HistorialCostoDTO setEstado(Boolean estado) {
		this.estado = UtilBoolean.obtenerValorDefecto(estado);
		return this;
	}

	public Float getCosto() {
		return costo;
	}

	public HistorialCostoDTO setCosto(Float Float) {
		this.costo = UtilFloat.obtenerValorDefecto(Float);
		return this;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public HistorialCostoDTO setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
		return this;
	}

}
