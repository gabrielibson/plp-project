package li2comStruct.plp.li2Struct.declaracao.variavel;

import li2comStruct.plp.expressions2.expression.Valor;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoStruct;

/**
 * Classe que representa uma declara�ao de vari�vel simples.
 */
public class SimplesDecVariavel implements DecVariavel{
    /**
     * Tipo da vari�vel declada.
     */
    private Tipo tipo;
    /**
     * Vari�vel declarada.
     */
    private Id id;
    /**
     * Express�o cujo valor ser� atribu�do � vari�vel.
     */
    private Expressao expressao;
    /**
     * Construtor.
     * @param tipo Tipo da vari�vel declarada.
     * @param id Vari�vel declarada.
     * @param expressao Express�o cujo valor ser� atribu�do � vari�vel.
     */
    public SimplesDecVariavel(Tipo tipo, Id id, Expressao expressao){
        this.tipo = tipo;
        this.id = id;
        this.expressao = expressao;
    }

    /**
    * Retorna o tipo do identificador a ser declarado no AmbienteCompilacao
    * @param id o identificador  da declaracao
    * @return o tipo do identificador
    */
    public Tipo getTipo(Id id) throws VariavelNaoDeclaradaException{
           if(this.id.equals(id)){
               return tipo;
           }
           else {
               throw new VariavelNaoDeclaradaException(id);
           }
    }

    /**
     * Cria um mapeamento do identificador para o valor da express�o
     * desta declara��o no AmbienteExecucao
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e valores.
     * @return o ambiente modificado pela inicializa��o da vari�vel.
     * @throws ClasseNaoDeclaradaException 
     *
     */
    public AmbienteExecucaoImperativa2 elabora(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
               ObjetoNaoDeclaradoException,ObjetoJaDeclaradoException, ClasseNaoDeclaradaException  {
        ambiente.map(id , (Valor) expressao.avaliar(ambiente));
        return ambiente;
    }

    /**
     * Verifica se a declara��o est� bem tipada, ou seja, se a
     * express�o de inicializa��o est� bem tipada.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e seus tipos.
     * @return <code>true</code> se a express�o � bem tipada;
     *          <code>false</code> caso contrario.
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               ClasseNaoDeclaradaException {
        boolean resposta = false;
        if ( expressao.checaTipo(ambiente) ) {
            if( tipo instanceof TipoStruct) {
                resposta = expressao.getTipo(ambiente).equals(TipoStruct.TIPO_NULL) ||
                           expressao.getTipo(ambiente).equals(tipo);
            }
            else {
                resposta = expressao.getTipo(ambiente).equals(tipo);
            }
        }
        if(resposta) {
            ambiente.map(id, tipo);
        }
        return resposta;
    }

}
