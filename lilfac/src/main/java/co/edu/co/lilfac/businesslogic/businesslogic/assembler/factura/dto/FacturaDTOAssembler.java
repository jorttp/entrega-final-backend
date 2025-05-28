package co.edu.co.lilfac.businesslogic.businesslogic.assembler.factura.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.lilfac.businesslogic.businesslogic.assembler.DTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.cliente.dto.ClienteDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.costoadicional.dto.CostoAdicionalDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empleado.dto.EmpleadoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.empresa.dto.EmpresaDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.pedido.dto.PedidoDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.dto.FacturaDTO;

public class FacturaDTOAssembler implements DTOAssembler<FacturaDTO, FacturaDomain>{
	
	private static final FacturaDTOAssembler INSTANCE = new FacturaDTOAssembler();
	
	public static FacturaDTOAssembler getInstance() {
		return INSTANCE;
	}

	@Override
	public FacturaDTO toDto(final FacturaDomain domain) {
		return UtilObjeto.getInstance().esNulo(domain) ? FacturaDTO.obtenerValorDefecto() : 
			new FacturaDTO(domain.getId(), domain.getCodigo(),domain.getFechaGeneracion(), domain.getCostoTotal(), EmpresaDTOAssembler.getInstance().toDto(domain.getEmpresa()), EmpleadoDTOAssembler.getInstance().toDto(domain.getEmpleado()), ClienteDTOAssembler.getInstance().toDto(domain.getCliente()), CostoAdicionalDTOAssembler.getInstance().toDto(domain.getCostoAdicional()), PedidoDTOAssembler.getInstance().toDto(domain.getPedido()));
	}

	@Override
	public FacturaDomain toDomain(final FacturaDTO dto) {
		var facturaDTOAEnsamblar = FacturaDTO.obtenerValorDefecto(dto);
		return new FacturaDomain(facturaDTOAEnsamblar.getId(), facturaDTOAEnsamblar.getCodigo(),facturaDTOAEnsamblar.getFechaGeneracion(), facturaDTOAEnsamblar.getCostoTotal(), EmpresaDTOAssembler.getInstance().toDomain(facturaDTOAEnsamblar.getEmpresa()), EmpleadoDTOAssembler.getInstance().toDomain(facturaDTOAEnsamblar.getEmpleado()), ClienteDTOAssembler.getInstance().toDomain(facturaDTOAEnsamblar.getCliente()), CostoAdicionalDTOAssembler.getInstance().toDomain(facturaDTOAEnsamblar.getCostoAdicional()), PedidoDTOAssembler.getInstance().toDomain(facturaDTOAEnsamblar.getPedido()));
	}

	@Override
	public List<FacturaDomain> toDomain(List<FacturaDTO> dtoList) {
		var listaResultado = new ArrayList<FacturaDomain>();
		
		for (FacturaDTO facturaDTO : dtoList) {
			listaResultado.add(toDomain(facturaDTO));
		}
		return listaResultado;
	}

	@Override
	public List<FacturaDTO> toDto(List<FacturaDomain> domainList) {
		var listaResultados = new ArrayList<FacturaDTO>();
		
		for (FacturaDomain facturaDomain : domainList) {
			listaResultados.add(toDto(facturaDomain));
		}
		return listaResultados;
	}



}
