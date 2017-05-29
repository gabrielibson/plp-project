package li2.plp.li2struct.util;

import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;

public interface Tipo {


	
    /**
     * Obt�m o tipo, representado por um identficador.
     * @return o tipo
     */
    public Id getTipo();
    /**
     * Compara dois tipos.
     * @param obj O objeto a ser comparado com este tipo.
     * @return true, se o obj � igual a este tipo, false, caso contr�rio.
     */
    public boolean equals(Object obj);
    /**
     * Verifica se o tipo � v�lido no ambiente.
     * @param ambiente o ambiente de compila�ao, que apresenta o mapeamento
     * entre identificadores e tipos.
     * @return true, se o tipo for v�lido no ambiente, false, caso contr�rio.
     * @throws ClasseNaoDeclaradaException
     */
    public boolean eValido(AmbienteCompilacaoli2Struct ambiente) throws StructNaoDeclaradaException;

}
