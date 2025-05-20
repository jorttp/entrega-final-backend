package co.edu.co.lilfac.crosscutting.excepciones;

public class DataLilfacException extends LilfacException{

	private static final long serialVersionUID = 2151718273608862250L;

	private DataLilfacException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.DATA);
	}
	
	public static LilfacException reportar(String mensajeUsuario) {
		return new DataLilfacException(mensajeUsuario, mensajeUsuario, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico) {
		return new DataLilfacException(mensajeUsuario, mensajeTecnico, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new DataLilfacException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
