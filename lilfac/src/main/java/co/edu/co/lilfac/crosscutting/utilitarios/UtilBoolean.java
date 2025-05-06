package co.edu.co.lilfac.crosscutting.utilitarios;

public final class UtilBoolean {
		
	private static UtilBoolean instancia = new UtilBoolean();
	public static final Boolean FALSO=Boolean.FALSE;
	private UtilBoolean() {
			
	}
	
	public static UtilBoolean getInstance() {
		return instancia;
	}
	
	public boolean esNula(final Boolean valor) {
		return UtilObjeto.getInstance().esNulo(valor);
	}
	
	public static Boolean obtenerValorDefecto(final Boolean valorOriginal, final Boolean valorDefecto) {
		return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
	}
	
	public static Boolean obtenerValorDefecto (final Boolean valor) {
		return obtenerValorDefecto(valor, FALSO);
	}
	
	public Boolean obtenerValorDefecto () {
		return FALSO;
	}
		
}


