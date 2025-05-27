package co.edu.co.lilfac.businesslogic.businesslogic.assembler.entrega.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.entity.EmpleadoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.entity.PedidoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.EntregaEntity;

public class EntregaEntityAssembler implements EntityAssembler<EntregaEntity, EntregaDomain>{
	
	private static final EntregaEntityAssembler INSTANCE = new EntregaEntityAssembler();
	
	private EntregaEntityAssembler(){
		super();
	}
	
	public static EntregaEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public EntregaEntity toEntity(final EntregaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? EntregaEntity.obtenerValorDefecto() : 
			new EntregaEntity(domain.getId(), domain.getFecha(),domain.getEstado(), domain.getDireccion(), CiudadEntityAssembler.getInstance().toEntity(domain.getCiudad()), EmpleadoEntityAssembler.getInstance().toEntity(domain.getEmpleado()), PedidoEntityAssembler.getInstance().toEntity(domain.getPedido()));
	}

	@Override
	public EntregaDomain toDomain(final EntregaEntity entity) {
		var entregaEntityAEnsamblar = EntregaEntity.obtenerValorDefecto(entity);
		return new EntregaDomain(entregaEntityAEnsamblar.getId(), entregaEntityAEnsamblar.getFecha(),entregaEntityAEnsamblar.getEstado(), entregaEntityAEnsamblar.getDireccion(), CiudadEntityAssembler.getInstance().toDomain(entregaEntityAEnsamblar.getCiudad()), EmpleadoEntityAssembler.getInstance().toDomain(entregaEntityAEnsamblar.getEmpleado()), PedidoEntityAssembler.getInstance().toDomain(entregaEntityAEnsamblar.getPedido()));
	}

	@Override
	public List<EntregaDomain> toDomain(List<EntregaEntity> entityList) {
		var listaResultado = new ArrayList<EntregaDomain>();
		
		for (EntregaEntity entregaEntity : entityList) {
			listaResultado.add(toDomain(entregaEntity));
		}
		return listaResultado;
	}

}
