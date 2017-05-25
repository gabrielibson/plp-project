package li2.plp.li2struct.expression.leftExpression;

import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class AcessoAtributo implements LeftExpression{

	private Id id;
	
	public AcessoAtributo(Id id) {
        this.id = id;
    }

	public Id getId(){
		return id;
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

	public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

}
