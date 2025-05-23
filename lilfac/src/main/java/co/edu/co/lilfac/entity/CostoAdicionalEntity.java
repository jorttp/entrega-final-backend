package co.edu.co.lilfac.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;

public class CostoAdicionalEntity {
	private UUID id;
	private Float valor;
	private String descripcion;
	private RecepcionEntity recepcion;
	private boolean objetoVacio;
	
	public CostoAdicionalEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setValor(UtilFloat.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
		setRecepcion(RecepcionEntity.obtenerValorDefecto());
	}
	
	public CostoAdicionalEntity(final UUID id) {
		setId(id);
		setValor(UtilFloat.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
		setRecepcion(RecepcionEntity.obtenerValorDefecto());
		
	}
	
	public CostoAdicionalEntity(final UUID id, final Float valor, final String descripcion, final RecepcionEntity recepcion) {
		setId(id);
		setValor(valor);
		setDescripcion(descripcion);
		setRecepcion(recepcion);
	}
	
	public static CostoAdicionalEntity obtenerValorDefecto() {
		return new CostoAdicionalEntity();
	}
	
	public static CostoAdicionalEntity obtenerValorDefecto(final CostoAdicionalEntity costoAdicional ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(costoAdicional , obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = UtilFloat.obtenerValorDefecto(valor);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
	}
	
	public RecepcionEntity getRecepcion() {
		return recepcion;
	}

	public void setRecepcion(RecepcionEntity recepcion) {
		this.recepcion = RecepcionEntity.obtenerValorDefecto(recepcion);
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}

}
