package co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.ProductoEntity;

public class ProductoEntityAssembler implements EntityAssembler<ProductoEntity, ProductoDomain>{
	
	private static final ProductoEntityAssembler INSTANCE = new ProductoEntityAssembler();
	
	private ProductoEntityAssembler(){
		super();
	}
	
	public static ProductoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public ProductoEntity toEntity(final ProductoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? ProductoEntity.obtenerValorDefecto() : 
			new ProductoEntity(domain.getId(), domain.getNombre(), domain.getCodigo(), domain.getCaracteristicas(), domain.getEstado());
	}

	@Override
	public ProductoDomain toDomain(final ProductoEntity entity) {
		var productoEntityAEnsamblar = ProductoEntity.obtenerValorDefecto(entity);
		return new ProductoDomain(productoEntityAEnsamblar.getId(), productoEntityAEnsamblar.getNombre(), productoEntityAEnsamblar.getCodigo(), productoEntityAEnsamblar.getCaracteristicas(), productoEntityAEnsamblar.getEstado());
	}

	@Override
	public List<ProductoDomain> toDomain(List<ProductoEntity> entityList) {
		var listaResultado = new ArrayList<ProductoDomain>();
		
		for (ProductoEntity productoEntity : entityList) {
			listaResultado.add(toDomain(productoEntity));
		}
		return listaResultado;
	}

}
