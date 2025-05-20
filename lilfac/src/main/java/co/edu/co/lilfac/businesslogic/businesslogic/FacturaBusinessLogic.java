package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface FacturaBusinessLogic {
	
	void registrarNuevaFactura(FacturaDomain factura)throws LilfacException;
	void modificarFacturaExistente(UUID id, FacturaDomain factura)throws LilfacException;
	void darBajaDefinitivamenteFacturaExistente(UUID id)throws LilfacException;
	FacturaDomain consultarFacturaPorId(UUID id)throws LilfacException;
	List<FacturaDomain> consultarFacturas(FacturaDomain filtro)throws LilfacException;

}
