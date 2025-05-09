package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;


public class CategoriaProductoEntity {
	
	private UUID id;
	private ProductoEntity producto;
	private CategoriaEntity categoria;
	
	public CategoriaProductoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setProducto(ProductoEntity.obtenerValorDefecto());
		setCategoria(CategoriaEntity.obtenerValorDefecto());
	}
	
	public CategoriaProductoEntity(final UUID id) {
		setId(id);
		setProducto(ProductoEntity.obtenerValorDefecto());
		setCategoria(CategoriaEntity.obtenerValorDefecto());
	}
	
	public CategoriaProductoEntity(final UUID id, final ProductoEntity producto, final CategoriaEntity categoria) {
		setId(id);
		setProducto(producto);
		setCategoria(categoria);
	}
	
	public static CategoriaProductoEntity obtenerValorDefecto() {
		return new CategoriaProductoEntity();
	}
	
	public static CategoriaProductoEntity obtenerValorDefecto(final CategoriaProductoEntity categoriaProducto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoriaProducto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = ProductoEntity.obtenerValorDefecto(producto);
	}
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria (CategoriaEntity categoria) {
		this.categoria = CategoriaEntity.obtenerValorDefecto(categoria);
	}

}
