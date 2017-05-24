package li2comStruct.plp.li2Struct.declaracao.procedimento;

import li2comStruct.plp.expressions2.expression.Id;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.util.Tipo;

public class DeclaracaoParametro {

	private Id id;

	private Tipo tipo;

	public DeclaracaoParametro(Id id, Tipo tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Id getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente) throws ClasseNaoDeclaradaException {
		return tipo.eValido(ambiente);
	}

	/**
	 * Cria um mapeamento do identificador para o tipo do parametro desta
	 * declara��o no AmbienteCompilacaoImperativa2
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificador e seu
	 *            tipo.
	 * 
	 * @return o ambiente modificado pela declara��o do parametro.
	 */
	public AmbienteCompilacaoImperativa elabora(
			AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.map(id, (li2comStruct.plp.expressions1.util.Tipo) tipo);
		return ambiente;
	}

}
