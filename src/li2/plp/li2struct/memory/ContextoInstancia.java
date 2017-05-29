package li2.plp.li2struct.memory;

import java.util.HashMap;

import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.util.TipoStruct;

public class ContextoInstancia {

	
	private HashMap<TipoStruct, Valor> estado;
	
	@SuppressWarnings("unchecked")
	public ContextoInstancia(HashMap<TipoStruct, Valor> hash) {
		this.estado = (HashMap<TipoStruct, Valor>)hash.clone();
	}
	
	public void remove(TipoStruct id) {
		this.estado.remove(id);
	}

	public void put(TipoStruct id,Valor valor) {
		this.estado.put(id, valor);
	}

	public boolean containsKey(TipoStruct idVariavel) {
		return this.estado.containsKey(idVariavel);
	}

	public Valor get(TipoStruct id) {
		return this.estado.get(id);
	}

}
