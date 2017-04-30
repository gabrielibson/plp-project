package li2.plp.imperative2.declaration;

import java.util.LinkedList;
import java.util.List;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.declaration.DeclaracaoVariavel;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.util.Lista;

public class ListaDeclaracaoVariavel extends Lista<DeclaracaoVariavel> {

	public ListaDeclaracaoVariavel() {

	}

	public ListaDeclaracaoVariavel(DeclaracaoVariavel decVar) {
		super(decVar, new ListaDeclaracaoVariavel());
	}

	public ListaDeclaracaoVariavel(DeclaracaoVariavel decVar, ListaDeclaracaoVariavel listaDeclaracaoVariavel) {
		super(decVar, listaDeclaracaoVariavel);
	}

	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException {
		boolean resposta;
		if (getHead() != null) {
			if (getTail() != null) {
				resposta = getHead().checaTipo(ambiente)
						&& ((ListaDeclaracaoVariavel) getTail())
								.checaTipo(ambiente);
			} else {
				resposta = getHead().checaTipo(ambiente);
			}
		} else {
			resposta = true;
		}
		return resposta;
	}
	
	public AmbienteCompilacaoImperativa elabora(
			AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		AmbienteCompilacaoImperativa resposta;
		if (getHead() != null) {
			if (getTail() != null) {
				resposta = ((ListaDeclaracaoVariavel) getTail())
						.elabora(getHead().elabora(ambiente));
			} else {
				resposta = getHead().elabora(ambiente);
			}
		} else {
			resposta = ambiente;
		}
		return resposta;
	}
	
	public List<Tipo> getTipos(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		List<Tipo> result = new LinkedList<Tipo>();

		if (this.length() >= 2) {
			result.add(getHead().getExpressao().getTipo(ambiente));
			result.addAll(((ListaDeclaracaoVariavel) getTail()).getTipos(ambiente));
		} else if (length() == 1) {
			result.add(getHead().getExpressao().getTipo(ambiente));
		}
		return result;
	}

}
