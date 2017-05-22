package li2comStruct.plp.li2Struct.expressao.binaria;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorBooleano;
import li2comStruct.plp.li2Struct.expressao.valor.ValorConcreto;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoStruct;
import li2comStruct.plp.li2Struct.util.TipoPrimitivo;


/**
 * Um objeto desta classe representa uma expressao de Igualdade entre
 * Expressoes cuja avaliacao resulta num mesmo valor primitivo.
 */
public class ExpEquals extends ExpBinaria{

    /**
     * Controi uma expressao de Igualdade com as sub-expressoes especificadas.
     * Assume-se que estas sub-expressoes resultam num mesmo valor primitivo
     * quando avaliadas.
     * @param esq expressao da esquerda
     * @param dir expressao da direita
     */
    public ExpEquals(Expressao esq, Expressao dir){
        super(esq, dir, "==");
    }

    /**
     * Retorna o valor da expressao de Igualdade
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
        ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
        return verificarIgualdade(ambiente);
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
        boolean result = false;
        if (super.checaTipo(ambiente)) {
           if(getEsq().getTipo(ambiente) instanceof TipoStruct) {
            result = getDir().getTipo(ambiente).equals(TipoStruct.TIPO_NULL) ||
                     getEsq().getTipo(ambiente).equals(getDir().getTipo(ambiente));
           }
           else {
            result = getEsq().getTipo(ambiente).equals(getDir().getTipo(ambiente));
           }
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
     * Retorna o valor booleano que representa o resultado da comparacao de igualdade
     * de duas expressoes
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor inteiro que representa o resultado da concatenacao de dois Strings
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorBooleano verificarIgualdade(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
        Valor v1 = getEsq().avaliar(ambiente);
        Valor v2 = getDir().avaliar(ambiente);
        boolean compara;
        if (v1 instanceof ValorConcreto && v2 instanceof ValorConcreto){
            compara = ((ValorConcreto)v1).equals((ValorConcreto)(v2));
        } else {
            compara =  v1.equals(v2);
        }
        return new ValorBooleano(compara);
    }
}