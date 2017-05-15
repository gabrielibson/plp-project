package li2.plp.imperative2.exception;

import li2.plp.expressions2.expression.Id;

/**
 * Exce��o lan�ada quando uma classe que est� sendo referenciada
 * n�o foi declarada anteriormente.
 */
public class StructNaoDeclaradaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Construtor
     * @param id Identificador representando a classe.
     */
    public StructNaoDeclaradaException(Id id) {
        super("Classe " + id + " n�o declarada.");
    }
}