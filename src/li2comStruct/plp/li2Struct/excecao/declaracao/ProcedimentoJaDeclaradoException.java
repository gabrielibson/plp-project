package li2comStruct.plp.li2Struct.excecao.declaracao;

import li2comStruct.plp.expressions2.expression.Id;


/**
 * Exce��o lan�ada quando um procedimento est� sendo declarado
 * novamente.
 */
public class ProcedimentoJaDeclaradoException extends Exception {
    /**
     * Construtor
     * @param id Identificador representando um procedimento.
     */
      public ProcedimentoJaDeclaradoException(Id id) {
        super("Procedimento " + id + " j� declarado.");
      }
}
