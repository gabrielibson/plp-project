package li2comStruct.plp.expressions2.memory;

import li2comStruct.plp.expressions2.expression.Valor;


public interface AmbienteExecucao extends Ambiente<Valor> {

	public AmbienteExecucao clone();

}
