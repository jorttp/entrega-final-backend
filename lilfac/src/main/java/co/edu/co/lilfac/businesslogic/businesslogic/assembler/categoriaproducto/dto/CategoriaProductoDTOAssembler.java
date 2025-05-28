package co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoriaproducto.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoria.dto.CategoriaDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;

public class CategoriaProductoDTOAssembler implements DTOAssembler<CategoriaProductoDTO, CategoriaProductoDomain>{
	
	private static final CategoriaProductoDTOAssembler INSTANCE = new CategoriaProductoDTOAssembler();
	
	public static CategoriaProductoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public CategoriaProductoDTO toDto(final CategoriaProductoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? CategoriaProductoDTO.obtenerValorDefecto() : 
			new CategoriaProductoDTO(domain.getId(), ProductoDTOAssembler.getInstance().toDto(domain.getProducto()), CategoriaDTOAssembler.getInstance().toDto(domain.getCategoria()));
	}

	@Override
	public CategoriaProductoDomain toDomain(final CategoriaProductoDTO dto) {
		var categoriaProductoDTOAEnsamblar = CategoriaProductoDTO.obtenerValorDefecto(dto);
		return new CategoriaProductoDomain(categoriaProductoDTOAEnsamblar.getId(), ProductoDTOAssembler.getInstance().toDomain(categoriaProductoDTOAEnsamblar.getProducto()), CategoriaDTOAssembler.getInstance().toDomain(categoriaProductoDTOAEnsamblar.getCategoria()));
	}

	@Override
	public List<CategoriaProductoDomain> toDomain(List<CategoriaProductoDTO> dtoList) {
		var listaResultado = new ArrayList<CategoriaProductoDomain>();
		
		for (CategoriaProductoDTO categoriaProductoDTO : dtoList) {
			listaResultado.add(toDomain(categoriaProductoDTO));
		}
		return listaResultado;
	}

	@Override
	public List<CategoriaProductoDTO> toDto(List<CategoriaProductoDomain> domainList) {
		var listaResultado = new ArrayList<CategoriaProductoDTO>();
		for (CategoriaProductoDomain categoriaProductoDomain : domainList) {
			listaResultado.add(toDto(categoriaProductoDomain));
		}
		return null;
	}



}
