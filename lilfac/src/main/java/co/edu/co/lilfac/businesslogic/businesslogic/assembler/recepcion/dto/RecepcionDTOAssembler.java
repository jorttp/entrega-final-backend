package co.edu.co.lilfac.businesslogic.businesslogic.assembler.recepcion.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.dto.CiudadDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.dto.EmpleadoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.entrega.dto.EntregaDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.RecepcionDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.RecepcionDTO;

public class RecepcionDTOAssembler implements DTOAssembler<RecepcionDTO, RecepcionDomain>{
	
	private static final RecepcionDTOAssembler INSTANCE = new RecepcionDTOAssembler();
	
	public static RecepcionDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public RecepcionDTO toDto(final RecepcionDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? RecepcionDTO.obtenerValorDefecto() : 
			new RecepcionDTO(domain.getId(), domain.getFecha(),domain.getEstado(), domain.getDireccion(), CiudadDTOAssembler.getInstance().toDto(domain.getCiudad()), EmpleadoDTOAssembler.getInstance().toDto(domain.getEmpleado()), EntregaDTOAssembler.getInstance().toDto(domain.getEntrega()));
	}

	@Override
	public RecepcionDomain toDomain(final RecepcionDTO dto) {
		var recepcionDTOAEnsamblar = RecepcionDTO.obtenerValorDefecto(dto);
		return new RecepcionDomain(recepcionDTOAEnsamblar.getId(), recepcionDTOAEnsamblar.getFecha(),recepcionDTOAEnsamblar.getEstado(), recepcionDTOAEnsamblar.getDireccion(), CiudadDTOAssembler.getInstance().toDomain(recepcionDTOAEnsamblar.getCiudad()), EmpleadoDTOAssembler.getInstance().toDomain(recepcionDTOAEnsamblar.getEmpleado()), EntregaDTOAssembler.getInstance().toDomain(recepcionDTOAEnsamblar.getEntrega()));
	}

	@Override
	public List<RecepcionDomain> toDomain(List<RecepcionDTO> dtoList) {
		var listaResultado = new ArrayList<RecepcionDomain>();
		
		for (RecepcionDTO recepcionDTO : dtoList) {
			listaResultado.add(toDomain(recepcionDTO));
		}
		return listaResultado;
	}



}
