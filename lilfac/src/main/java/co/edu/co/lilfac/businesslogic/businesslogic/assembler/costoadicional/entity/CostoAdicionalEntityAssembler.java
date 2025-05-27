package co.edu.co.lilfac.businesslogic.businesslogic.assembler.costoadicional.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.recepcion.entity.RecepcionEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.CostoAdicionalEntity;

public class CostoAdicionalEntityAssembler implements EntityAssembler<CostoAdicionalEntity, CostoAdicionalDomain>{
	
	private static final CostoAdicionalEntityAssembler INSTANCE = new CostoAdicionalEntityAssembler();
	
	private CostoAdicionalEntityAssembler(){
		super();
	}
	
	public static CostoAdicionalEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CostoAdicionalEntity toEntity(final CostoAdicionalDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CostoAdicionalEntity.obtenerValorDefecto() : 
			new CostoAdicionalEntity(domain.getId(), domain.getValor(), domain.getDescripcion(), RecepcionEntityAssembler.getInstance().toEntity(domain.getRecepcion()));
	}

	@Override
	public CostoAdicionalDomain toDomain(final CostoAdicionalEntity entity) {
		var costoAdicionalEntityAEnsamblar = CostoAdicionalEntity.obtenerValorDefecto(entity);
		return new CostoAdicionalDomain(costoAdicionalEntityAEnsamblar.getId(), costoAdicionalEntityAEnsamblar.getValor(), costoAdicionalEntityAEnsamblar.getDescripcion(), RecepcionEntityAssembler.getInstance().toDomain(costoAdicionalEntityAEnsamblar.getRecepcion()));
	}

	@Override
	public List<CostoAdicionalDomain> toDomain(List<CostoAdicionalEntity> entityList) {
		var listaResultado = new ArrayList<CostoAdicionalDomain>();
		
		for (CostoAdicionalEntity costoAdicionalEntity : entityList) {
			listaResultado.add(toDomain(costoAdicionalEntity));
		}
		return listaResultado;
	}

}
