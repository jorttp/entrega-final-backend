package co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.ProductoDTO;

public class ProductoDTOAssembler implements DTOAssembler<ProductoDTO, ProductoDomain>{
	
	private static final ProductoDTOAssembler INSTANCE = new ProductoDTOAssembler();
	
	public static ProductoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public ProductoDTO toDto(final ProductoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? ProductoDTO.obtenerValorDefecto() : 
			new ProductoDTO(domain.getId(), domain.getNombre(), domain.getCodigo(), domain.getCaracteristicas(), domain.getEstado());
	}

	@Override
	public ProductoDomain toDomain(final ProductoDTO dto) {
		var productoDTOAEnsamblar = ProductoDTO.obtenerValorDefecto(dto);
		return new ProductoDomain(productoDTOAEnsamblar.getId(), productoDTOAEnsamblar.getNombre(), productoDTOAEnsamblar.getCodigo(), productoDTOAEnsamblar.getCaracteristicas(), productoDTOAEnsamblar.getEstado());
	}

	@Override
	public List<ProductoDomain> toDomain(List<ProductoDTO> dtoList) {
		var listaResultado = new ArrayList<ProductoDomain>();
		
		for (ProductoDTO productoDTO : dtoList) {
			listaResultado.add(toDomain(productoDTO));
		}
		return listaResultado;
	}

	@Override
	public List<ProductoDTO> toDto(List<ProductoDomain> domainList) {
		var listaResultados = new ArrayList<ProductoDTO>();
		
		for (ProductoDomain productoDomain : domainList) {
			listaResultados.add(toDto(productoDomain));
		}
		return listaResultados;
	}



}
