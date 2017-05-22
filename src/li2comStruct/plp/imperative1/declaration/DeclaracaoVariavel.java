package li2comStruct.plp.imperative1.declaration;

import li2comStruct.plp.expressions2.expression.Expressao;
import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;

public class DeclaracaoVariavel extends Declaracao {

	private Id id;
	private Expressao expressao;

	public DeclaracaoVariavel(Id id, Expressao expressao) {
		super();
		this.id = id;
		this.expressao = expressao;
	}

	/**
	 * Cria um mapeamento do identificador para o valor da express�o desta
	 * declara��o no AmbienteExecucao
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            valores.
	 * 
	 * @return o ambiente modificado pela inicializa��o da vari�vel.
	 */
	public AmbienteExecucaoImperativa elabora(
			AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException {
		
		ambiente.map(getId(), getExpressao().avaliar(ambiente));
		return ambiente;
	}

	public Expressao getExpressao() {
		return this.expressao;
	}

	public Id getId() {
		return this.id;
	}

	/**
	 * Verifica se a declara��o est� bem tipada, ou seja, se a express�o de
	 * inicializa��o est� bem tipada, e cria o mapeamento da variavel para o seu
	 * tipo correspondente
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            seus tipos.
	 * 
	 * @return <code>true</code> se os tipos da declara��o s�o v�lidos;
	 *         <code>false</code> caso contrario.
	 * 
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException {
		boolean result = false;
		result = getExpressao().checaTipo(ambiente);
		
		if (result) {
			ambiente.map(getId(), getExpressao().getTipo(ambiente));
		}
		return result;
	}
}
