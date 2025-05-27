package co.edu.co.lilfac.businesslogic.businesslogic.assembler.recepcion.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.entity.EmpleadoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.entrega.entity.EntregaEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.RecepcionDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.RecepcionEntity;

public class RecepcionEntityAssembler implements EntityAssembler<RecepcionEntity, RecepcionDomain>{
	
	private static final RecepcionEntityAssembler INSTANCE = new RecepcionEntityAssembler();
	
	private RecepcionEntityAssembler(){
		super();
	}
	
	public static RecepcionEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public RecepcionEntity toEntity(final RecepcionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? RecepcionEntity.obtenerValorDefecto() : 
			new RecepcionEntity(domain.getId(), domain.getFecha(),domain.getEstado(), domain.getDireccion(), CiudadEntityAssembler.getInstance().toEntity(domain.getCiudad()), EmpleadoEntityAssembler.getInstance().toEntity(domain.getEmpleado()), EntregaEntityAssembler.getInstance().toEntity(domain.getEntrega()));
	}

	@Override
	public RecepcionDomain toDomain(final RecepcionEntity entity) {
		var recepcionEntityAEnsamblar = RecepcionEntity.obtenerValorDefecto(entity);
		return new RecepcionDomain(recepcionEntityAEnsamblar.getId(), recepcionEntityAEnsamblar.getFecha(),recepcionEntityAEnsamblar.getEstado(), recepcionEntityAEnsamblar.getDireccion(), CiudadEntityAssembler.getInstance().toDomain(recepcionEntityAEnsamblar.getCiudad()), EmpleadoEntityAssembler.getInstance().toDomain(recepcionEntityAEnsamblar.getEmpleado()), EntregaEntityAssembler.getInstance().toDomain(recepcionEntityAEnsamblar.getEntrega()));
	}

	@Override
	public List<RecepcionDomain> toDomain(List<RecepcionEntity> entityList) {
		var listaResultado = new ArrayList<RecepcionDomain>();
		
		for (RecepcionEntity recepcionEntity : entityList) {
			listaResultado.add(toDomain(recepcionEntity));
		}
		return listaResultado;
	}

}
