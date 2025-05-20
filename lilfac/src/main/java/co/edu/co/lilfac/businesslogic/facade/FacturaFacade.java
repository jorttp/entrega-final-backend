package co.edu.co.lilfac.businesslogic.facade;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.FacturaDTO;

public interface FacturaFacade {
	
	void registrarNuevaFactura(FacturaDTO factura)throws LilfacException;
	void modificarFacturaExistente(UUID id, FacturaDTO factura)throws LilfacException;
	void darBajaDefinitivamenteFacturaExistente(UUID id)throws LilfacException;
	FacturaDTO consultarFacturaPorId(UUID id)throws LilfacException;
	List<FacturaDTO> consultarFacturas(FacturaDTO filtro)throws LilfacException;

}
