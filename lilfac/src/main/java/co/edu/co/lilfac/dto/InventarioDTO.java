package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
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
	
	public static InventarioDTO obtenerValorDefecto() {
		return new InventarioDTO();
	}
	
	public static InventarioDTO obtenerValorDefecto(final InventarioDTO inventario ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(inventario, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public InventarioDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public int getTotalUnidades() {
		return totalUnidades;
	}

	public InventarioDTO setTotalUnidades(int totalUnidades) {
		this.totalUnidades = UtilNumerico.obtenerValorDefecto(totalUnidades);
		return this;
	}

	public int getUnidadesAlquiladas() {
		return unidadesAlquiladas;
	}

	public InventarioDTO setUnidadesAlquiladas(int unidadesAlquiladas) {
		this.unidadesAlquiladas = UtilNumerico.obtenerValorDefecto(unidadesAlquiladas);
		return this;
	}

	public int getUnidadesAfectadas() {
		return unidadesAfectadas;
	}

	public InventarioDTO setUnidadesAfectadas(int unidadesAfectadas) {
		this.unidadesAfectadas = UtilNumerico.obtenerValorDefecto(unidadesAfectadas);
		return this;
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public InventarioDTO setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = UtilNumerico.obtenerValorDefecto(unidadesDisponibles);
		return this;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public InventarioDTO setEmpresa(EmpresaDTO empresa) {
		this.empresa = EmpresaDTO.obtenerValorDefecto(empresa);
		return this;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public InventarioDTO setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
		return this;
	}

	public HistorialCostoDTO getHistorialCosto() {
		return historialCosto;
	}

	public InventarioDTO setHistorialCosto(HistorialCostoDTO historialCosto) {
		this.historialCosto = HistorialCostoDTO.obtenerValorDefecto(historialCosto);
		return this;
	}

}
