package li2comStruct.plp.li2Struct.expressao.valor;

import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;

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


