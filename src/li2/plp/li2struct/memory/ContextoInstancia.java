package li2.plp.li2struct.memory;

import java.util.HashMap;

import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;

public class ContextoInstancia {

	
	private HashMap<Id, Valor> estado;
	
	@SuppressWarnings("unchecked")
	public ContextoInstancia(HashMap<Id, Valor> hash) {
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
