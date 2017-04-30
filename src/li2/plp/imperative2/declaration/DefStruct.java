package li2.plp.imperative2.declaration;

import li2.plp.expressions1.util.Tipo;
import li2.plp.imperative2.util.TipoStruct;

/**
 * Uma defini�ao de procedimento � uma declara�ao de comando e parametrosFormais
 * uma declara��o de procedimento.
 */
public class DefStruct {

	/**
	 * Declara��o dos parametrosFormais
	 */
	private ListaDeclaracaoVariavel variaveisFormais;

	/**
	 * Construtor
	 * 
	 * @param variaveisFormais
	 *            Declara��o de ListaDeclaracaoVariavel
	 */
	public DefStruct(ListaDeclaracaoVariavel variaveisFormais) {
		this.variaveisFormais = variaveisFormais;
	}

	/**
	 * Obt�m as variaveisFormais da Struct.
	 * 
	 * @return a ListaDeclaracaoVariavel
	 */
	public ListaDeclaracaoVariavel getVariaveisFormais() {
		return variaveisFormais;
	}
	
	public Tipo getTipo() {
		return new TipoStruct();
	}
}
