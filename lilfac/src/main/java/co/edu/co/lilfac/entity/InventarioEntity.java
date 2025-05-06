package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class InventarioEntity {
	private UUID id;
	private int totalUnidades;
	private int unidadesAlquiladas;
	private int unidadesAfectadas;
	private int unidadesDisponibles;
	private EmpresaEntity empresa;
	private ProductoEntity producto;
	private float costoUnitario;
	
	public InventarioEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setTotalUnidades(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAlquiladas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesAfectadas(UtilNumerico.getInstance().obtenerValorDefecto());
		setUnidadesDisponibles(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaEntity.obtenerValorDefecto());
		setProducto(ProductoEntity.obtenerValorDefecto());
		setCostoUnitario(UtilFloat.getInstance().obtenerValorDefecto());
	}
	
	public InventarioEntity(final UUID id, final int totalUnidades, final int unidadesAlquiladas, final int unidadesAfectadas, final int unidadesDisponibles, final EmpresaEntity empresa, final ProductoEntity producto, final float costoUnitario) {
		setId(id);
		setTotalUnidades(totalUnidades);
		setUnidadesAlquiladas(unidadesAlquiladas);
		setUnidadesAfectadas(unidadesAfectadas);
		setUnidadesDisponibles(unidadesDisponibles);
		setEmpresa(empresa);
		setProducto(producto);
		setCostoUnitario(costoUnitario);
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
		this.producto = ProductoEntity.obtenerValorDefecto(producto);
	}

	public float getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(float costoUnitario) {
		this.costoUnitario = UtilFloat.obtenerValorDefecto(costoUnitario);
	}

}
