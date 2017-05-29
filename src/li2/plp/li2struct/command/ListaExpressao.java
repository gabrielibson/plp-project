package li2.plp.li2struct.command;

import java.util.LinkedList;
import java.util.List;

import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.ListaValor;
import li2.plp.imperative1.util.Lista;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class ListaExpressao extends Lista<Expressao> {

	public ListaExpressao() {

	}

	public ListaExpressao(Expressao expressao) {
		super(expressao, new ListaExpressao());
	}

	public ListaExpressao(Expressao expressao, ListaExpressao listaExpressao) {
		super(expressao, listaExpressao);
	}

	public ListaValor avaliar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, 
			InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		if (length() >= 2)
			return new ListaValor((Valor) getHead().avaliar(ambiente),
					((ListaExpressao) getTail()).avaliar(ambiente));
		else if (length() == 1)
			return new ListaValor((Valor) getHead().avaliar(ambiente));
		else
			return new ListaValor();
	}

	public List<Tipo> getTipos(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			StructNaoDeclaradaException {
		List<Tipo> result = new LinkedList<Tipo>();

		if (this.length() >= 2) {
			result.add(getHead().getTipo(ambiente));
			result.addAll(((ListaExpressao) getTail()).getTipos(ambiente));
		} else if (length() == 1) {
			result.add(getHead().getTipo(ambiente));
		}
		return result;
/*		ListaTipo resposta;
		if (length() >= 2) {
			resposta = new ListaTipo(getHead().getTipo(ambiente),
					((ListaExpressao) getTail()).getTipos(ambiente));
		} else if (length() == 1) {
			resposta = new ListaTipo(getHead().getTipo(ambiente));
		} else {
			resposta = new ListaTipo();
		}
		return resposta;*/
	}

}
