package li2comStruct.plp.li2Struct.comando;

import java.util.LinkedList;
import java.util.List;

import li2comStruct.plp.expressions1.util.Tipo;
import li2comStruct.plp.expressions2.expression.Expressao;
import li2comStruct.plp.expressions2.memory.AmbienteExecucao;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.util.Lista;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.memoria.colecao.ListaValor;

/**
 * Classe que representa uma tail de express�es.
 */
public class ListaExpressao extends Lista<Expressao> {
	/**
	 * Construtor.
	 */
	public ListaExpressao() {

	}

	/**
	 * Construtor.
	 * 
	 * @param expressao
	 *            Express�o que compoe a tail.
	 */
	public ListaExpressao(Expressao expressao) {
		super(expressao, new ListaExpressao());
	}

	/**
	 * Construtor.
	 * 
	 * @param expressao
	 *            Primeira express�o da tail.
	 * @param listaExpressao
	 *            Restante da tail de expressoes.
	 */
	public ListaExpressao(Expressao expressao, ListaExpressao listaExpressao) {
		super(expressao, listaExpressao);
	}

	/**
	 * Avalia a tail de express�es.
	 * 
	 * @param ambiente
	 *            O ambiente de execu�ao, contendo o mapeamento entre
	 *            identificadores e valores.
	 * @return a tail de valores resultantes da avalia�ao dessa tail de
	 *         expressoes.
	 * @throws VariavelNaoDeclaradaException
	 *             Quando alguma das vari�veis presentes na tail nao foi
	 *             declarada.
	 * @throws VariavelJaDeclaradaException
	 *             Quando alguma das vari�veis referenciada na tail est� sendo
	 *             declarada novamente num mesmo escopo.
	 * @throws ObjetoNaoDeclaradoException
	 *             Quando um objeto que est� sendo referenciado nao foi
	 *             declarado.
	 * @throws ClasseNaoDeclaradaException 
	 */
	public ListaValor avaliar(AmbienteExecucao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
		if (length() >= 2) {
			return new ListaValor((Valor) getHead().avaliar(ambiente),
					((ListaExpressao) getTail()).avaliar(ambiente));
		} else if (length() == 1) {
			return new ListaValor((Valor) getHead().avaliar(ambiente));
		} else {
			return new ListaValor();
		}
	}

	/**
	 * Obt�m a tail dos tipos dos elementos da tail de expressoes.
	 * 
	 * @param ambiente
	 *            o ambiente de compila�ao, contendo o mapeamento entre
	 *            identificadores e tipos.
	 * @return a tail dos tipos dos elementos da tail de expressoes.
	 * @throws VariavelNaoDeclaradaException
	 *             Quando uma vari�vel sendo referenciada nao foi declarada.
	 * @throws VariavelJaDeclaradaException
	 *             Quando uma vari�vel est� sendo declarada mais de uma vez num
	 *             mesmo escopo.
	 * @throws ClasseNaoDeclaradaException
	 *             Quando uma determinada classe que est� sendo usada nao foi
	 *             declarada.
	 */
	public List<Tipo> getTipos(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ClasseNaoDeclaradaException {
		List<Tipo> result = new LinkedList<Tipo>();

		if (this.length() >= 2) {
			result.add(getHead().getTipo(ambiente));
			result.addAll(((ListaExpressao) getTail()).getTipos(ambiente));
		} else if (length() == 1) {
			result.add(getHead().getTipo(ambiente));
		}
		return result;
	}
}
