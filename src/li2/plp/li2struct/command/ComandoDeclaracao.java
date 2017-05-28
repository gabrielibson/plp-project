package li2.plp.li2struct.command;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.declaracao.Declaracao;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

public class ComandoDeclaracao implements Comando {

	private Declaracao declaracao;

	private Comando comando;

	public ComandoDeclaracao(Declaracao declaracao, Comando comando) {
		this.declaracao = declaracao;
		this.comando = comando;
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
			StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException {
		ambiente.incrementa();
		ambiente = comando.executar(declaracao.elabora(ambiente));
		ambiente.restaura();
		return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws StructJaDeclaradaException, StructNaoDeclaradaException {
		boolean resposta;
		ambiente.incrementa();
		resposta = declaracao.checaTipo(ambiente) && comando.checaTipo(ambiente);
		ambiente.restaura();
		return resposta;
	}

}
