package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;

public class CostoAdicionalDomain {
	private UUID id;
	private float valor;
	private String descripcion;
	private RecepcionDomain recepcion;
	
	CostoAdicionalDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setValor(UtilFloat.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
		setRecepcion(RecepcionDomain.obtenerValorDefecto());
	}
	
	public CostoAdicionalDomain(final UUID id) {
		setId(id);
		setValor(UtilFloat.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
		setRecepcion(RecepcionDomain.obtenerValorDefecto());
		
	}
	
	public CostoAdicionalDomain(final UUID id, final float valor, final String descripcion, final RecepcionDomain recepcion) {
		setId(id);
		setValor(valor);
		setDescripcion(descripcion);
		setRecepcion(recepcion);
	}
	
	static CostoAdicionalDomain obtenerValorDefecto() {
		return new CostoAdicionalDomain();
	}
	
	public static CostoAdicionalDomain obtenerValorDefecto(final CostoAdicionalDomain costoAdicional ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(costoAdicional , obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public float getValor() {
		return valor;
	}

	private void setValor(float valor) {
		this.valor = UtilFloat.obtenerValorDefecto(valor);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
	}
	
	public RecepcionDomain getRecepcion() {
		return recepcion;
	}

	private void setRecepcion(RecepcionDomain recepcion) {
		this.recepcion = RecepcionDomain.obtenerValorDefecto(recepcion);
	}

}
