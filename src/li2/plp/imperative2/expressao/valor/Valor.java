package li2.plp.imperative2.expressao.valor;

import li2.plp.imperative2.expressao.Expressao;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;
import li2.plp.imperative2.util.Tipo;

/**
 * <code>Valor</code> agrupa objetos dos diferentes valores primitivos
 */
public interface Valor extends Expressao {


    /**
     * Retorna o tipo do valor.
     * @param ambiente o ambiente de compila��o.
     * @return o tipo do valor.
     */
    public abstract Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente);

}


