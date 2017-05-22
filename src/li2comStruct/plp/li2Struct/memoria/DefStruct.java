package li2comStruct.plp.li2Struct.memoria;

import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.declaration.Declaracao;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.li2Struct.declaracao.procedimento.DefProcedimento;
import li2comStruct.plp.li2Struct.declaracao.struct.declaracao.DeclaracaoChave;
import li2comStruct.plp.li2Struct.declaracao.struct.declaracao.ListaDecAtributoStruct;
import li2comStruct.plp.li2Struct.declaracao.variavel.DecVariavel;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.util.Tipo;

/**
 * Uma defini�ao de classe � uma declara�ao de vari�vel e uma declara��o de
 * procedimento. Ambos podem ser simples ou compostos.
 */
public class DefStruct extends Declaracao{

	private Id id;
	private DeclaracaoChave chave;
	private ListaDecAtributoStruct listadecattstruct;
	
	public DefStruct(Id id, DeclaracaoChave chave, ListaDecAtributoStruct listadecattstruct) {
		super();
		this.id = id;
		this.chave = chave;
		this.listadecattstruct = listadecattstruct;
	}

	/**
	 * Declara��o de vari�vel
	 */
	protected DecVariavel decVariavel;
	/**
	 * Declara�ao do Procedimento
	 */
	protected DefProcedimento defProcedimento;

	/**
	 * Declaracao de id
	 */
	protected Id idClasse;

	public DefStruct(Id idClasse, DecVariavel decVariavel, DefProcedimento defProcedimento) {
		this.idClasse = idClasse;
		this.decVariavel = decVariavel;
		this.defProcedimento = defProcedimento;
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

	public Id getIdClasse() {
		return idClasse;
	}

	@Override
	public AmbienteExecucaoImperativa elabora(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		// TODO Auto-generated method stub
		return false;
	}
}