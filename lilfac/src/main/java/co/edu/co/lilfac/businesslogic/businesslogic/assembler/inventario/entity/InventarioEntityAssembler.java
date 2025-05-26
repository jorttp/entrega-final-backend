package co.edu.co.lilfac.businesslogic.businesslogic.assembler.inventario.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empresa.entity.EmpresaEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.historialcosto.entity.HistorialCostoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.InventarioDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.InventarioEntity;

public class InventarioEntityAssembler implements EntityAssembler<InventarioEntity, InventarioDomain>{
	
	private static final InventarioEntityAssembler INSTANCE = new InventarioEntityAssembler();
	
	private InventarioEntityAssembler(){
		super();
	}
	
	public static InventarioEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public InventarioEntity toEntity(final InventarioDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? InventarioEntity.obtenerValorDefecto() : 
			new InventarioEntity(domain.getId(), domain.getTotalUnidades(),domain.getUnidadesAlquiladas(), domain.getUnidadesAfectadas(), domain.getUnidadesDisponibles(), EmpresaEntityAssembler.getInstance().toEntity(domain.getEmpresa()), ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()), HistorialCostoEntityAssembler.getInstance().toEntity(domain.getHistorialCosto()));
	}

	@Override
	public InventarioDomain toDomain(final InventarioEntity entity) {
		var inventarioEntityAEnsamblar = InventarioEntity.obtenerValorDefecto(entity);
		return new InventarioDomain(inventarioEntityAEnsamblar.getId(), inventarioEntityAEnsamblar.getTotalUnidades(),inventarioEntityAEnsamblar.getUnidadesAlquiladas(), inventarioEntityAEnsamblar.getUnidadesAfectadas(), inventarioEntityAEnsamblar.getUnidadesDisponibles(), EmpresaEntityAssembler.getInstance().toDomain(inventarioEntityAEnsamblar.getEmpresa()), ProductoEntityAssembler.getInstance().toDomain(inventarioEntityAEnsamblar.getProducto()), HistorialCostoEntityAssembler.getInstance().toDomain(inventarioEntityAEnsamblar.getHistorialCosto()));
	}

	@Override
	public List<InventarioDomain> toDomain(List<InventarioEntity> entityList) {
		var listaResultado = new ArrayList<InventarioDomain>();
		
		for (InventarioEntity inventarioEntity : entityList) {
			listaResultado.add(toDomain(inventarioEntity));
		}
		return listaResultado;
	}

}
