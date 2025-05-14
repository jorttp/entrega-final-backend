package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.dto.FacturaDTO;

public interface FacturaFacade {
	
	void registrarNuevaFactura(FacturaDTO factura);
	void modificarFacturaExistente(UUID id, FacturaDTO factura);
	void darBajaDefinitivamenteFacturaExistente(UUID id);
	FacturaDTO consultarFacturaPorId(UUID id);
	List<FacturaDTO> consultarFacturas(FacturaDTO filtro);

}
