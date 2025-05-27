package co.edu.co.lilfac.businesslogic.businesslogic.assembler.entrega.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.dto.CiudadDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.dto.EmpleadoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.dto.PedidoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.EntregaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.EntregaDTO;

public class EntregaDTOAssembler implements DTOAssembler<EntregaDTO, EntregaDomain>{
	
	private static final EntregaDTOAssembler INSTANCE = new EntregaDTOAssembler();
	
	public static EntregaDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public EntregaDTO toDto(final EntregaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? EntregaDTO.obtenerValorDefecto() : 
			new EntregaDTO(domain.getId(), domain.getFecha(),domain.getEstado(), domain.getDireccion(), CiudadDTOAssembler.getInstance().toDto(domain.getCiudad()), EmpleadoDTOAssembler.getInstance().toDto(domain.getEmpleado()), PedidoDTOAssembler.getInstance().toDto(domain.getPedido()));
	}

	@Override
	public EntregaDomain toDomain(final EntregaDTO dto) {
		var entregaDTOAEnsamblar = EntregaDTO.obtenerValorDefecto(dto);
		return new EntregaDomain(entregaDTOAEnsamblar.getId(), entregaDTOAEnsamblar.getFecha(),entregaDTOAEnsamblar.getEstado(), entregaDTOAEnsamblar.getDireccion(), CiudadDTOAssembler.getInstance().toDomain(entregaDTOAEnsamblar.getCiudad()), EmpleadoDTOAssembler.getInstance().toDomain(entregaDTOAEnsamblar.getEmpleado()), PedidoDTOAssembler.getInstance().toDomain(entregaDTOAEnsamblar.getPedido()));
	}

	@Override
	public List<EntregaDomain> toDomain(List<EntregaDTO> dtoList) {
		var listaResultado = new ArrayList<EntregaDomain>();
		
		for (EntregaDTO entregaDTO : dtoList) {
			listaResultado.add(toDomain(entregaDTO));
		}
		return listaResultado;
	}



}
