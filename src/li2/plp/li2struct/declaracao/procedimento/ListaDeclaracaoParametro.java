package li2.plp.li2struct.declaracao.procedimento;

import java.util.ArrayList;
import java.util.List;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.util.Lista;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class ListaDeclaracaoParametro extends Lista<DeclaracaoParametro> {

	public ListaDeclaracaoParametro() {
	}

	public ListaDeclaracaoParametro(DeclaracaoParametro declaracao) {
		super(declaracao, null);
	}

	public ListaDeclaracaoParametro(DeclaracaoParametro declaracao,
			ListaDeclaracaoParametro listaDeclaracao) {
		super(declaracao, listaDeclaracao);
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		boolean resposta;
		if (getHead() != null) {
			if (getTail() != null) {
				resposta = getHead().checaTipo(ambiente)
						&& ((ListaDeclaracaoParametro) getTail())
								.checaTipo(ambiente);
			} else {
				resposta = getHead().checaTipo(ambiente);
			}
		} else {
			resposta = true;
		}
		return resposta;
	}

	/**
	 * Cria um mapeamento do identificador para o tipo do parametro desta
	 * declara��o no AmbienteCompilacaoImperativa2
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificador e seu
	 *            tipo.
	 * @return o ambiente modificado pela declara��o do parametro.
	 */
	public AmbienteCompilacaoli2Struct elabora(
			AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		AmbienteCompilacaoli2Struct resposta;
		if (getHead() != null) {
			if (getTail() != null) {
				resposta = ((ListaDeclaracaoParametro) getTail())
						.elabora(getHead().elabora(ambiente));
			} else {
				resposta = getHead().elabora(ambiente);
			}
		} else {
			resposta = ambiente;
		}
		return resposta;
	}

	public List<Tipo> getTipos() {
		ArrayList<Tipo> retorno = new ArrayList<Tipo>();

		DeclaracaoParametro headTemp = this.head;
		Lista<DeclaracaoParametro> tailTemp = this.tail;

		while (headTemp != null) {
			//retorno.add(head.getTipo());
			retorno.add((Tipo) headTemp.getTipo());
			
			if (tailTemp != null) {
				headTemp = tailTemp.getHead();
				tailTemp = tailTemp.getTail();
			} else {
				headTemp = null;
			}
		}

		return retorno;
	}

}
