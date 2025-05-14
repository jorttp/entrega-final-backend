package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;


public class CategoriaProductoDomain {
	
	private UUID id;
	private ProductoDomain producto;
	private CategoriaDomain categoria;
	
	CategoriaProductoDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setProducto(ProductoDomain.obtenerValorDefecto());
		setCategoria(CategoriaDomain.obtenerValorDefecto());
	}
	
	public CategoriaProductoDomain(final UUID id) {
		setId(id);
		setProducto(ProductoDomain.obtenerValorDefecto());
		setCategoria(CategoriaDomain.obtenerValorDefecto());
	}
	
	public CategoriaProductoDomain(final UUID id, final ProductoDomain producto, final CategoriaDomain categoria) {
		setId(id);
		setProducto(producto);
		setCategoria(categoria);
	}
	
	static CategoriaProductoDomain obtenerValorDefecto() {
		return new CategoriaProductoDomain();
	}
	
	public static CategoriaProductoDomain obtenerValorDefecto(final CategoriaProductoDomain categoriaProducto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoriaProducto, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public ProductoDomain getProducto() {
		return producto;
	}

	private void setProducto(ProductoDomain producto) {
		this.producto = ProductoDomain.obtenerValorDefecto(producto);
	}
	
	public CategoriaDomain getCategoria() {
		return categoria;
	}

	private void setCategoria (CategoriaDomain categoria) {
		this.categoria = CategoriaDomain.obtenerValorDefecto(categoria);
	}

}
