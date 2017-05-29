package li2.plp.li2struct.declaracao.procedimento;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.util.Tipo;

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

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente) 
			throws StructNaoDeclaradaException {
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
	public AmbienteCompilacaoli2Struct elabora(
			AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.map(id, tipo);
		return ambiente;
	}

}
