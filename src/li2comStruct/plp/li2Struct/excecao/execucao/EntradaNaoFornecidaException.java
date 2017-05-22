package li2comStruct.plp.li2Struct.excecao.execucao;

/**
 * Exce��o lan�ada quando uma entrada esperada n�o � fornecida.
 */
public class EntradaNaoFornecidaException extends Exception {
    /**
     * Construtor.
     */
    public EntradaNaoFornecidaException() {
        super("Forneca os valores de entrada do programa!");
    }

}
