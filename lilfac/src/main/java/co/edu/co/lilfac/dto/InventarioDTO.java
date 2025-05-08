package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class InventarioDTO {
	private UUID id;
	private int totalUnidades;
	private int unidadesAlquiladas;
	private int unidadesAfectadas;
	private int unidadesDisponibles;
	private EmpresaDTO empresa;
	private ProductoDTO producto;
	private HistorialCostoDTO historialCosto;
	
	public InventarioDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setTotalUnidades(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAlquiladas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAfectadas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesDisponibles(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaDTO.obtenerValorDefecto());
		setProducto(ProductoDTO.obtenerValorDefecto());
		setHistorialCosto(HistorialCostoDTO.obtenerValorDefecto());
	}
	
	public InventarioDTO(final UUID id, final int totalUnidades, final int unidadesAlquiladas, final int unidadesAfectadas, final int unidadesDisponibles, final EmpresaDTO empresa, final ProductoDTO producto, final HistorialCostoDTO historialCosto) {
		setId(id);
		setTotalUnidades(totalUnidades);
		setUnidadesAlquiladas(unidadesAlquiladas);
		setUnidadesAfectadas(unidadesAfectadas);
		setUnidadesDisponibles(unidadesDisponibles);
		setEmpresa(empresa);
		setProducto(producto);
		setHistorialCosto(historialCosto);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public int getTotalUnidades() {
		return totalUnidades;
	}

	public void setTotalUnidades(int totalUnidades) {
		this.totalUnidades = UtilNumerico.obtenerValorDefecto(totalUnidades);
	}

	public int getUnidadesAlquiladas() {
		return unidadesAlquiladas;
	}

	public void setUnidadesAlquiladas(int unidadesAlquiladas) {
		this.unidadesAlquiladas = UtilNumerico.obtenerValorDefecto(unidadesAlquiladas);
	}

	public int getUnidadesAfectadas() {
		return unidadesAfectadas;
	}

	public void setUnidadesAfectadas(int unidadesAfectadas) {
		this.unidadesAfectadas = UtilNumerico.obtenerValorDefecto(unidadesAfectadas);
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = UtilNumerico.obtenerValorDefecto(unidadesDisponibles);
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = EmpresaDTO.obtenerValorDefecto(empresa);
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
	}

	public HistorialCostoDTO getHistorialCosto() {
		return historialCosto;
	}

	public void setHistorialCosto(HistorialCostoDTO historialCosto) {
		this.historialCosto = HistorialCostoDTO.obtenerValorDefecto(historialCosto);
	}

}
