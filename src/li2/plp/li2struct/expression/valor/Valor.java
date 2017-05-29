package li2.plp.li2struct.expression.valor;

import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.util.Tipo;

/**
 * <code>Valor</code> agrupa objetos dos diferentes valores primitivos
 */
public interface Valor extends Expressao {


    /**
     * Retorna o tipo do valor.
     * @param ambiente o ambiente de compila��o.
     * @return o tipo do valor.
     */
    public abstract Tipo getTipo(AmbienteCompilacaoli2Struct ambiente);

}


