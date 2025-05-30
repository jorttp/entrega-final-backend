package co.edu.co.lilfac.crosscutting.utilitarios;

public class UtilCorreo {
	
	private static UtilCorreo instancia = new UtilCorreo();
	private static String PATRON_CARACTERES_PERMITIDOS = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$";
	
	public static UtilCorreo getInstance() {
		return instancia;
	}
	
	public boolean patronEsValido(final String valor, final String patron) {
		return UtilTexto.getInstance().obtenerValorDefecto(valor).matches(UtilTexto.getInstance().obtenerValorDefecto(patron));
	}
	
	public boolean esCorreoValido(final String valor) {
		return patronEsValido(valor, PATRON_CARACTERES_PERMITIDOS);
	}

}
