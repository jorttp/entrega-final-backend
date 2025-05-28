package co.edu.co.lilfac.businesslogic.businesslogic.assembler.historialcosto.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.HistorialCostoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.HistorialCostoDTO;

public class HistorialCostoDTOAssembler implements DTOAssembler<HistorialCostoDTO, HistorialCostoDomain>{
	
	private static final HistorialCostoDTOAssembler INSTANCE = new HistorialCostoDTOAssembler();
	
	public static HistorialCostoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public HistorialCostoDTO toDto(final HistorialCostoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? HistorialCostoDTO.obtenerValorDefecto() : 
			new HistorialCostoDTO(domain.getId(), domain.getCodigo(), domain.getFechaInicio(), domain.getFechaFin(), domain.isEstado(), domain.getCosto(), ProductoDTOAssembler.getInstance().toDto(domain.getProducto()));
	}

	@Override
	public HistorialCostoDomain toDomain(final HistorialCostoDTO dto) {
		var historialCostoDTOAEnsamblar = HistorialCostoDTO.obtenerValorDefecto(dto);
		return new HistorialCostoDomain(historialCostoDTOAEnsamblar.getId(), historialCostoDTOAEnsamblar.getCodigo(), historialCostoDTOAEnsamblar.getFechaInicio(), historialCostoDTOAEnsamblar.getFechaFin(), historialCostoDTOAEnsamblar.isEstado(), historialCostoDTOAEnsamblar.getCosto(), ProductoDTOAssembler.getInstance().toDomain(historialCostoDTOAEnsamblar.getProducto()));
	}

	@Override
	public List<HistorialCostoDomain> toDomain(List<HistorialCostoDTO> dtoList) {
		var listaResultado = new ArrayList<HistorialCostoDomain>();
		
		for (HistorialCostoDTO historialCostoDTO : dtoList) {
			listaResultado.add(toDomain(historialCostoDTO));
		}
		return listaResultado;
	}

	@Override
	public List<HistorialCostoDTO> toDto(List<HistorialCostoDomain> domainList) {
		var listaResultados = new ArrayList<HistorialCostoDTO>();
		
		for (HistorialCostoDomain historialCostoDomain : domainList) {
			listaResultados.add(toDto(historialCostoDomain));
		}
		return null;
	}



}
