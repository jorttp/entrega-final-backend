package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class InventarioEntity {
	private UUID id;
	private Integer totalUnidades;
	private Integer unidadesAlquiladas;
	private Integer unidadesAfectadas;
	private Integer unidadesDisponibles;
	private EmpresaEntity empresa;
	private ProductoEntity producto;
	private HistorialCostoEntity historialCosto;
	private boolean objetoVacio;
	
	public InventarioEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setTotalUnidades(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAlquiladas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAfectadas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesDisponibles(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaEntity.obtenerValorDefecto());
		setProducto(ProductoEntity.obtenerValorDefecto());
		setHistorialCosto(HistorialCostoEntity.obtenerValorDefecto());
	}
	
	public InventarioEntity(final UUID id, final Integer totalUnidades, final Integer unidadesAlquiladas, final Integer unidadesAfectadas, final Integer unidadesDisponibles, final EmpresaEntity empresa, final ProductoEntity producto, final HistorialCostoEntity historialCosto) {
		setId(id);
		setTotalUnidades(totalUnidades);
		setUnidadesAlquiladas(unidadesAlquiladas);
		setUnidadesAfectadas(unidadesAfectadas);
		setUnidadesDisponibles(unidadesDisponibles);
		setEmpresa(empresa);
		setProducto(producto);
		setHistorialCosto(historialCosto);
	}
	
	public static InventarioEntity obtenerValorDefecto() {
		return new InventarioEntity();
	}
	
	public static InventarioEntity obtenerValorDefecto(final InventarioEntity inventario ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(inventario, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public Integer getTotalUnidades() {
		return totalUnidades;
	}

	public void setTotalUnidades(Integer totalUnidades) {
		this.totalUnidades = UtilNumerico.obtenerValorDefecto(totalUnidades);
	}

	public Integer getUnidadesAlquiladas() {
		return unidadesAlquiladas;
	}

	public void setUnidadesAlquiladas(Integer unidadesAlquiladas) {
		this.unidadesAlquiladas = UtilNumerico.obtenerValorDefecto(unidadesAlquiladas);
	}

	public Integer getUnidadesAfectadas() {
		return unidadesAfectadas;
	}

	public void setUnidadesAfectadas(Integer unidadesAfectadas) {
		this.unidadesAfectadas = UtilNumerico.obtenerValorDefecto(unidadesAfectadas);
	}

	public Integer getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(Integer unidadesDisponibles) {
		this.unidadesDisponibles = UtilNumerico.obtenerValorDefecto(unidadesDisponibles);
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = EmpresaEntity.obtenerValorDefecto(empresa);
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = ProductoEntity.obtenerValorDefecto();
	}

	public HistorialCostoEntity getHistorialCosto() {
		return historialCosto;
	}

	public void setHistorialCosto(HistorialCostoEntity historialCosto) {
		this.historialCosto = HistorialCostoEntity.obtenerValorDefecto(historialCosto);
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}

}
