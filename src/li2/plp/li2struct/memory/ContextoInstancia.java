package li2.plp.li2struct.memory;

import java.util.HashMap;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.util.Tipo;

public class ContextoInstancia implements Valor{

	
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

	public Valor avaliar(AmbienteExecucaoli2Struct ambiente) throws VariavelNaoDeclaradaException,
			VariavelJaDeclaradaException, InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}

	public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente) {
		// TODO Auto-generated method stub
		return null;
	}

}
