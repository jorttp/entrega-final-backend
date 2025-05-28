package co.edu.co.lilfac.businesslogic.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.factura.dto.FacturaDTOAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.co.lilfac.businesslogic.businesslogic.impl.FacturaBusinessLogicImpl;
import co.edu.co.lilfac.businesslogic.facade.FacturaFacade;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.data.dao.factory.Factory;
import co.edu.co.lilfac.dto.FacturaDTO;

public class FacturaFacadeImpl implements FacturaFacade{

	
	private DAOFactory daoFactory;
	private FacturaBusinessLogic facturaBusinessLogic;
	
	public FacturaFacadeImpl() throws LilfacException {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
		facturaBusinessLogic = new FacturaBusinessLogicImpl(daoFactory);
	} 
	
	
	@Override
	public void registrarNuevaFactura(FacturaDTO factura) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			FacturaDomain facturaDomain = FacturaDTOAssembler.getInstance().toDomain(factura);
			facturaBusinessLogic.registrarNuevaFactura(facturaDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva factura";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la información de una nueva factura";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarFacturaExistente(UUID id, FacturaDTO factura) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			FacturaDomain facturaDomain = FacturaDTOAssembler.getInstance().toDomain(factura);
			facturaBusinessLogic.modificarFacturaExistente(id, facturaDomain);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de modificar la información de la factura con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la información de la factura con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaDefinitivamenteFacturaExistente(UUID id) throws LilfacException {
		try {
			daoFactory.iniciarTransaccion();
			facturaBusinessLogic.darBajaDefinitivamenteFacturaExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de borrar la información de la factura con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de borrar la información de la factura con el identificador ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public FacturaDTO consultarFacturaPorId(UUID id) throws LilfacException {
		try {
			var facturaDomainResultado = facturaBusinessLogic.consultarFacturaPorId(id);		
			return FacturaDTOAssembler.getInstance().toDto(facturaDomainResultado);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de una factura con el id deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de una factura con el id ingresado";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<FacturaDTO> consultarFacturas(FacturaDTO filtro) throws LilfacException {
		try {
			var facturaFilter = FacturaDTOAssembler.getInstance().toDomain(filtro);
			List<FacturaDomain> facturasDomain = facturaBusinessLogic.consultarFacturas(facturaFilter);
			return FacturaDTOAssembler.getInstance().toDto(facturasDomain);
		} catch (LilfacException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de las facturas";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar la informacion de las facturas";
			
			throw BusinessLogicLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
