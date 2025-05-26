package co.edu.co.lilfac.businesslogic.businesslogic.assembler.empresa.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.EntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.entity.CiudadEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EmpresaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.entity.EmpresaEntity;

public class EmpresaEntityAssembler implements EntityAssembler<EmpresaEntity, EmpresaDomain>{
	
	private static final EmpresaEntityAssembler INSTANCE = new EmpresaEntityAssembler();
	
	private EmpresaEntityAssembler(){
		super();
	}
	
	public static EmpresaEntityAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public EmpresaEntity toEntity(final EmpresaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? EmpresaEntity.obtenerValorDefecto() : 
			new EmpresaEntity(domain.getId(), domain.getNombre(),domain.getNit(), domain.getTelefono(), domain.getCorreo(), domain.getDireccion(), CiudadEntityAssembler.getInstance().toEntity(domain.getCiudad()));
	}

	@Override
	public EmpresaDomain toDomain(final EmpresaEntity entity) {
		var empresaEntityAEnsamblar = EmpresaEntity.obtenerValorDefecto(entity);
		return new EmpresaDomain(empresaEntityAEnsamblar.getId(), empresaEntityAEnsamblar.getNombre(), empresaEntityAEnsamblar.getNit(), empresaEntityAEnsamblar.getTelefono(), empresaEntityAEnsamblar.getCorreo(), empresaEntityAEnsamblar.getDireccion(), CiudadEntityAssembler.getInstance().toDomain(empresaEntityAEnsamblar.getCiudad()));
	}

	@Override
	public List<EmpresaDomain> toDomain(List<EmpresaEntity> entityList) {
		var listaResultado = new ArrayList<EmpresaDomain>();
		
		for (EmpresaEntity empresaEntity : entityList) {
			listaResultado.add(toDomain(empresaEntity));
		}
		return listaResultado;
	}

}
