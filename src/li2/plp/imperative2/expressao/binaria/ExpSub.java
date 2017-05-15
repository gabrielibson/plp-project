package li2.plp.imperative2.expressao.binaria;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.exception.InstanciaStructNaoDeclaradoException;
import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.expressao.Expressao;
import li2.plp.imperative2.expressao.valor.Valor;
import li2.plp.imperative2.expressao.valor.ValorInteiro;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.imperative2.util.Tipo;
import li2.plp.imperative2.util.TipoPrimitivo;


/**
* Um objeto desta classe representa uma expressao de Subtracao.
*/
public class ExpSub extends ExpBinaria {

    /**
     * Controi uma expressao de Subtracao com as sub-expressoes especificadas.
     * Assume-se que estas expressoes resultam em <code>ValorInteiro</code>
     * quando avaliadas.
     *
     * @param esq expressao da esquerda
     * @param dir expressao da direita
     */
    public ExpSub(Expressao esq, Expressao dir) {
        super(esq, dir, "-");
    }

    /**
     * Retorna o valor da expressao de Subtracao.
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
            InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException {
        return obterResultadoDaSubtracao(ambiente);
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
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
        boolean result;
        if (super.checaTipo(ambiente) &&
            ((TipoPrimitivo)getEsq().getTipo(ambiente)).eInteiro() &&
            ((TipoPrimitivo)getDir().getTipo(ambiente)).eInteiro()) {
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
     * Retorna o valor inteiro que representa o resultado da subtracao das duas express�es
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor inteiro que representa o resultado da subtracao das duas express�es
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorInteiro obterResultadoDaSubtracao(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException{
        return new ValorInteiro(
                ((ValorInteiro)getEsq().avaliar(ambiente)).valor() -
                ((ValorInteiro)getDir().avaliar(ambiente)).valor());
    }
}
