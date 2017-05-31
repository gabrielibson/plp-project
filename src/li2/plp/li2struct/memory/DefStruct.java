package li2.plp.li2struct.memory;

import java.util.ArrayList;
import java.util.List;

import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.util.Lista;
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
		List<DeclaracaoAtributoStruct> listaAtt = this.getListDecAtributoStruct();
		for(DeclaracaoAtributoStruct decAtt : listaAtt){
			if(decAtt.getId().getIdName().equals(idAtributo.getIdName())){
				tipoAtributo = decAtt.getTipo();
				break;
			}
		}
 		return tipoAtributo;
	}
	
	private List<DeclaracaoAtributoStruct> getListDecAtributoStruct(){
		ArrayList<DeclaracaoAtributoStruct> retorno = new ArrayList<DeclaracaoAtributoStruct>();

		DeclaracaoAtributoStruct headTemp = this.atributos.getHead();
		Lista<DeclaracaoAtributoStruct> tailTemp = this.atributos.getTail();

		while (headTemp != null) {
			retorno.add(headTemp);
			
			if (tailTemp != null) {
				headTemp = tailTemp.getHead();
				tailTemp = tailTemp.getTail();
			} else {
				headTemp = null;
			}
		}

		return retorno;
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
