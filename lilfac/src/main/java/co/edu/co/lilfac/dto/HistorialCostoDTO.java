package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilBoolean;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.entity.HistorialCostoEntity;

public class HistorialCostoDTO {
	private UUID id;
	private int codigo;
	private String fechaInicio;
	private String fechaFin;
	private boolean estado;
	private float costo;
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
	
	public HistorialCostoDTO(final UUID id, final int codigo, final String fechaInicio, final String fechaFin, final boolean estado, final float costo, final ProductoDTO producto) {
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
		return UtilObjeto.getInstance().obtenerValorDefecto(historialCosto, new HistorialCostoDTO());
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

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
	}

}
