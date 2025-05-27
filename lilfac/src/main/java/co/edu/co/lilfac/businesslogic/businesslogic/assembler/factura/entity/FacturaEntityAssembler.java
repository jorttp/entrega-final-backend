package co.edu.co.lilfac.businesslogic.businesslogic.assembler.factura.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.cliente.entity.ClienteEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.costoadicional.entity.CostoAdicionalEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.entity.EmpleadoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empresa.entity.EmpresaEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.entity.PedidoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.FacturaEntity;

public class FacturaEntityAssembler implements EntityAssembler<FacturaEntity, FacturaDomain>{
	
	private static final FacturaEntityAssembler INSTANCE = new FacturaEntityAssembler();
	
	private FacturaEntityAssembler(){
		super();
	}
	
	public static FacturaEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public FacturaEntity toEntity(final FacturaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? FacturaEntity.obtenerValorDefecto() : 
			new FacturaEntity(domain.getId(), domain.getCodigo(), domain.getFechaGeneracion(), domain.getCostoTotal(), EmpresaEntityAssembler.getInstance().toEntity(domain.getEmpresa()), EmpleadoEntityAssembler.getInstance().toEntity(domain.getEmpleado()), ClienteEntityAssembler.getInstance().toEntity(domain.getCliente()), CostoAdicionalEntityAssembler.getInstance().toEntity(domain.getCostoAdicional()), PedidoEntityAssembler.getInstance().toEntity(domain.getPedido()));
	}

	@Override
	public FacturaDomain toDomain(final FacturaEntity entity) {
		var facturaEntityAEnsamblar = FacturaEntity.obtenerValorDefecto(entity);
		return new FacturaDomain(facturaEntityAEnsamblar.getId(), facturaEntityAEnsamblar.getCodigo(), facturaEntityAEnsamblar.getFechaGeneracion(), facturaEntityAEnsamblar.getCostoTotal(), EmpresaEntityAssembler.getInstance().toDomain(facturaEntityAEnsamblar.getEmpresa()), EmpleadoEntityAssembler.getInstance().toDomain(facturaEntityAEnsamblar.getEmpleado()), ClienteEntityAssembler.getInstance().toDomain(facturaEntityAEnsamblar.getCliente()), CostoAdicionalEntityAssembler.getInstance().toDomain(facturaEntityAEnsamblar.getCostoAdicional()), PedidoEntityAssembler.getInstance().toDomain(facturaEntityAEnsamblar.getPedido()));
	}

	@Override
	public List<FacturaDomain> toDomain(List<FacturaEntity> entityList) {
		var listaResultado = new ArrayList<FacturaDomain>();
		
		for (FacturaEntity facturaEntity : entityList) {
			listaResultado.add(toDomain(facturaEntity));
		}
		return listaResultado;
	}

}
