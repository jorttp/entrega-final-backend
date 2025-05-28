package co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoria.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.CategoriaDTO;

public class CategoriaDTOAssembler implements DTOAssembler<CategoriaDTO, CategoriaDomain>{
	
	private static final CategoriaDTOAssembler INSTANCE = new CategoriaDTOAssembler();
	
	public static CategoriaDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CategoriaDTO toDto(final CategoriaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CategoriaDTO.obtenerValorDefecto() : 
			new CategoriaDTO(domain.getId(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public CategoriaDomain toDomain(final CategoriaDTO dto) {
		var categoriaDTOAEnsamblar = CategoriaDTO.obtenerValorDefecto(dto);
		return new CategoriaDomain(categoriaDTOAEnsamblar.getId(), categoriaDTOAEnsamblar.getNombre(), categoriaDTOAEnsamblar.getDescripcion());
	}

	@Override
	public List<CategoriaDomain> toDomain(List<CategoriaDTO> dtoList) {
		var listaResultado = new ArrayList<CategoriaDomain>();
		
		for (CategoriaDTO categoriaDTO : dtoList) {
			listaResultado.add(toDomain(categoriaDTO));
		}
		return listaResultado;
	}

	@Override
	public List<CategoriaDTO> toDto(List<CategoriaDomain> domainList) {
		var listaResultado = new ArrayList<CategoriaDTO>();
		for (CategoriaDomain categoriaDomain : domainList) {
			listaResultado.add(toDto(categoriaDomain));
		}
		return null;
	}



}
