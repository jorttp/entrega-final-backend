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
	private Integer codigo;
	private String fechaInicio;
	private String fechaFin;
	private Boolean estado;
	private Float costo;
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
	
	public HistorialCostoDomain(final UUID id, final Integer codigo, final String fechaInicio, final String fechaFin, final Boolean estado, final Float costo, final ProductoDomain producto) {
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

	public Integer getCodigo() {
		return codigo;
	}

	private void setCodigo(Integer codigo) {
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

	public Boolean isEstado() {
		return estado;
	}

	private void setEstado(Boolean estado) {
		this.estado = UtilBoolean.obtenerValorDefecto(estado);
	}

	public Float getCosto() {
		return costo;
	}

	private void setCosto(Float costo) {
		this.costo = UtilFloat.obtenerValorDefecto(costo);
	}

	public ProductoDomain getProducto() {
		return producto;
	}

	private void setProducto(ProductoDomain producto) {
		this.producto = ProductoDomain.obtenerValorDefecto(producto);
	}

}
