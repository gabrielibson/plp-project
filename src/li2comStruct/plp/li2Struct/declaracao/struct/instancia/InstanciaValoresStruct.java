package li2comStruct.plp.li2Struct.declaracao.struct.instancia;

import li2comStruct.plp.li2Struct.comando.ListaExpressao;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.memoria.InstanciaStruct;
import li2comStruct.plp.li2Struct.util.Tipo;

public class InstanciaValoresStruct extends InstanciaStruct{

	private Tipo tipo;
	private Id id;
	private ListaExpressao listaexp;
	 
	public InstanciaValoresStruct(Tipo tipo, Id id, ListaExpressao listaexp) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.listaexp = listaexp;
	}
}
