package li2comStruct.plp.li2Struct.excecao.declaracao;

import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
/**
 * Exce��o lan�ada quando uma vari�vel est� sendo declarada mais de uma
 * vez num mesmo escopo.
 */
public class VariavelJaDeclaradaException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
    /**
     * Construtor.
     * @param id Identificador representando uma vari�vel.
     */
    public VariavelJaDeclaradaException(Id id){
        super("Variavel " + id + " ja declarada.");
    }
}
