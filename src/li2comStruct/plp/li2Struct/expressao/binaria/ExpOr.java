package li2comStruct.plp.li2Struct.expressao.binaria;

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
 * Um objeto desta classe representa uma Disjuncao Logica.
 */
public class ExpOr extends ExpBinaria {

    /**
     * Controi uma expressao de disjuncao logica  com as sub-expressoes
     * especificadas.Estas devem ser tais que sua avaliacao resulta em
     * <code>ValorBooleano</code>
     *
     * @param esq expressao da esquerda
     * @param dir expressao da direita
     */
    public ExpOr(Expressao esq, Expressao dir){
        super(esq, dir, "or");
    }


    /**
     * Retorna o valor da expressao de disjuncao logica
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
             ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
    return obterComparacaoOR(ambiente);
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
            ((TipoPrimitivo)getEsq().getTipo(ambiente)).eBooleano() &&
            ((TipoPrimitivo)getDir().getTipo(ambiente)).eBooleano()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    /**
     * Retorna os tipos possiveis desta expressao.
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente) {
        return TipoPrimitivo.TIPO_BOOLEANO;
    }

    /**
     * Retorna o resultado de uma comparacao booleana OR
     * @param ambiente � o Ambiente de Execu��o
     * @return o resultado de uma comparacao booleana OR
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorBooleano obterComparacaoOR(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        return new ValorBooleano(
                ((ValorBooleano)getEsq().avaliar(ambiente)).valor() ||
                ((ValorBooleano)getDir().avaliar(ambiente)).valor() );
    }
}