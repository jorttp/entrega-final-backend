package co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoria.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.CategoriaEntity;

public class CategoriaEntityAssembler implements EntityAssembler<CategoriaEntity, CategoriaDomain>{
	
	private static final CategoriaEntityAssembler INSTANCE = new CategoriaEntityAssembler();
	
	private CategoriaEntityAssembler(){
		super();
	}
	
	public static CategoriaEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CategoriaEntity toEntity(final CategoriaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CategoriaEntity.obtenerValorDefecto() : 
			new CategoriaEntity(domain.getId(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public CategoriaDomain toDomain(final CategoriaEntity entity) {
		var categoriaEntityAEnsamblar = CategoriaEntity.obtenerValorDefecto(entity);
		return new CategoriaDomain(categoriaEntityAEnsamblar.getId(), categoriaEntityAEnsamblar.getNombre(), categoriaEntityAEnsamblar.getDescripcion());
	}

	@Override
	public List<CategoriaDomain> toDomain(List<CategoriaEntity> entityList) {
		var listaResultado = new ArrayList<CategoriaDomain>();
		
		for (CategoriaEntity categoriaEntity : entityList) {
			listaResultado.add(toDomain(categoriaEntity));
		}
		return listaResultado;
	}

}
