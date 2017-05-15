package li2.plp.imperative2.exception.execucao;
/**
 * Exceï¿½ï¿½o lanï¿½ada quando uma entrada fornecida durante a execuï¿½ï¿½o ï¿½ invï¿½lida.
 */
public class EntradaInvalidaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Construtor Default.
     */
    public EntradaInvalidaException() {
        super("A entrada fornecida não pode ser atribuída a um identificador desse tipo!");
    }

    /**
     * Construtor com uma mensagem como parï¿½metro.
     * @param mensagem Mensagem com o erro.
     */
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}