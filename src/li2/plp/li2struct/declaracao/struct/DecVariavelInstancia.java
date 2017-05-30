package li2.plp.li2struct.declaracao.struct;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.command.ListaExpressao;
import li2.plp.li2struct.declaracao.Declaracao;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class DecVariavelInstancia implements Declaracao {
	
	private Id id; // identificador da variavel struct
	private Tipo tipo; //struct
	private ListaExpressao listaExp; //valores passados na instancia

	public DecVariavelInstancia(Id id, Tipo tipo, ListaExpressao listaExp) {
		this.id = id;
		this.tipo = tipo;
		this.listaExp = listaExp;
	}
	
	
	/**
	 * Retorna o tipo do identificador a ser declarado no AmbienteCompilacao
	 * 
	 * @param id
	 *            o identificador da declaracao
	 * @return o tipo do identificador
	 */
	public Tipo getTipo(Id id) throws VariavelNaoDeclaradaException {
		if (this.id.equals(id)) {
			return tipo;
		} else {
			throw new VariavelNaoDeclaradaException(id);
		}
	}

	public AmbienteExecucaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException, InstanciaStructNaoDeclaradaException,
			InstanciaStructJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException {
		boolean resposta = false;
		if(tipo.eValido(ambiente)){
			ambiente.map(id, tipo);
			resposta = true;
		}
		return resposta;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public ListaExpressao getListaExp() {
		return listaExp;
	}


	public void setListaExp(ListaExpressao listaExp) {
		this.listaExp = listaExp;
	}



}
