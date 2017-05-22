package li2comStruct.plp.imperative1.memory;

import li2comStruct.plp.expressions2.expression.Id;
import li2comStruct.plp.expressions2.expression.Valor;
import li2comStruct.plp.expressions2.memory.AmbienteExecucao;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;

public interface AmbienteExecucaoImperativa extends AmbienteExecucao {

	public void changeValor(Id idArg, Valor valorId)
			throws VariavelNaoDeclaradaException;

	public Valor read() throws EntradaVaziaException;

	public AmbienteExecucaoImperativa2 write(Valor v);

	public ListaValor getSaida();
}
