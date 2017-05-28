package li2.plp.li2struct.expression.binaria;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorBooleano;
import li2.plp.li2struct.expression.valor.ValorConcreto;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;
import li2.plp.li2struct.util.TipoStruct;

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
    public Valor avaliar(AmbienteExecucaoli2Struct ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
        InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
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
    public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
        boolean result = false;
        if (super.checaTipo(ambiente)) {
           if(getEsq().getTipo(ambiente) instanceof TipoStruct) {
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
    public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente) {
        return TipoPrimitivo.TIPO_BOOLEANO;
    }

    /**
     * Retorna o valor booleano que representa o resultado da comparacao de igualdade
     * de duas expressoes
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor inteiro que representa o resultado da concatenacao de dois Strings
     * @throws ClasseNaoDeclaradaException 
     */
    private ValorBooleano verificarIgualdade(AmbienteExecucaoli2Struct ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException{
        Valor v1 = (Valor) getEsq().avaliar(ambiente);
        Valor v2 = (Valor) getDir().avaliar(ambiente);
        boolean compara;
        if (v1 instanceof ValorConcreto && v2 instanceof ValorConcreto){
            compara = ((ValorConcreto)v1).equals((ValorConcreto)(v2));
        } else {
            compara =  v1.equals(v2);
        }
        return new ValorBooleano(compara);
    }
}