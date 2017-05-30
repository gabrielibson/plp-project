package li2.plp.li2struct.declaracao.struct;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.command.InstanciaStruct;
import li2.plp.li2struct.command.ListaExpressao;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.leftExpression.LeftExpression;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.memory.ContextoInstancia;
import li2.plp.li2struct.memory.Instancia;
import li2.plp.li2struct.memory.ListaValor;
import li2.plp.li2struct.util.TipoPrimitivo;
import li2.plp.li2struct.util.TipoStruct;

public class InstanciaValoresStruct implements InstanciaStruct{
	
	private ListaExpressao listaExp;
	private LeftExpression av;
	private Id nomeStruct;


	public InstanciaValoresStruct(LeftExpression av, Id nomeStruct, ListaExpressao listaExp) {
		this.av = av;
		this.nomeStruct = nomeStruct;
		this.listaExp = listaExp;
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
			StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException {
		
		DecStruct struct = ambiente.getDefStruct(nomeStruct);
		
		ambiente.incrementa();
		ListaDecAtributoStruct parametrosFormais = struct.getListaDecAtributoStruct();
		AmbienteExecucaoli2Struct aux = this.bindParameters(ambiente, parametrosFormais);
		
		ContextoInstancia estadoInstancia = new ContextoInstancia(aux.getPilha().pop());
		Instancia instancia = new Instancia(nomeStruct, estadoInstancia);
		
		ValorRef vr = aux.getProxRef();
		aux.mapInstancia(vr, instancia);

		return aux;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		TipoStruct tipoStruct = (TipoStruct) ambiente.get(nomeStruct);
		TipoStruct tipoParametrosReais = null;
		if(TipoPrimitivo.TIPO_INTEIRO == this.listaExp.getTipos(ambiente).get(0)){
			tipoParametrosReais = new TipoStruct(this.listaExp.getTipos(ambiente));
			return tipoStruct.eIgual(tipoParametrosReais);
		}else{
			try {
				throw new EntradaInvalidaException("Tipo da chave da struct precisa ser INT");
			} catch (EntradaInvalidaException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}		
	}
	
	
	/**
	 * insere no contexto o resultado da associacao entre cada parametro formal
	 * e seu correspondente parametro atual
	 * @throws StructNaoDeclaradaException 
	 * @throws InstanciaStructNaoDeclaradaException 
	 */
	private AmbienteExecucaoli2Struct bindParameters(
			AmbienteExecucaoli2Struct ambiente,
			ListaDecAtributoStruct parametrosFormais)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		ListaValor listaValor = listaExp.avaliar(ambiente);
		while (listaValor.length() > 0) {
			ambiente.map(parametrosFormais.getHead().getId(), (Valor) listaValor
					.getHead());
			parametrosFormais = (ListaDecAtributoStruct) parametrosFormais
					.getTail();
			listaValor = (ListaValor) listaValor.getTail();
		}
		return ambiente;
	}

	
	public ListaExpressao getValoresStruct() {
		return listaExp;
	}


	public void setValoresStruct(ListaExpressao valoresStruct) {
		this.listaExp = valoresStruct;
	}

	public ListaExpressao getListaExp() {
		return listaExp;
	}

	public void setListaExp(ListaExpressao listaExp) {
		this.listaExp = listaExp;
	}

	public LeftExpression getAv() {
		return av;
	}

	public void setAv(LeftExpression av) {
		this.av = av;
	}

	public Id getNomeStruct() {
		return nomeStruct;
	}

	public void setNomeStruct(Id nomeStruct) {
		this.nomeStruct = nomeStruct;
	}
}
