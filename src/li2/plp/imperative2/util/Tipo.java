package li2.plp.imperative2.util;


import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.expressao.leftExpression.Id;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;

/**
 * Interface  representando um tipo.
 */
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
     * @throws StructNaoDeclaradaException
     */
    public boolean eValido(AmbienteCompilacaoImperativa2 ambiente) throws StructNaoDeclaradaException;
}
