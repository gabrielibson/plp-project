package li2.plp.li2struct.declaracao;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoStruct;

public class DeclaracaoVariavel implements Declaracao {

	private Id id;
	private Expressao expressao;
	private Tipo tipo;

	public DeclaracaoVariavel(Id id, Expressao expressao) {
		super();
		this.id = id;
		this.expressao = expressao;
	}

	public Expressao getExpressao() {
		return this.expressao;
	}

	public Id getId() {
		return this.id;
	}

	public AmbienteExecucaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException,
			InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException {
		ambiente.map(id , expressao.avaliar(ambiente));
        return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		 boolean resposta = false;
	        if ( expressao.checaTipo(ambiente) ) {
	            if( tipo instanceof TipoStruct) {
	                resposta = expressao.getTipo(ambiente).equals(tipo);
	            }
	        }
	        if(resposta) {
	            ambiente.map(id, (li2.plp.expressions1.util.Tipo) tipo);
	        }
	        return resposta;
	}
}
