package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.PedidoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.PedidoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.PedidoEntity;

public class PedidoBusinessLogicImpl implements PedidoBusinessLogic {

	private DAOFactory factory;
	
	public PedidoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void registrarNuevoPedido(PedidoDomain pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarPedidoExistente(UUID id, PedidoDomain pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaDefinitivamentePedidoExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PedidoDomain consultarPedidoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDomain> consultarPedidos(PedidoDomain filtro) throws LilfacException {
		
		PedidoEntity PedidoFilter = null; // MAGIA DE TRADUCIR DE domain-›entity 
		List<PedidoEntity> PedidoEntities = factory.getPedidoDAO().listByFIlter(PedidoFilter);
		
		List<PedidoDomain> datosARetornar = null;
		return datosARetornar;
		
	}

}
