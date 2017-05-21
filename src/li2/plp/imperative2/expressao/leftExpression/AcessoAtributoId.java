package li2.plp.imperative2.expressao.leftExpression;

import li2.plp.expressions2.expression.valor.ValorRef;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.exception.InstanciaStructNaoDeclaradoException;
import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.expressao.Expressao;
import li2.plp.imperative2.expressao.valor.Valor;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.imperative2.memory.ContextoInstanciaStruct;
import li2.plp.imperative2.memory.DefStruct;
import li2.plp.imperative2.memory.InstanciaStruct;
import li2.plp.imperative2.util.Tipo;
import li2.plp.imperative2.util.TipoStruct;

/**
 * Classe que representa um acesso de atributo a partir de uma expressao.
 */
public class AcessoAtributoId extends AcessoAtributo{
    /**
     * Expressao que acessa o atributo.
     */
    protected LeftExpression av;
    /**
     * Construtor.
     * @param av Expressao do lado esquerdo, que acessa o atributo.
     * @param id O atributo sendo acessado.
     */
    public AcessoAtributoId(LeftExpression av, Id id){
        super(id);
        this.av = av;
    }
    /**
     * Avalia esse acesso de atributo obtendo o valor do atributo no ambiente.
     * @param ambiente o ambiente de execu��o, que apresenta o mapeamento de
     * identificadores a valores.
     * @return o valor do atributo acessado no ambiente.
     * @throws VariavelNaoDeclaradaException
     * @throws VariavelJaDeclaradaException
     * @throws InstanciaStructNaoDeclaradoException
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException{
        return obterValorDeIdNoAmbiente(ambiente);
    }
    /**
     * Obt�m a express�o acessadora do atributo.
     * @return a express�o acessadora do atributo.
     */
    public Expressao getExpressaoObjeto(){
        return av;
    }
    /**
     * Verifica se os atributos associados foram declarados e se seus tipos
     * existem no ambiente.
     * @param ambiente o ambiente de compila��o, com o mapeamento de identificadores
     * a tipos.
     * @return true, se as vari�veis acessadas j� foram declaradas e seus
     * tipos existem.
     * @throws VariavelNaoDeclaradaException
     * @throws StructNaoDeclaradaException
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException{
        boolean resposta = false;
        if(av.checaTipo(ambiente)) {
            try{
                Tipo t = av.getTipo(ambiente);
                DefStruct defStruct = ambiente.getDefStruct(((TipoStruct)t).getTipo());
                defStruct.getTipoAtributo(super.getId());
                resposta = true;
            }
            catch(VariavelNaoDeclaradaException atrib){
                resposta = false;
            }
            catch(StructNaoDeclaradaException struct){
                resposta = false;
            }

        }
        return resposta;
    }
    /**
     * Obt�m o tipo do atributo no ambiente.
     * @param ambiente que apresenta o mapeamento de identificadores a tipos.
     * @return o tipo do atributo acessado.
     * @throws VariavelNaoDeclaradaException
     * @throws StructNaoDeclaradaException
     */
    public Tipo getTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException{
          //Logo abaixo obtenho a definicao da Classe (seus m�todos e atributos).
          //av.getTipo devera retornar uma instancia de TipoClasse e assim, TipoClasse.getTipo()
          //retorna o id (contendo o nome da classe) associado ao tipo dela
        Id nomeStruct = ((TipoStruct)av.getTipo(ambiente)).getTipo();
        DefStruct defClasse = ambiente.getDefStruct(nomeStruct);
        Tipo tipoAtr = defClasse.getTipoAtributo(super.getId());
        //Em seguida retorno o tipo do atributo, caso ele esteja definido na classe.
        //caso n�o esteja, uma exce��o ser� lan�ada
        return tipoAtr;
    }
    /**
     * Obt�m a expressao que acessa o atributo.
     * @return a LeftExpression que representa a express�o que acessa o atributo.
     */
    public LeftExpression getAv() {
        return av;
    }

    /**
     * Retorna o valor do Objeto representado por um certo id
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor do Objeto representado por um certo id
     * @throws StructNaoDeclaradaException 
     */
    private Valor obterValorDeIdNoAmbiente(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               InstanciaStructNaoDeclaradoException, StructNaoDeclaradaException {
        
    	// Pegando o objeto no ambiente
        ValorRef referencia = (ValorRef) av.avaliar(ambiente);
        InstanciaStruct instancia = ambiente.getInstanciaStruct(referencia);
        
        // Recuperando o mapeamento de valores do objeto (atributos do objeto)
        ContextoInstanciaStruct aux = instancia.getEstado();
        
        // Recuperando o valor do atributo "id" do objeto
        return aux.get(super.getId());
    }
}