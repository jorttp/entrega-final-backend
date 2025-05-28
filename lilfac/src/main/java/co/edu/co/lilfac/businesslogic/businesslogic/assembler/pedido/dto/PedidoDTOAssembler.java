package co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.ciudad.dto.CiudadDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.cliente.dto.ClienteDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.dto.EmpleadoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.PedidoDTO;

public class PedidoDTOAssembler implements DTOAssembler<PedidoDTO, PedidoDomain>{
	
	private static final PedidoDTOAssembler INSTANCE = new PedidoDTOAssembler();
	
	public static PedidoDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public PedidoDTO toDto(final PedidoDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? PedidoDTO.obtenerValorDefecto() : 
			new PedidoDTO(domain.getId(), domain.getFechaReserva(),domain.getFechaVencimiento(), domain.getDireccionEntrega(), domain.getCosto(), domain.getAbono(), domain.getRestante(), CiudadDTOAssembler.getInstance().toDto(domain.getCiudad()), ClienteDTOAssembler.getInstance().toDto(domain.getCliente()), EmpleadoDTOAssembler.getInstance().toDto(domain.getEmpleado()));
	}

	@Override
	public PedidoDomain toDomain(final PedidoDTO dto) {
		var pedidoDTOAEnsamblar = PedidoDTO.obtenerValorDefecto(dto);
		return new PedidoDomain(pedidoDTOAEnsamblar.getId(), pedidoDTOAEnsamblar.getFechaReserva(),pedidoDTOAEnsamblar.getFechaVencimiento(), pedidoDTOAEnsamblar.getDireccionEntrega(), pedidoDTOAEnsamblar.getCosto(), pedidoDTOAEnsamblar.getAbono(), pedidoDTOAEnsamblar.getRestante(), CiudadDTOAssembler.getInstance().toDomain(pedidoDTOAEnsamblar.getCiudad()), ClienteDTOAssembler.getInstance().toDomain(pedidoDTOAEnsamblar.getCliente()), EmpleadoDTOAssembler.getInstance().toDomain(pedidoDTOAEnsamblar.getEmpleado()));
	}

	@Override
	public List<PedidoDomain> toDomain(List<PedidoDTO> dtoList) {
		var listaResultado = new ArrayList<PedidoDomain>();
		
		for (PedidoDTO pedidoDTO : dtoList) {
			listaResultado.add(toDomain(pedidoDTO));
		}
		return listaResultado;
	}

	@Override
	public List<PedidoDTO> toDto(List<PedidoDomain> domainList) {
		var listaResultados = new ArrayList<PedidoDTO>();
		
		for (PedidoDomain pedidoDomain : domainList) {
			listaResultados.add(toDto(pedidoDomain));
		}
		return null;
	}



}
