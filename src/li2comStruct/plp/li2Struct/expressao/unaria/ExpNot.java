package li2comStruct.plp.li2Struct.expressao.unaria;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorBooleano;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoPrimitivo;


/**
 * Um objeto desta classe representa uma expressao de Negacao logica.
 */
public class ExpNot extends ExpUnaria{

    /**
     * Controi uma expressao de negacao logica com expressao
     * especificada.
     *
     * @param exp expressao a ser negada. Assume-se que sua avaliacao resulta
     *        em <code>ValorBooleano</code>.
     */
    public ExpNot(Expressao expressao) {
        super(expressao, "~");
    }

    /**
     * Retorna o valor da expressao de negacao logica.
     *
     * @param ambiente o ambiente de execu��o.
     * @return o valor da expressao avaliada.
     * @excepion VariavelJaDeclaradaException se a vari�vel j� est�
     *           declarada no ambiente.
     * @exception VariavelNaoDeclaradaException se a vari�vel n�o est�
     *            declarada no ambiente.
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
        ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        return obterValorInverso(ambiente);
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
            ((TipoPrimitivo)getExp().getTipo(ambiente)).eBooleano()) {
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
        return TipoPrimitivo.TIPO_BOOLEANO;
    }

    /**
     * Retorna o valor inverso de uma express�o booleana
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor inverso da express�o booleana
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorBooleano obterValorInverso(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        return new ValorBooleano(!((ValorBooleano) getExp().avaliar(ambiente)).valor());
    }
}
