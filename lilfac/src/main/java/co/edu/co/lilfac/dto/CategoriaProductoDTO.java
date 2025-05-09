package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;


public class CategoriaProductoDTO {
	
	private UUID id;
	private ProductoDTO producto;
	private CategoriaDTO categoria;
	
	public CategoriaProductoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setProducto(ProductoDTO.obtenerValorDefecto());
		setCategoria(CategoriaDTO.obtenerValorDefecto());
	}
	
	public CategoriaProductoDTO(final UUID id) {
		setId(id);
		setProducto(ProductoDTO.obtenerValorDefecto());
		setCategoria(CategoriaDTO.obtenerValorDefecto());
	}
	
	public CategoriaProductoDTO(final UUID id, final ProductoDTO producto, final CategoriaDTO categoria) {
		setId(id);
		setProducto(producto);
		setCategoria(categoria);
	}

	public static CategoriaProductoDTO obtenerValorDefecto() {
		return new CategoriaProductoDTO();
	}
	
	public static CategoriaProductoDTO obtenerValorDefecto(final CategoriaProductoDTO categoriaProducto ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(categoriaProducto, obtenerValorDefecto());
	}
	
	public UUID getId() {
		return id;
	}

	public CategoriaProductoDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}
	
	public ProductoDTO getProducto() {
		return producto;
	}

	public CategoriaProductoDTO setProducto(ProductoDTO producto) {
		this.producto = ProductoDTO.obtenerValorDefecto(producto);
		return this;
	}
	
	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public CategoriaProductoDTO setCategoria (CategoriaDTO categoria) {
		this.categoria = CategoriaDTO.obtenerValorDefecto(categoria);
		return this;
	}

}
