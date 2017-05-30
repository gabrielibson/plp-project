package li2.plp.li2struct.expression.leftExpression;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.memory.ContextoInstancia;
import li2.plp.li2struct.memory.DefStruct;
import li2.plp.li2struct.memory.Instancia;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoStruct;

public class AcessoAtributoId extends AcessoAtributo{

	protected LeftExpression av;
	
	public AcessoAtributoId(LeftExpression av, Id id){
        super(id);
        this.av = av;
    }

	@Override
	public Expressao getExpressaoInstancia() {
		return av;
	}

	public Valor avaliar(AmbienteExecucaoli2Struct ambiente) throws VariavelNaoDeclaradaException,
			VariavelJaDeclaradaException, InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		 return obterValorDeIdNoAmbiente(ambiente);
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		 boolean resposta = false;
	        if(av.checaTipo(ambiente)) {
	            try{
	                Tipo t = av.getTipo(ambiente);
	                ambiente.getDefStruct(((TipoStruct)t).getTipo());
	                resposta = true;
	            }
	            catch(VariavelNaoDeclaradaException atrib){
	                resposta = false;
	            }
	            catch(StructNaoDeclaradaException clas){
	                resposta = false;
	            }

	        }
	        return resposta;
	}

	public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		Id nomeStruct = ((TipoStruct)av.getTipo(ambiente)).getTipo();
        DefStruct decStruct = ambiente.getDefStruct(nomeStruct);
        Tipo tipoAtr = decStruct.getTipoAtributo(nomeStruct);
		return tipoAtr;
	}
	
	 /**
     * Retorna o valor do Objeto representado por um certo id
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor do Objeto representado por um certo id
     * @throws ClasseNaoDeclaradaException 
     */
    private Valor obterValorDeIdNoAmbiente(AmbienteExecucaoli2Struct ambiente)
            throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException{
        
    	// Pegando o objeto no ambiente
        ValorRef referencia = (ValorRef) av.avaliar(ambiente);
        Instancia instancia = ambiente.getInstancia(referencia);
        
        // Recuperando o mapeamento de valores do objeto (atributos do objeto)
        ContextoInstancia aux = instancia.getEstado();
        
        // Recuperando o valor do atributo "id" do objeto
        return aux.get(super.getId());
    }
}
