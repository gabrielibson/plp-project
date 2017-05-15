package li2.plp.imperative2.memory;

import java.util.HashMap;

import li2.plp.expressions2.expression.Id;
import li2.plp.imperative2.expressao.valor.Valor;


public class ContextoInstanciaStruct{

	private HashMap<Id, Valor> estado;
	
	@SuppressWarnings("unchecked")
	public ContextoInstanciaStruct(HashMap<Id, Valor> hash) {
		this.estado = (HashMap<Id, Valor>)hash.clone();
	}

	public void remove(Id id) {
		this.estado.remove(id);
	}

	public void put(Id id,Valor valor) {
		this.estado.put(id, valor);
	}

	public boolean containsKey(Id idVariavel) {
		return this.estado.containsKey(idVariavel);
	}

	public Valor get(Id id) {
		return this.estado.get(id);
	}

}
