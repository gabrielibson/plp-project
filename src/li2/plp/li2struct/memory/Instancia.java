package li2.plp.li2struct.memory;

import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;

public class Instancia {

	private Id instanciaStruct;
	private ContextoInstancia estado;
	
	public Instancia(Id instanciaStruct, ContextoInstancia estado) {
		this.instanciaStruct = instanciaStruct;
		this.estado = estado;
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
	
	public ContextoInstancia getEstado(){
		return estado;
	}
	
	public void setEstado(ContextoInstancia novoEstado) {
         this.estado = novoEstado;
    }

	public Id getInstanciaStruct() {
		return instanciaStruct;
	}

	public void setInstanciaStruct(Id instanciaStruct) {
		this.instanciaStruct = instanciaStruct;
	}
}
