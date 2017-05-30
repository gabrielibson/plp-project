package li2.plp.li2struct.declaracao.struct;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.command.InstanciaStruct;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.leftExpression.LeftExpression;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

public class InstanciaLeituraStruct implements InstanciaStruct{
	
	private Valor key;
	private Valor file;
	private LeftExpression av;
	private Id nomeStruct;


	public InstanciaLeituraStruct(LeftExpression av, Id nomeStruct, Valor key, Valor file) {
		this.av = av;
		this.nomeStruct = nomeStruct;
		this.key = key;
		this.file = file;
	}
	
	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
			StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Valor getKey() {
		return key;
	}

	public void setKey(Valor key) {
		this.key = key;
	}

	public Valor getFile() {
		return file;
	}

	public void setFile(Valor file) {
		this.file = file;
	}

	public LeftExpression getAv() {
		return av;
	}

	public void setAv(LeftExpression av) {
		this.av = av;
	}

	public Id getNomeStruct() {
		return nomeStruct;
	}

	public void setNomeStruct(Id nomeStruct) {
		this.nomeStruct = nomeStruct;
	}


}
