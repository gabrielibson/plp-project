package li2.plp.li2struct.declaracao.struct;

import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.util.Tipo;

public class DefStruct{

	protected Id idStruct;
	protected DeclaracaoChave declaracaoChave;
	protected ListaDecAtributoStruct listaDecAtributoStruct;

	public DefStruct(Id idStruct, DeclaracaoChave declaracaoChave, ListaDecAtributoStruct listaDecAtributoStruct) {

		this.idStruct = idStruct;
		this.declaracaoChave = declaracaoChave;
		this.listaDecAtributoStruct = listaDecAtributoStruct;
		// TODO Auto-generated constructor stub
	}
	
	public Tipo getTipoAtributo(Id idAtt) throws InstanciaStructNaoDeclaradaException{
		return listaDecAtributoStruct.getTipo();
	}

}
