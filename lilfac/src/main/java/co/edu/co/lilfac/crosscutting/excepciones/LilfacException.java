package co.edu.co.lilfac.crosscutting.excepciones;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;

public class LilfacException extends Exception{

	private static final long serialVersionUID = 8642214792698024890L;
	
	private String mensajeUsuario;
	private LayerException capa;
	
	protected LilfacException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz, LayerException capa) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setCapa(capa);
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(mensajeUsuario);
	}

	
	public String getMensajeTecnico() {
		return UtilTexto.getInstance().obtenerValorDefecto(getMessage());
	}
	
	public Throwable getExcepcionRaiz() {
		return UtilObjeto.getInstance().obtenerValorDefecto(getCause(), new Exception(getMensajeUsuario()));
	}

	public LayerException getCapa() {
		return capa;
	}

	private void setCapa(LayerException capa) {
		this.capa = UtilObjeto.getInstance().obtenerValorDefecto(capa, LayerException.GENERAL);
	}
	
}