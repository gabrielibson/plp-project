package li2.plp.imperative2.expressao;


import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.exception.InstanciaStructNaoDeclaradoException;
import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.expressao.valor.Valor;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.imperative2.util.Tipo;

/**
 * Uma express�o � a unidade basica na Linguagem de Expressoes.
 */
public interface Expressao {

    /**
     * Avalia a expressao retornando seu Valor.
     * @throws StructNaoDeclaradaException TODO
     */
    Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
        InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException;

    /**
     * Realiza a verificacao de tipos desta expressao.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *          e tipos.
     * @return <code>true</code> se os tipos da expressao s�o v�lidos;
     *          <code>false</code> caso contrario.
     */
    boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException;

    /**
     * Retorna os tipos possiveis desta expressao.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *          e tipos.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException;

}
