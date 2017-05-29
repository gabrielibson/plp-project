package li2.plp.li2struct.expression.binaria;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorString;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

/**
* Um objeto desta classe representa uma expressao de Concatenacao entre
* objetos <code>ValorString</code>
*/
public class ExpConcat extends ExpBinaria{


    /**
     * Controi uma expressao de Concatenacao com as sub-expressoes especificadas.
     * Estas sub-expressoes devem ser tais que a avaliacao das mesmas resulta
     * em <code>ValorString</code>
     *
     * @param esq expressao da esquerda
     * @param dir expressao da direita
     */
    public ExpConcat(Expressao esq, Expressao dir){
        super(esq, dir, "++");
    }

    /**
     * Retorna o valor da expressao de Concatenacao
     */
    public Valor avaliar(AmbienteExecucaoli2Struct ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
            InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
        return obterResultadoDaConcatenacao(ambiente);
    }

    /**
     * Realiza a verificacao de tipos desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return <code>true</code> se os tipos da expressao s�o v�lidos;
     *          <code>false</code> caso contrario.
     * @exception VariavelNaoDeclaradaException se existir um identificador
     *          nao declarado no ambiente.
     * @exception VariavelNaoDeclaradaException se existir um identificador
     *          declarado mais de uma vez no mesmo bloco do ambiente.
     */
    public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
        boolean result;
        if (super.checaTipo(ambiente) &&
            ((TipoPrimitivo)getEsq().getTipo(ambiente)).eString() ||//we changed && to ||
            ((TipoPrimitivo)getDir().getTipo(ambiente)).eString()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    /**
     * Retorna os tipos possiveis desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente) {
        return TipoPrimitivo.TIPO_STRING;
    }

    /**
     * Retorna o valor inteiro que representa o resultado da concatenacao de dois Strings
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor inteiro que representa o resultado da concatenacao de dois Strings
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorString obterResultadoDaConcatenacao(AmbienteExecucaoli2Struct ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException{
        return new ValorString(
                    (((Valor)getEsq().avaliar(ambiente))).toString() +
                    (((Valor) getDir().avaliar(ambiente))).toString());
    }
}