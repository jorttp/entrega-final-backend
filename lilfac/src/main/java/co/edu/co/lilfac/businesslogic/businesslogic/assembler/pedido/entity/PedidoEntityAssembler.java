package co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.cliente.entity.ClienteEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.entity.EmpleadoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.PedidoEntity;

public class PedidoEntityAssembler implements EntityAssembler<PedidoEntity, PedidoDomain>{
	
	private static final PedidoEntityAssembler INSTANCE = new PedidoEntityAssembler();
	
	private PedidoEntityAssembler(){
		super();
	}
	
	public static PedidoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public PedidoEntity toEntity(final PedidoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? PedidoEntity.obtenerValorDefecto() : 
			new PedidoEntity(domain.getId(), domain.getFechaReserva(),domain.getFechaVencimiento(), domain.getDireccionEntrega(), domain.getCosto(), domain.getAbono(), domain.getRestante(), CiudadEntityAssembler.getInstance().toEntity(domain.getCiudad()), ClienteEntityAssembler.getInstance().toEntity(domain.getCliente()), EmpleadoEntityAssembler.getInstance().toEntity(domain.getEmpleado()));
	}

	@Override
	public PedidoDomain toDomain(final PedidoEntity entity) {
		var pedidoEntityAEnsamblar = PedidoEntity.obtenerValorDefecto(entity);
		return new PedidoDomain(pedidoEntityAEnsamblar.getId(), pedidoEntityAEnsamblar.getFechaReserva(),pedidoEntityAEnsamblar.getFechaVencimiento(), pedidoEntityAEnsamblar.getDireccionEntrega(), pedidoEntityAEnsamblar.getCosto(), pedidoEntityAEnsamblar.getAbono(), pedidoEntityAEnsamblar.getRestante(), CiudadEntityAssembler.getInstance().toDomain(pedidoEntityAEnsamblar.getCiudad()), ClienteEntityAssembler.getInstance().toDomain(pedidoEntityAEnsamblar.getCliente()), EmpleadoEntityAssembler.getInstance().toDomain(pedidoEntityAEnsamblar.getEmpleado()));
	}

	@Override
	public List<PedidoDomain> toDomain(List<PedidoEntity> entityList) {
		var listaResultado = new ArrayList<PedidoDomain>();
		
		for (PedidoEntity pedidoEntity : entityList) {
			listaResultado.add(toDomain(pedidoEntity));
		}
		return listaResultado;
	}

}
