package li2.plp.li2struct.expression.binaria;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorBooleano;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

/**
 * Um objeto desta classe representa uma expressao de Conjuncao logica.
 */
public class ExpAnd extends ExpBinaria{

    /**
     * Controi uma expressao de Conjuncao logica  com as sub-expressoes
     * especificadas. Estas devem ser tais que sua avaliacao retorna
     * <code>ValorBooleano</code>
     *
     * @param esq expressao da esquerda
     * @param dir expressao da direita
     */
    public ExpAnd(Expressao esq, Expressao dir) {
        super(esq, dir, "and");
    }


    /**
     * Retorna o valor da expressao de Conjuncao Logica
     * @ambiente O ambiente de execu�ao, contendo o mapeamento
     * de identificadores a valores.
     */
     public Valor avaliar(AmbienteExecucaoli2Struct ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
        return obterComparacaoAND(ambiente);
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
     *
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente) {
        return TipoPrimitivo.TIPO_BOOLEANO;
    }

/**
 * Retorna o resultado de uma comparacao booleana AND
 * @param ambiente � o Ambiente de Execu��o
 * @return o resultado de uma comparacao booleana AND
 * @throws ClasseNaoDeclaradaException 
 */
    private ValorBooleano obterComparacaoAND(AmbienteExecucaoli2Struct ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException{
        return new ValorBooleano(
                    ((ValorBooleano)getEsq().avaliar(ambiente)).valor() &&
                    ((ValorBooleano)getDir().avaliar(ambiente)).valor()
        );
    }
}