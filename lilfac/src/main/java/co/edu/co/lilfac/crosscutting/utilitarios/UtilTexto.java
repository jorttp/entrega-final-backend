package co.edu.co.lilfac.crosscutting.utilitarios;

public final class UtilTexto {
		
	private static UtilTexto instancia = new UtilTexto();
	public static final String PATRON_SOLO_LETRAS_ESPACIOS ="^[a-zA-ZáÁéÉíÍóÓúÚüÜñÑ ]+$";
	public static final String VACIO="";
	private UtilTexto() {
			
	}
	
	public boolean patronEsValido(final String valor, final String patron) {
		return obtenerValorDefecto(valor).matches(obtenerValorDefecto(patron));
	}
	
	public boolean ContieneSoloLetrasEspacios(final String valor) {
		return patronEsValido(quitarEspaciosBlancoInicioFin(valor), PATRON_SOLO_LETRAS_ESPACIOS);
	}
	
	public boolean estaVacia(final String valor) {
		return VACIO.equals(quitarEspaciosBlancoInicioFin(valor));
	}
	
	public static UtilTexto getInstance() {
		return instancia;
	}
	
	public boolean esNula(final String valor) {
		return UtilObjeto.getInstance().esNulo(valor);
	}
	
	public String obtenerValorDefecto(final String valorOriginal, final String valorDefecto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
	}
	
	public String obtenerValorDefecto (final String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public String obtenerValorDefecto () {
		return VACIO;
	}
	
	public String quitarEspaciosBlancoInicioFin(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
		
}



