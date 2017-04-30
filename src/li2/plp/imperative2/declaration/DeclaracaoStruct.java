package li2.plp.imperative2.declaration;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.declaration.Declaracao;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;

public class DeclaracaoStruct extends Declaracao {

	private Id id;
	private DefStruct defStruct;

	public DeclaracaoStruct(Id id, DefStruct defStruct) {
		super();
		this.id = id;
		this.defStruct = defStruct;
	}

	@Override
	public AmbienteExecucaoImperativa elabora(
			AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException {
		((AmbienteExecucaoImperativa2) ambiente).mapStruct(getId(),
				getDefStruct());
		return ambiente;
	}

	private Id getId() {
		return this.id;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException {
		boolean resposta;

		ambiente.map(id, defStruct.getTipo());

		ListaDeclaracaoVariavel variaveisFormais = getDefStruct()
				.getVariaveisFormais();
		if (variaveisFormais.checaTipo(ambiente)) {
			ambiente.incrementa();
			ambiente = variaveisFormais.elabora(ambiente);
			resposta = variaveisFormais.checaTipo(ambiente);
			ambiente.restaura();
		} else {
			resposta = false;
		}
		return resposta;
	}

	private DefStruct getDefStruct() {
		return this.defStruct;
	}
}
