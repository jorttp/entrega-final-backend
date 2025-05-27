package co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoriaproducto.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoria.entity.CategoriaEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.CategoriaProductoEntity;

public class CategoriaProductoEntityAssembler implements EntityAssembler<CategoriaProductoEntity, CategoriaProductoDomain>{
	
	private static final CategoriaProductoEntityAssembler INSTANCE = new CategoriaProductoEntityAssembler();
	
	private CategoriaProductoEntityAssembler(){
		super();
	}
	
	public static CategoriaProductoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CategoriaProductoEntity toEntity(final CategoriaProductoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CategoriaProductoEntity.obtenerValorDefecto() : 
			new CategoriaProductoEntity(domain.getId(), ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()), CategoriaEntityAssembler.getInstance().toEntity(domain.getCategoria()));
	}

	@Override
	public CategoriaProductoDomain toDomain(final CategoriaProductoEntity entity) {
		var categoriaProductoEntityAEnsamblar = CategoriaProductoEntity.obtenerValorDefecto(entity);
		return new CategoriaProductoDomain(categoriaProductoEntityAEnsamblar.getId(), ProductoEntityAssembler.getInstance().toDomain(categoriaProductoEntityAEnsamblar.getProducto()), CategoriaEntityAssembler.getInstance().toDomain(categoriaProductoEntityAEnsamblar.getCategoria()));
	}

	@Override
	public List<CategoriaProductoDomain> toDomain(List<CategoriaProductoEntity> entityList) {
		var listaResultado = new ArrayList<CategoriaProductoDomain>();
		
		for (CategoriaProductoEntity categoriaProductoEntity : entityList) {
			listaResultado.add(toDomain(categoriaProductoEntity));
		}
		return listaResultado;
	}

}
