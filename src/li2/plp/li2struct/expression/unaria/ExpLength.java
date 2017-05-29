package li2.plp.li2struct.expression.unaria;


import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorInteiro;
import li2.plp.li2struct.expression.valor.ValorString;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

/**
 * Um objeto desta classe representa uma expressao de tamanho de String.
 */
public class ExpLength extends ExpUnaria {

    /**
     * Controi uma expressao de tamanho  com a expressao especificada
     * assume-se que <code>exp</code> &eacute; uma expressao cuja avaliacao
     * resulta num <code>ValorString</code>
     *
     * @param exp a expressao em quest�o.
     */
    public ExpLength(Expressao expressao) {
        super(expressao, "length");
    }

    /**
     * Retorna o valor da expressao de tamanho.
     *
     * @param ambiente o ambiente de execu��o.
     * @return o valor da expressao avaliada.
     * @exception VariavelNaoDeclaradaException se existir um identificador
     *          nao declarado no ambiente.
     * @exception VariavelNaoDeclaradaException se existir um identificador
     *          declarado mais de uma vez no mesmo bloco do ambiente.
     */
    public Valor avaliar(AmbienteExecucaoli2Struct ambiente)
        throws VariavelJaDeclaradaException,
            VariavelNaoDeclaradaException, InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
        return obterTamanhoDoString(ambiente);
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
            ((TipoPrimitivo)getExp().getTipo(ambiente)).eString()) {
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
        return TipoPrimitivo.TIPO_INTEIRO;
    }

    /**
     * Retorna o tamanho de um String
     * @param ambiente � o Ambiente de Execu��o
     * @return o tamanho de um String
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorInteiro obterTamanhoDoString(AmbienteExecucaoli2Struct ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException{
        return new ValorInteiro (((ValorString)getExp().avaliar(ambiente)).valor().length());
    }
}