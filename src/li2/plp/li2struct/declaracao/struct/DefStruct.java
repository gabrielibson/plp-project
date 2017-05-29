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
import li2.plp.li2struct.util.TipoStruct;


public class DefStruct implements Declaracao{

	private Id nomeStruct;
	private DeclaracaoChave chave;
	private ListaDecAtributoStruct listaDecAtributoStruct;

	public DefStruct(Id id, DeclaracaoChave chave, ListaDecAtributoStruct listaDecAtributoStruct) {
		this.nomeStruct = id;
		this.chave = chave;
		this.listaDecAtributoStruct = listaDecAtributoStruct;
	}

	@Override
	public AmbienteExecucaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException,
			InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException {

			ambiente.mapDefStruct(nomeStruct, new DefStruct(nomeStruct, chave, listaDecAtributoStruct));


		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {

		// TODO Auto-generated method stub
		ambiente.mapDefStruct(nomeStruct, new DefStruct(nomeStruct, chave, listaDecAtributoStruct));
		boolean resposta = false;
		ambiente.incrementa();
		if(listaDecAtributoStruct.checaTipo(ambiente)){
			ambiente.map(new Id("this"), new TipoStruct(nomeStruct));
			resposta = listaDecAtributoStruct.checaTipo(ambiente);
		}
		ambiente.restaura();
		return resposta;

	/*	ambiente.mapDefStruct(nomeStruct, new DefStruct(nomeStruct, chave, listaDecAtributoStruct));

		return listaDecAtributoStruct.checaTipo(ambiente);
		boolean resposta = false;
		ambiente.incrementa();
		if(resposta = listaDecAtributoStruct.checaTipo(ambiente)){
			ambiente.map(new Id("this"), new TipoStruct(nomeStruct));
		}
		ambiente.restaura();
		return resposta;*/
	}

	public Id getId() {
		return nomeStruct;
	}

	public void setId(Id id) {
		this.nomeStruct = id;
	}

	public DeclaracaoChave getChave() {
		return chave;
	}

	public void setChave(DeclaracaoChave chave) {
		this.chave = chave;
	}

	public ListaDecAtributoStruct getListaDecAtributoStruct() {
		return listaDecAtributoStruct;
	}

	public void setListaDecAtributoStruct(
			ListaDecAtributoStruct listaDecAtributoStruct) {
		this.listaDecAtributoStruct = listaDecAtributoStruct;
	}

}