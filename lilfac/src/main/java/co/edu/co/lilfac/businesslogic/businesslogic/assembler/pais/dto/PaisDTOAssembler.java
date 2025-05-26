package co.edu.co.lilfac.businesslogic.businesslogic.assembler.pais.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.PaisDTO;

public class PaisDTOAssembler implements DTOAssembler<PaisDTO, PaisDomain>{
	
	private static final PaisDTOAssembler INSTANCE = new PaisDTOAssembler();
	
	public static PaisDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public PaisDTO toDto(final PaisDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? PaisDTO.obtenerValorDefecto() : 
			new PaisDTO(domain.getId(), domain.getNombre());
	}

	@Override
	public PaisDomain toDomain(final PaisDTO dto) {
		var paisDTOAEnsamblar = PaisDTO.obtenerValorDefecto(dto);
		return new PaisDomain(paisDTOAEnsamblar.getId(), paisDTOAEnsamblar.getNombre());
	}

	@Override
	public List<PaisDomain> toDomain(List<PaisDTO> dtoList) {
		var listaResultado = new ArrayList<PaisDomain>();
		
		for (PaisDTO paisDTO : dtoList) {
			listaResultado.add(toDomain(paisDTO));
		}
		return listaResultado;
	}



}
