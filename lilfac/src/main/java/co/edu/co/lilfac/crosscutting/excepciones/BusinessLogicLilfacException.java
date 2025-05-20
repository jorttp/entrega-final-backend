package co.edu.co.lilfac.crosscutting.excepciones;

public class BusinessLogicLilfacException extends LilfacException{

	private static final long serialVersionUID = 2151718273608862250L;

	private BusinessLogicLilfacException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESSLOGIC);
	}
	
	public static LilfacException reportar(String mensajeUsuario) {
		return new BusinessLogicLilfacException(mensajeUsuario, mensajeUsuario, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico) {
		return new BusinessLogicLilfacException(mensajeUsuario, mensajeTecnico, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new BusinessLogicLilfacException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
