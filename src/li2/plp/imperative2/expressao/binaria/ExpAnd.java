package li2.plp.imperative2.expressao.binaria;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.exception.InstanciaStructNaoDeclaradoException;
import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.expressao.Expressao;
import li2.plp.imperative2.expressao.valor.Valor;
import li2.plp.imperative2.expressao.valor.ValorBooleano;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.imperative2.util.Tipo;
import li2.plp.imperative2.util.TipoPrimitivo;


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
     public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException{
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
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
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
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente) {
        return TipoPrimitivo.TIPO_BOOLEANO;
    }

/**
 * Retorna o resultado de uma comparacao booleana AND
 * @param ambiente � o Ambiente de Execu��o
 * @return o resultado de uma comparacao booleana AND
 * @throws ClasseNaoDeclaradaException 
 */
    private ValorBooleano obterComparacaoAND(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
                   InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException{
        return new ValorBooleano(
                    ((ValorBooleano)getEsq().avaliar(ambiente)).valor() &&
                    ((ValorBooleano)getDir().avaliar(ambiente)).valor()
        );
    }
}