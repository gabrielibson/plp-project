package li2.plp.li2struct.command;

import java.util.List;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.ListaValor;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.imperative2.util.TipoProcedimento;
import li2.plp.li2struct.declaracao.procedimento.DefProcedimento;
import li2.plp.li2struct.declaracao.procedimento.ListaDeclaracaoParametro;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

public class ChamadaProcedimento implements Comando {

	private Id nomeProcedimento;

	private ListaExpressao parametrosReais;

	public ChamadaProcedimento(Id nomeProcedimento,
			ListaExpressao parametrosReais) {
		this.nomeProcedimento = nomeProcedimento;
		this.parametrosReais = parametrosReais;
	}
	
	/**
	 * insere no contexto o resultado da associacao entre cada parametro formal
	 * e seu correspondente parametro atual
	 * @throws StructNaoDeclaradaException 
	 * @throws InstanciaStructNaoDeclaradaException 
	 */
	private AmbienteExecucaoli2Struct bindParameters(
			AmbienteExecucaoli2Struct ambiente,
			ListaDeclaracaoParametro parametrosFormais)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		ListaValor listaValor =  parametrosReais.avaliar(ambiente);
        if(listaValor == null) {
            listaValor = parametrosReais.avaliar(ambiente);
        }
        while (listaValor.length() > 0){
            ambiente.map(parametrosFormais.getHead().getId(), (Valor) listaValor.getHead());
            parametrosFormais = ((ListaDeclaracaoParametro) parametrosFormais.getTail());
            listaValor = (ListaValor)listaValor.getTail();
        }
        return ambiente;
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, StructJaDeclaradaException, StructNaoDeclaradaException, 
			EntradaInvalidaException {
		
		DefProcedimento procedimento = ambiente.getProcedimento(nomeProcedimento);
		ambiente.incrementa();
		ListaDeclaracaoParametro parametrosFormais = procedimento
				.getParametrosFormais();
		AmbienteExecucaoli2Struct aux = bindParameters(ambiente,
				parametrosFormais);
		try {
			aux = (AmbienteExecucaoli2Struct) procedimento.getComando().executar(aux);
		} catch (IdentificadorJaDeclaradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdentificadorNaoDeclaradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux.restaura();
		return aux;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		
		Tipo tipoProcedimento = ambiente.get(this.nomeProcedimento);

		TipoProcedimento tipoParametrosReais = new TipoProcedimento(
				(List<Tipo>) parametrosReais.getTipos(ambiente));
		return tipoProcedimento.eIgual(tipoParametrosReais);
	}

}
