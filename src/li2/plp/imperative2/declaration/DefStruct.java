package li2.plp.imperative2.declaration;

import li2.plp.expressions1.util.Tipo;
import li2.plp.imperative2.util.TipoStruct;

/**
 * Uma definiï¿½ao de procedimento ï¿½ uma declaraï¿½ao de comando e parametrosFormais
 * uma declaraï¿½ï¿½o de procedimento.
 */
public class DefStruct {

	/**
	 * Declaraï¿½ï¿½o dos parametrosFormais
	 */
	private ListaDeclaracaoVariavel variaveisFormais;

	/**
	 * Construtor
	 * 
	 * @param variaveisFormais
	 *            Declaração de ListaDeclaracaoVariavel
	 */
	public DefStruct(ListaDeclaracaoVariavel variaveisFormais) {
		this.variaveisFormais = variaveisFormais;
	}

	/**
	 * Obtém as variaveisFormais da Struct.
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
