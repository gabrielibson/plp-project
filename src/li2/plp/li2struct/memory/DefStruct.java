package li2.plp.li2struct.memory;

import java.util.List;

import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.declaracao.struct.DeclaracaoAtributoStruct;
import li2.plp.li2struct.declaracao.struct.ListaDecAtributoStruct;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.util.Tipo;

public class DefStruct {

	private ListaDecAtributoStruct atributos;
	private Id idStruct;
	
	public DefStruct(Id idStruct, ListaDecAtributoStruct atributos) {
		this.atributos = atributos;
		this.idStruct = idStruct;
	}

	public Tipo getTipoAtributo(Id idAtributo)
			throws VariavelNaoDeclaradaException {
		Tipo tipoAtributo = null;
		@SuppressWarnings("unchecked")
		List<DeclaracaoAtributoStruct> listaAtt = (List<DeclaracaoAtributoStruct>) atributos;
		for(DeclaracaoAtributoStruct decAtt : listaAtt){
			if(decAtt.getId().getIdName().equals(idAtributo.getIdName())){
				tipoAtributo = decAtt.getTipo();
			}
		}
 		return tipoAtributo;
	}
	
	public ListaDecAtributoStruct getListaDecAtributoStruct() {
		return atributos;
	}

	public void setListaDecAtributoStruct(ListaDecAtributoStruct atributos) {
		this.atributos = atributos;
	}

	public Id getIdStruct() {
		return idStruct;
	}

	public void setIdStruct(Id idStruct) {
		this.idStruct = idStruct;
	}
}
