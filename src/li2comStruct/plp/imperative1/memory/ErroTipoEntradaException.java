package li2comStruct.plp.imperative1.memory;

public class ErroTipoEntradaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroTipoEntradaException() {
	    super("Tipo do valor de entrada lido incomp�tivel");
	  }
	
	public ErroTipoEntradaException(String msg) {
	    super(msg);
	  }

}
