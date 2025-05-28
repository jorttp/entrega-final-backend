package co.edu.co.lilfac.businesslogic.businesslogic.assembler.costoadicional.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.recepcion.dto.RecepcionDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CostoAdicionalDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.CostoAdicionalDTO;

public class CostoAdicionalDTOAssembler implements DTOAssembler<CostoAdicionalDTO, CostoAdicionalDomain>{
	
	private static final CostoAdicionalDTOAssembler INSTANCE = new CostoAdicionalDTOAssembler();
	
	public static CostoAdicionalDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CostoAdicionalDTO toDto(final CostoAdicionalDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CostoAdicionalDTO.obtenerValorDefecto() : 
			new CostoAdicionalDTO(domain.getId(), domain.getValor(), domain.getDescripcion(), RecepcionDTOAssembler.getInstance().toDto(domain.getRecepcion()));
	}

	@Override
	public CostoAdicionalDomain toDomain(final CostoAdicionalDTO dto) {
		var costoAdicionalDTOAEnsamblar = CostoAdicionalDTO.obtenerValorDefecto(dto);
		return new CostoAdicionalDomain(costoAdicionalDTOAEnsamblar.getId(), costoAdicionalDTOAEnsamblar.getValor(), costoAdicionalDTOAEnsamblar.getDescripcion(), RecepcionDTOAssembler.getInstance().toDomain(costoAdicionalDTOAEnsamblar.getRecepcion()));
	}

	@Override
	public List<CostoAdicionalDomain> toDomain(List<CostoAdicionalDTO> dtoList) {
		var listaResultado = new ArrayList<CostoAdicionalDomain>();
		
		for (CostoAdicionalDTO costoAdicionalDTO : dtoList) {
			listaResultado.add(toDomain(costoAdicionalDTO));
		}
		return listaResultado;
	}

	@Override
	public List<CostoAdicionalDTO> toDto(List<CostoAdicionalDomain> domainList) {
		var listaResultado = new ArrayList<CostoAdicionalDTO>();
		
		for (CostoAdicionalDomain costoAdicionalDomain : domainList) {
			listaResultado.add(toDto(costoAdicionalDomain));
		}
		return null;
	}



}
