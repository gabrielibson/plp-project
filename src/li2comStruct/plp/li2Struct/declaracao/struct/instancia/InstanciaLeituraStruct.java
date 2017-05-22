package li2comStruct.plp.li2Struct.declaracao.struct.instancia;

import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.memoria.InstanciaStruct;
import li2comStruct.plp.li2Struct.util.Tipo;

public class InstanciaLeituraStruct extends InstanciaStruct{

	private Tipo tipo;
	private Id id;
	private Valor key;
	private Valor file;
	
	public InstanciaLeituraStruct(Tipo tipo, Id id, Valor key, Valor file) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.key = key;
		this.file = file;
	}
}
