package co.edu.co.lilfac.businesslogic.businesslogic.assembler.pais.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.PaisEntity;

public class PaisEntityAssembler implements EntityAssembler<PaisEntity, PaisDomain>{
	
	private static final PaisEntityAssembler INSTANCE = new PaisEntityAssembler();
	
	private PaisEntityAssembler(){
		super();
	}
	
	public static PaisEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public PaisEntity toEntity(final PaisDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? PaisEntity.obtenerValorDefecto() : 
			new PaisEntity(domain.getId(), domain.getNombre());
	}

	@Override
	public PaisDomain toDomain(final PaisEntity entity) {
		var paisEntityAEnsamblar = PaisEntity.obtenerValorDefecto(entity);
		return new PaisDomain(paisEntityAEnsamblar.getId(), paisEntityAEnsamblar.getNombre());
	}

	@Override
	public List<PaisDomain> toDomain(List<PaisEntity> entityList) {
		var listaResultado = new ArrayList<PaisDomain>();
		
		for (PaisEntity paisEntity : entityList) {
			listaResultado.add(toDomain(paisEntity));
		}
		return listaResultado;
	}

}
