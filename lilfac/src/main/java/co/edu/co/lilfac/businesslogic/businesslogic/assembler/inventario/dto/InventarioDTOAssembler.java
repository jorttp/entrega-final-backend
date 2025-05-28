package co.edu.co.lilfac.businesslogic.businesslogic.assembler.inventario.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empresa.dto.EmpresaDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.historialcosto.dto.HistorialCostoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.InventarioDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.InventarioDTO;

public class InventarioDTOAssembler implements DTOAssembler<InventarioDTO, InventarioDomain>{
	
	private static final InventarioDTOAssembler INSTANCE = new InventarioDTOAssembler();
	
	public static InventarioDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public InventarioDTO toDto(final InventarioDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? InventarioDTO.obtenerValorDefecto() : 
			new InventarioDTO(domain.getId(), domain.getTotalUnidades(),domain.getUnidadesAlquiladas(), domain.getUnidadesAfectadas(), domain.getUnidadesDisponibles(), EmpresaDTOAssembler.getInstance().toDto(domain.getEmpresa()), ProductoDTOAssembler.getInstance().toDto(domain.getProducto()), HistorialCostoDTOAssembler.getInstance().toDto(domain.getHistorialCosto()));
	}

	@Override
	public InventarioDomain toDomain(final InventarioDTO dto) {
		var inventarioDTOAEnsamblar = InventarioDTO.obtenerValorDefecto(dto);
		return new InventarioDomain(inventarioDTOAEnsamblar.getId(), inventarioDTOAEnsamblar.getTotalUnidades(),inventarioDTOAEnsamblar.getUnidadesAlquiladas(), inventarioDTOAEnsamblar.getUnidadesAfectadas(), inventarioDTOAEnsamblar.getUnidadesDisponibles(), EmpresaDTOAssembler.getInstance().toDomain(inventarioDTOAEnsamblar.getEmpresa()), ProductoDTOAssembler.getInstance().toDomain(inventarioDTOAEnsamblar.getProducto()), HistorialCostoDTOAssembler.getInstance().toDomain(inventarioDTOAEnsamblar.getHistorialCosto()));
	}

	@Override
	public List<InventarioDomain> toDomain(List<InventarioDTO> dtoList) {
		var listaResultado = new ArrayList<InventarioDomain>();
		
		for (InventarioDTO inventarioDTO : dtoList) {
			listaResultado.add(toDomain(inventarioDTO));
		}
		return listaResultado;
	}

	@Override
	public List<InventarioDTO> toDto(List<InventarioDomain> domainList) {
		var listaResultados = new ArrayList<InventarioDTO>();
		
		for (InventarioDomain inventarioDomain : domainList) {
			listaResultados.add(toDto(inventarioDomain));
		}
		return null;
	}



}
