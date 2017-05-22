package li2comStruct.plp.li2Struct.expressao.binaria;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorString;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoPrimitivo;


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
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
            ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
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
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
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
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente) {
        return TipoPrimitivo.TIPO_STRING;
    }

    /**
     * Retorna o valor inteiro que representa o resultado da concatenacao de dois Strings
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor inteiro que representa o resultado da concatenacao de dois Strings
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorString obterResultadoDaConcatenacao(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        return new ValorString(
                    (((Valor)getEsq().avaliar(ambiente))).toString() +
                    (((Valor) getDir().avaliar(ambiente))).toString());
    }
}