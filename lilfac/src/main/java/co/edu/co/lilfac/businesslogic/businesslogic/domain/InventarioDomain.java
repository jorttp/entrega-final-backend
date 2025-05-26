package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class InventarioDomain {
	private UUID id;
	private Integer totalUnidades;
	private Integer unidadesAlquiladas;
	private Integer unidadesAfectadas;
	private Integer unidadesDisponibles;
	private EmpresaDomain empresa;
	private ProductoDomain producto;
	private HistorialCostoDomain historialCosto;
	
	InventarioDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setTotalUnidades(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAlquiladas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAfectadas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesDisponibles(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaDomain.obtenerValorDefecto());
		setProducto(ProductoDomain.obtenerValorDefecto());
		setHistorialCosto(HistorialCostoDomain.obtenerValorDefecto());
	}
	
	public InventarioDomain(final UUID id, final Integer totalUnidades, final Integer unidadesAlquiladas, final Integer unidadesAfectadas, final Integer unidadesDisponibles, final EmpresaDomain empresa, final ProductoDomain producto, final HistorialCostoDomain historialCosto) {
		setId(id);
		setTotalUnidades(totalUnidades);
		setUnidadesAlquiladas(unidadesAlquiladas);
		setUnidadesAfectadas(unidadesAfectadas);
		setUnidadesDisponibles(unidadesDisponibles);
		setEmpresa(empresa);
		setProducto(producto);
		setHistorialCosto(historialCosto);
	}
	
	static InventarioDomain obtenerValorDefecto() {
		return new InventarioDomain();
	}
	
	public static InventarioDomain obtenerValorDefecto(final InventarioDomain inventario ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(inventario, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public Integer getTotalUnidades() {
		return totalUnidades;
	}

	private void setTotalUnidades(Integer totalUnidades) {
		this.totalUnidades = UtilNumerico.obtenerValorDefecto(totalUnidades);
	}

	public Integer getUnidadesAlquiladas() {
		return unidadesAlquiladas;
	}

	private void setUnidadesAlquiladas(Integer unidadesAlquiladas) {
		this.unidadesAlquiladas = UtilNumerico.obtenerValorDefecto(unidadesAlquiladas);
	}

	public Integer getUnidadesAfectadas() {
		return unidadesAfectadas;
	}

	private void setUnidadesAfectadas(Integer unidadesAfectadas) {
		this.unidadesAfectadas = UtilNumerico.obtenerValorDefecto(unidadesAfectadas);
	}

	public Integer getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	private void setUnidadesDisponibles(Integer unidadesDisponibles) {
		this.unidadesDisponibles = UtilNumerico.obtenerValorDefecto(unidadesDisponibles);
	}

	public EmpresaDomain getEmpresa() {
		return empresa;
	}

	private void setEmpresa(EmpresaDomain empresa) {
		this.empresa = EmpresaDomain.obtenerValorDefecto(empresa);
	}

	public ProductoDomain getProducto() {
		return producto;
	}

	private void setProducto(ProductoDomain producto) {
		this.producto = ProductoDomain.obtenerValorDefecto(producto);
	}

	public HistorialCostoDomain getHistorialCosto() {
		return historialCosto;
	}

	private void setHistorialCosto(HistorialCostoDomain historialCosto) {
		this.historialCosto = HistorialCostoDomain.obtenerValorDefecto(historialCosto);
	}

}
