package co.edu.co.lilfac.crosscutting.utilitarios;

public final class UtilFloat {
		
	private static UtilFloat instancia = new UtilFloat();
	public static final Float VACIO=0.0f;
	private UtilFloat() {
			
	}
	
	public static UtilFloat getInstance() {
		return instancia;
	}
	
	public boolean esNula(final Float valor) {
		return UtilObjeto.getInstance().esNulo(valor);
	}
	
	public static Float obtenerValorDefecto(final Float valorOriginal, final Float valorDefecto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
	}
	
	public static Float obtenerValorDefecto (final Float valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public Float obtenerValorDefecto () {
		return VACIO;
	}
		
}


