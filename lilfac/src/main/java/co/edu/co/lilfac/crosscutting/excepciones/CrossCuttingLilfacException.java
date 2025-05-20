package co.edu.co.lilfac.crosscutting.excepciones;

public class CrossCuttingLilfacException extends LilfacException{

	private static final long serialVersionUID = 2151718273608862250L;

	private CrossCuttingLilfacException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.CROSSCUTTING);
	}
	
	public static LilfacException reportar(String mensajeUsuario) {
		return new CrossCuttingLilfacException(mensajeUsuario, mensajeUsuario, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico) {
		return new CrossCuttingLilfacException(mensajeUsuario, mensajeTecnico, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new CrossCuttingLilfacException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
