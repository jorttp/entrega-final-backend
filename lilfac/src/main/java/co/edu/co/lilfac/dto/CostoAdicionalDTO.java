package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;

public class CostoAdicionalDTO {
	private UUID id;
	private Float valor;
	private String descripcion;
	private RecepcionDTO recepcion;
	
	public CostoAdicionalDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setValor(UtilFloat.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
		setRecepcion(RecepcionDTO.obtenerValorDefecto());
	}
	
	public CostoAdicionalDTO(final UUID id) {
		setId(id);
		setValor(UtilFloat.getInstance().obtenerValorDefecto());
		setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
		setRecepcion(RecepcionDTO.obtenerValorDefecto());
		
	}
	
	public CostoAdicionalDTO(final UUID id, final Float valor, final String descripcion, final RecepcionDTO recepcion) {
		setId(id);
		setValor(valor);
		setDescripcion(descripcion);
		setRecepcion(recepcion);
	}
	
	public static CostoAdicionalDTO obtenerValorDefecto() {
		return new CostoAdicionalDTO();
	}
	
	public static CostoAdicionalDTO obtenerValorDefecto(final CostoAdicionalDTO costoAdicional ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(costoAdicional , obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public CostoAdicionalDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}
	
	public Float getValor() {
		return valor;
	}

	public CostoAdicionalDTO setValor(Float valor) {
		this.valor = UtilFloat.obtenerValorDefecto(valor);
		return this;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public CostoAdicionalDTO setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
		return this;
	}
	
	public RecepcionDTO getRecepcion() {
		return recepcion;
	}

	public CostoAdicionalDTO setRecepcion(RecepcionDTO recepcion){
		this.recepcion = RecepcionDTO.obtenerValorDefecto(recepcion);
		return this;
	}

}
