package li2.plp.imperative2.memory;

import li2.plp.expressions2.expression.Id;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative2.declaration.DefProcedimento;
import li2.plp.imperative2.declaration.DefStruct;

public interface AmbienteExecucaoImperativa2 extends AmbienteExecucaoImperativa {

	public void mapProcedimento(Id idArg, DefProcedimento procedimentoId)
			throws ProcedimentoJaDeclaradoException;

	public DefProcedimento getProcedimento(Id idArg)
			throws ProcedimentoNaoDeclaradoException;
	
	public void mapStruct(Id idArg, DefStruct structId)
			throws StructJaDeclaradaException;

	public DefStruct getStruct(Id idArg)
			throws StructNaoDeclaradaException;
}
