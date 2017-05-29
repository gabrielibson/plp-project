package li2.plp.li2struct.declaracao.struct;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.command.ListaExpressao;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.InstanciaStruct;
import li2.plp.li2struct.util.Tipo;

public class InstanciaValoresStruct extends InstanciaStruct{
	
	private Tipo struct;
	private Id variavelStruct;
	private ListaExpressao valoresStruct;



	public InstanciaValoresStruct(Tipo struct, Id variavelStruct,
			ListaExpressao valoresStruct) {
		this.struct = struct;
		this.variavelStruct = variavelStruct;
		this.valoresStruct = valoresStruct;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}
}
