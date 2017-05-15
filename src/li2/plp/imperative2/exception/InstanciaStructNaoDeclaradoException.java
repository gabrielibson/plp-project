package li2.plp.imperative2.exception;

import li2.plp.expressions2.expression.Id;

/**
 * Exce��o lan�ada quando o objeto que est� sendo referenciado n�o
 * foi declarado.
 */
public class InstanciaStructNaoDeclaradoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Construtor.
     * @param id Identificador representando o objeto.
     */
    public InstanciaStructNaoDeclaradoException(Id id) {
        super("Objeto" + id + " n�o declarado.");
    }
}