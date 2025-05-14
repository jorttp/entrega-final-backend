package co.edu.co.lilfac.businesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.domain.FacturaDomain;

public interface FacturaBusinessLogic {
	
	void registrarNuevaFactura(FacturaDomain factura);
	void modificarFacturaExistente(UUID id, FacturaDomain factura);
	void darBajaDefinitivamenteFacturaExistente(UUID id);
	FacturaDomain consultarFacturaPorId(UUID id);
	List<FacturaDomain> consultarFacturas(FacturaDomain filtro);

}
