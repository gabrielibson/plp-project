package li2comStruct.plp.imperative1.memory;

import li2comStruct.plp.expressions1.util.Tipo;
import li2comStruct.plp.expressions2.memory.AmbienteCompilacao;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;

public interface AmbienteCompilacaoImperativa extends AmbienteCompilacao {

	public Tipo getTipoEntrada() throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
		EntradaVaziaException;

}
