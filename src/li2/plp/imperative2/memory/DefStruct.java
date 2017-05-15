package li2.plp.imperative2.memory;

import li2.plp.expressions2.declaration.DecVariavel;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.declaration.DeclaracaoProcedimento;
import li2.plp.imperative2.expressao.leftExpression.Id;
import li2.plp.imperative2.util.Tipo;

/**
 * Uma defini�ao de classe � uma declara�ao de vari�vel e uma declara��o de
 * procedimento. Ambos podem ser simples ou compostos.
 */
public class DefStruct {

	/**
	 * Declara��o de vari�vel
	 */
	protected DecVariavel decVariavel;
	/**
	 * Declara�ao do Procedimento
	 */
	protected DeclaracaoProcedimento decProcedimento;

	/**
	 * Declaracao de id
	 */
	protected Id idStruct;

	public DefStruct(Id idStruct, DecVariavel decVariavel, DeclaracaoProcedimento decProcedimento) {
		this.idStruct = idStruct;
		this.decVariavel = decVariavel;
		this.decProcedimento = decProcedimento;
	}

	/**
	 * Obt�m as declara�oes das vari�veis.
	 * 
	 * @return as declara�oes das vari�veis.
	 */
	public DecVariavel getDecVariavel() {
		return decVariavel;
	}

	
	/**
	 * O m�todo abaixo deve verificar se existe algum atributo, identificado por
	 * idAtributo na definicao da classe
	 * 
	 * @param idAtributo
	 *            Um identificador de atributo.
	 * @param Tipo
	 *            O tipo do atributo do identificador.
	 */
	public Tipo getTipoAtributo(Id idAtributo)
			throws VariavelNaoDeclaradaException {
		return decVariavel.getTipo(idAtributo);
	}

	public Id getIdStruct() {
		return idStruct;
	}
}