package li2.plp.li2struct.expression.leftExpression;


import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class Id extends li2.plp.expressions2.expression.Id implements LeftExpression{

	public Id(String strName) {
        super(strName);
    }

	public Valor avaliar(AmbienteExecucaoli2Struct ambiente) throws VariavelNaoDeclaradaException,
			VariavelJaDeclaradaException, InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		return obterValorDeIdNoAmbiente(ambiente);
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		boolean result = true;
		ambiente.get(this); // verifica se est� no ambiente
		return result;
	}

	public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		return ambiente.get(this);
	}

	public Id getId() {

		return this;
	}
	
	public Valor obterValorDeIdNoAmbiente(AmbienteExecucaoli2Struct ambiente) throws 
	VariavelJaDeclaradaException, VariavelNaoDeclaradaException{	
		return ambiente.get(this);
	}
	

	
}
