package li2comStruct.plp.li2Struct.declaracao.variavel;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.declaracao.Declaracao;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseJaDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;

/**
 * Interface representando uma declara��o de vari�vel.
 */
public interface DecVariavel extends Declaracao {

    /**
     * Retorna o tipo do identificador a ser declarado no AmbienteCompilacao
     * @param id o identificador  da declaracao
     * @return o tipo do identificador
     */
    public Tipo getTipo(Id id)
        throws VariavelNaoDeclaradaException ;

    /**
     * Cria um mapeamento do identificador para o valor da express�o
     * desta declara��o no AmbienteExecucao
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e valores.
     * @return o ambiente modificado pela inicializa��o da vari�vel.
     */
    public AmbienteExecucaoImperativa2 elabora(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
               ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
               ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException ;

    /**
     * Verifica se a declara��o est� bem tipada, ou seja, se a
     * express�o de inicializa��o est� bem tipada.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e seus tipos.
     * @return <code>true</code> se os tipos da declara��o s�o v�lidos;
     *          <code>false</code> caso contrario.
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               ClasseJaDeclaradaException, ClasseNaoDeclaradaException;
}
