package li2comStruct.plp.li2Struct.expressao;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;

/**
 * Uma express�o � a unidade basica na Linguagem de Expressoes.
 */
public interface Expressao {

    /**
     * Avalia a expressao retornando seu Valor.
     * @throws ClasseNaoDeclaradaException TODO
     */
    Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException;

    /**
     * Realiza a verificacao de tipos desta expressao.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *          e tipos.
     * @return <code>true</code> se os tipos da expressao s�o v�lidos;
     *          <code>false</code> caso contrario.
     */
    boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException;

    /**
     * Retorna os tipos possiveis desta expressao.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *          e tipos.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException;

}
