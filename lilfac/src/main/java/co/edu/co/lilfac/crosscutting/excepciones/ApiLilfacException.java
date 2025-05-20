package co.edu.co.lilfac.crosscutting.excepciones;

public class ApiLilfacException extends LilfacException{

	private static final long serialVersionUID = 2151718273608862250L;

	private ApiLilfacException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.API);
	}
	
	public static LilfacException reportar(String mensajeUsuario) {
		return new ApiLilfacException(mensajeUsuario, mensajeUsuario, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico) {
		return new ApiLilfacException(mensajeUsuario, mensajeTecnico, new Exception());
	}
	
	public static LilfacException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new ApiLilfacException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
