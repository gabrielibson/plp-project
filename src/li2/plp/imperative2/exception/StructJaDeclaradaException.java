package li2.plp.imperative2.exception;

import li2.plp.expressions2.expression.Id;

/**
 * Exce��o lan�ada quando a classe que est� sendo declarada, j� o foi
 * anteriormente.
 */
public class StructJaDeclaradaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Construtor
     * @param id Identificador representando a classe.
     */
    public StructJaDeclaradaException(Id id) {
        super("Classe " + id + " j� declarada.");
    }
}
