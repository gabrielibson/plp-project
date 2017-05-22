package li2comStruct.plp.li2Struct.expressao.binaria;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorInteiro;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoPrimitivo;

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
            ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
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
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
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
                   ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        return new ValorInteiro(
                ((ValorInteiro)getEsq().avaliar(ambiente)).valor() -
                ((ValorInteiro)getDir().avaliar(ambiente)).valor());
    }
}
