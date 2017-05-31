package li2.plp.li2struct.declaracao.struct;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.declaracao.Declaracao;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.memory.DefStruct;
import li2.plp.li2struct.util.TipoStruct;

public class DecStruct implements Declaracao{

	private Id nomeStruct;
	private ListaDecAtributoStruct listaDecAtributoStruct;
	
	public DecStruct(Id id, ListaDecAtributoStruct listaDecAtributoStruct) {
		this.nomeStruct = id;
		this.listaDecAtributoStruct = listaDecAtributoStruct;
	}

	public AmbienteExecucaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException,
			InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException {
		
		ambiente.mapDefStruct(nomeStruct, new DefStruct(nomeStruct, listaDecAtributoStruct));
		
		return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		boolean resposta = false;
		ambiente.map(nomeStruct, new TipoStruct(nomeStruct, listaDecAtributoStruct.getTipos()));
		ambiente.mapDefStruct(nomeStruct, new DefStruct(nomeStruct, listaDecAtributoStruct));
		if(resposta = listaDecAtributoStruct.checaTipo(ambiente)){
			ambiente.incrementa();
			listaDecAtributoStruct.elabora(ambiente);
			ambiente.restaura();
		}
		return resposta;
	}

	public Id getId() {
		return nomeStruct;
	}

	public void setId(Id id) {
		this.nomeStruct = id;
	}

	public ListaDecAtributoStruct getListaDecAtributoStruct() {
		return listaDecAtributoStruct;
	}

	public void setListaDecAtributoStruct(
			ListaDecAtributoStruct listaDecAtributoStruct) {
		this.listaDecAtributoStruct = listaDecAtributoStruct;
	}

}