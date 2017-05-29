package li2.plp.li2struct.declaracao.struct;

import li2.plp.li2struct.command.ListaExpressao;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.InstanciaStruct;
import li2.plp.li2struct.util.Tipo;

public class InstanciaValoresStruct extends InstanciaStruct{
	
	private Tipo struct;
	private Id variavelStruct;
	private ListaExpressao valoresStruct;

	public InstanciaValoresStruct(Tipo struct, Id variavelStruct,
			ListaExpressao valoresStruct) {
		this.struct = struct;
		this.variavelStruct = variavelStruct;
		this.valoresStruct = valoresStruct;
	}

	

}
