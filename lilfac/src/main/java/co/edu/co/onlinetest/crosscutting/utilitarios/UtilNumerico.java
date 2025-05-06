package co.edu.co.onlinetest.crosscutting.utilitarios;

public final class UtilNumerico {
		
	private static UtilNumerico instancia = new UtilNumerico();
	public static final int VACIO=0;
	private UtilNumerico() {
			
	}
	
	public static UtilNumerico getInstance() {
		return instancia;
	}
	
	public boolean esNula(final int valor) {
		return UtilObjeto.getInstance().esNulo(valor);
	}
	
	public static int obtenerValorDefecto(final int valorOriginal, final int valorDefecto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
	}
	
	public static int obtenerValorDefecto (final int valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public int obtenerValorDefecto () {
		return VACIO;
	}
		
}


