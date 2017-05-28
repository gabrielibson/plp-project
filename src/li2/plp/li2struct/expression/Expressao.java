package li2.plp.li2struct.expression;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public interface Expressao{

	Valor avaliar(AmbienteExecucaoli2Struct ambiente)
	        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
	               InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException;
	
	boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
	        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException;
	
	public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente)
	        throws VariavelNaoDeclaradaException, StructNaoDeclaradaException;
	
}
