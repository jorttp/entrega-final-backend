package co.edu.co.lilfac.businesslogic.businesslogic.assembler.productopedido.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.dto.PedidoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.ProductoPedidoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.ProductoPedidoDTO;

public class ProductoPedidoDTOAssembler implements DTOAssembler<ProductoPedidoDTO, ProductoPedidoDomain>{
	
	private static final ProductoPedidoDTOAssembler INSTANCE = new ProductoPedidoDTOAssembler();
	
	public static ProductoPedidoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public ProductoPedidoDTO toDto(final ProductoPedidoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? ProductoPedidoDTO.obtenerValorDefecto() : 
			new ProductoPedidoDTO(domain.getId(), domain.getCantidad(), ProductoDTOAssembler.getInstance().toDto(domain.getProducto()), PedidoDTOAssembler.getInstance().toDto(domain.getPedido()));
	}

	@Override
	public ProductoPedidoDomain toDomain(final ProductoPedidoDTO dto) {
		var productoPedidoDTOAEnsamblar = ProductoPedidoDTO.obtenerValorDefecto(dto);
		return new ProductoPedidoDomain(productoPedidoDTOAEnsamblar.getId(), productoPedidoDTOAEnsamblar.getCantidad(), ProductoDTOAssembler.getInstance().toDomain(productoPedidoDTOAEnsamblar.getProducto()), PedidoDTOAssembler.getInstance().toDomain(productoPedidoDTOAEnsamblar.getPedido()));
	}

	@Override
	public List<ProductoPedidoDomain> toDomain(List<ProductoPedidoDTO> dtoList) {
		var listaResultado = new ArrayList<ProductoPedidoDomain>();
		
		for (ProductoPedidoDTO productoPedidoDTO : dtoList) {
			listaResultado.add(toDomain(productoPedidoDTO));
		}
		return listaResultado;
	}

	@Override
	public List<ProductoPedidoDTO> toDto(List<ProductoPedidoDomain> domainList) {
		var listaResultados = new ArrayList<ProductoPedidoDTO>();
		
		for (ProductoPedidoDomain productoPedidoDomain : domainList) {
			listaResultados.add(toDto(productoPedidoDomain));
		}
		return null;
	}



}
