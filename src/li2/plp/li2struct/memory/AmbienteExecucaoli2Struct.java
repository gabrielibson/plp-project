package li2.plp.li2struct.memory;

import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;


public interface AmbienteExecucaoli2Struct extends AmbienteExecucaoImperativa2{

	public void changeValor(Id idArg, Valor valorId) throws VariavelNaoDeclaradaException;
}
