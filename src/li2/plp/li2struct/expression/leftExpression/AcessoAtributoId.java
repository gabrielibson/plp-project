package li2.plp.li2struct.expression.leftExpression;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class AcessoAtributoId extends AcessoAtributo{

	protected LeftExpression av;
	
	public AcessoAtributoId(LeftExpression av, Id id){
        super(id);
        this.av = av;
    }

	@Override
	public Expressao getExpressaoObjeto() {
		return av;
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
