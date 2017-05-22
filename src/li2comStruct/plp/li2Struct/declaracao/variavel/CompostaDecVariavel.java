package li2comStruct.plp.li2Struct.declaracao.variavel;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseJaDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;

/**
 * Declara��o de vari�vel composta.
 */
public class CompostaDecVariavel implements DecVariavel {
	/**
	 * Primeira declara��o de vari�vel.
	 */
	private DecVariavel declaracao1;
	/**
	 * Restante da declara��o de vari�veis.
	 */
	private DecVariavel declaracao2;

	/**
	 * Construtor.
	 * 
	 * @param parametro1
	 *            Primeira declara�ao de vari�vel.
	 * @param parametro2
	 *            Restante da declara��o de vari�veis.
	 */
	public CompostaDecVariavel(DecVariavel declaracao1, DecVariavel declaracao2) {
		this.declaracao1 = declaracao1;
		this.declaracao2 = declaracao2;
	}

	/**
	 * Obt�m o tipo de uma vari�vel nessa declara��o.
	 * 
	 * @param id
	 *            O identificador da vari�vel.
	 * @return o tipo deste identificador nessa declara�ao.
	 * @throws VariavelNaoDeclaradaException
	 *             Quando nao h� nenhuma vari�vel declarada com esse id na
	 *             declara��o.
	 */
	public Tipo getTipo(Id id) throws VariavelNaoDeclaradaException {
		Tipo tipo;
		try {
			tipo = declaracao1.getTipo(id);
		} catch (VariavelNaoDeclaradaException e) {
			tipo = declaracao2.getTipo(id);
		}
		return tipo;

	}

	/**
	 * Cria um mapeamento dos identificadores para os valores das express�es
	 * desta declara��o composta no AmbienteExecucao
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            valores.
	 * @return o ambiente modificado pelas inicializa��es das vari�veis.
	 * @throws ObjetoJaDeclaradoException
	 * @throws ObjetoNaoDeclaradoException
	 * @throws ClasseNaoDeclaradaException
	 * @throws ClasseJaDeclaradaException
	 * @throws VariavelNaoDeclaradaException
	 * @throws VariavelJaDeclaradaException
	 * @throws ProcedimentoNaoDeclaradoException
	 * @throws ProcedimentoJaDeclaradoException
	 */
	public AmbienteExecucaoImperativa2 elabora(AmbienteExecucaoImperativa2 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
			ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException {
		return declaracao2.elabora(declaracao1.elabora(ambiente));
	}

	/**
	 * Verifica se as declara��es est�o bem tipadas, ou seja, se as express�es
	 * de inicializa��o est�o bem tipadas.
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            seus tipos.
	 * @return <code>true</code> se os tipos da declara��o s�o v�lidos;
	 *         <code>false</code> caso contrario.
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ClasseNaoDeclaradaException, ClasseJaDeclaradaException {
		return declaracao1.checaTipo(ambiente)
				&& declaracao2.checaTipo(ambiente);
	}
}
