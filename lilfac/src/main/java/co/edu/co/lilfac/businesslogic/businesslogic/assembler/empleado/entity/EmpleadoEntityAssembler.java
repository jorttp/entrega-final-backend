package co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpleadoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.EmpleadoEntity;

public class EmpleadoEntityAssembler implements EntityAssembler<EmpleadoEntity, EmpleadoDomain>{
	
	private static final EmpleadoEntityAssembler INSTANCE = new EmpleadoEntityAssembler();
	
	private EmpleadoEntityAssembler(){
		super();
	}
	
	public static EmpleadoEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public EmpleadoEntity toEntity(final EmpleadoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? EmpleadoEntity.obtenerValorDefecto() : 
			new EmpleadoEntity(domain.getId(), domain.getNombre(), domain.getApellido(), domain.getCedula(), domain.getTelefono(), domain.getCorreo());
	}

	@Override
	public EmpleadoDomain toDomain(final EmpleadoEntity entity) {
		var empleadoEntityAEnsamblar = EmpleadoEntity.obtenerValorDefecto(entity);
		return new EmpleadoDomain(empleadoEntityAEnsamblar.getId(), empleadoEntityAEnsamblar.getNombre(), empleadoEntityAEnsamblar.getApellido(), empleadoEntityAEnsamblar.getCedula(), empleadoEntityAEnsamblar.getTelefono(), empleadoEntityAEnsamblar.getCorreo());
	}

	@Override
	public List<EmpleadoDomain> toDomain(List<EmpleadoEntity> entityList) {
		var listaResultado = new ArrayList<EmpleadoDomain>();
		
		for (EmpleadoEntity empleadoEntity : entityList) {
			listaResultado.add(toDomain(empleadoEntity));
		}
		return listaResultado;
	}

}
