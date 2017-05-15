package li2.plp.imperative2.exception;

import li2.plp.expressions2.expression.Id;

/**
 * Exce��o lan�ada qunado o objeto que est� sendo declarado j� o foi
 * anteriormente.
 */
public class InstanciaStructJaDeclaradoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Construtor
     * @param id Identificador representando o objeto.
     */
    public InstanciaStructJaDeclaradoException(Id id) {
        super("Objeto" + id + " j� declarado.");
    }

}
