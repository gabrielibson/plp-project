package li2comStruct.plp.li2Struct.expressao.unaria;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorInteiro;
import li2comStruct.plp.li2Struct.expressao.valor.ValorString;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoPrimitivo;


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
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException,
            VariavelNaoDeclaradaException, ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
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
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
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
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente) {
        return TipoPrimitivo.TIPO_INTEIRO;
    }

    /**
     * Retorna o tamanho de um String
     * @param ambiente � o Ambiente de Execu��o
     * @return o tamanho de um String
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorInteiro obterTamanhoDoString(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        return new ValorInteiro (((ValorString)getExp().avaliar(ambiente)).valor().length());
    }
}