package co.edu.co.lilfac.businesslogic.businesslogic.assembler.historialcosto.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.HistorialCostoEntity;

public class HistorialCostoEntityAssembler implements EntityAssembler<HistorialCostoEntity, HistorialCostoDomain>{
	
	private static final HistorialCostoEntityAssembler INSTANCE = new HistorialCostoEntityAssembler();
	
	private HistorialCostoEntityAssembler(){
		super();
	}
	
	public static HistorialCostoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public HistorialCostoEntity toEntity(final HistorialCostoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? HistorialCostoEntity.obtenerValorDefecto() : 
			new HistorialCostoEntity(domain.getId(), domain.getCodigo(), domain.getFechaInicio(), domain.getFechaFin(), domain.isEstado(), domain.getCosto(), ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()));
	}

	@Override
	public HistorialCostoDomain toDomain(final HistorialCostoEntity entity) {
		var historialCostoEntityAEnsamblar = HistorialCostoEntity.obtenerValorDefecto(entity);
		return new HistorialCostoDomain(historialCostoEntityAEnsamblar.getId(), historialCostoEntityAEnsamblar.getCodigo(), historialCostoEntityAEnsamblar.getFechaInicio(), historialCostoEntityAEnsamblar.getFechaFin(), historialCostoEntityAEnsamblar.isEstado(), historialCostoEntityAEnsamblar.getCosto(), ProductoEntityAssembler.getInstance().toDomain(historialCostoEntityAEnsamblar.getProducto()));
	}

	@Override
	public List<HistorialCostoDomain> toDomain(List<HistorialCostoEntity> entityList) {
		var listaResultado = new ArrayList<HistorialCostoDomain>();
		
		for (HistorialCostoEntity historialCostoEntity : entityList) {
			listaResultado.add(toDomain(historialCostoEntity));
		}
		return listaResultado;
	}

}
