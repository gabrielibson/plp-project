package li2comStruct.plp.li2Struct.excecao.declaracao;

import li2comStruct.plp.expressions2.expression.Id;
/**
 * Exce��o lan�ada qunado o objeto que est� sendo declarado j� o foi
 * anteriormente.
 */
public class ObjetoJaDeclaradoException extends Exception {
    /**
     * Construtor
     * @param id Identificador representando o objeto.
     */
    public ObjetoJaDeclaradoException(Id id) {
        super("Objeto" + id + " j� declarado.");
    }

}
