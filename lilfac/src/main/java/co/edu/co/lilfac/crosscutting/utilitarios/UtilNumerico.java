package co.edu.co.lilfac.crosscutting.utilitarios;

public final class UtilNumerico {
		
	private static UtilNumerico instancia = new UtilNumerico();
	public static final int VACIO=0;
	private UtilNumerico() {
			
	}
	
	public static UtilNumerico getInstance() {
		return instancia;
	}
	
	public boolean esNula(final Integer valor) {
		return UtilObjeto.getInstance().esNulo(valor);
	}
	
	public static Integer obtenerValorDefecto(final Integer valorOriginal, final Integer valorDefecto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
	}
	
	public static Integer obtenerValorDefecto (final Integer valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public Integer obtenerValorDefecto () {
		return VACIO;
	}
		
}


