package li2.plp.li2struct.memory;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.command.Comando;
import li2.plp.li2struct.declaracao.struct.DefStruct;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;

public class InstanciaStruct implements Comando{
	
	private Id instanciaStruct;
	
	private ContextoInstancia estado;
	
	public InstanciaStruct(){
		
	}

	public InstanciaStruct(Id instanciaStruct, ContextoInstancia estado) {
		this.instanciaStruct = instanciaStruct;
		this.estado = estado;
	}
	
	public Id getIdInstancia(){
		return instanciaStruct;
	}
	
	public ContextoInstancia getEstado(){
		return estado;
	}
	
	 public void setEstado(ContextoInstancia novoEstado) {
         this.estado = novoEstado;
    }
	 
	 /**
		 * muda o valor de um atributo da instancia struct
		 * @param idVariavel
		 * @param valor
		 * @throws VariavelNaoDeclaradaException
		 */
		public void changeAtributo(Id idVariavel, Valor valor) throws VariavelNaoDeclaradaException{
			
			if (this.getEstado().containsKey(idVariavel)) {
	        	this.getEstado().remove(idVariavel);
	        	this.getEstado().put(idVariavel, valor);
	        }
	        else
	        {
	        	throw new VariavelNaoDeclaradaException(idVariavel);
	        }
		}

	@Override
	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException, EntradaInvalidaException {
		
		DefStruct defStruct = ambiente.getDefStruct(instanciaStruct);
		
		
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}
}
