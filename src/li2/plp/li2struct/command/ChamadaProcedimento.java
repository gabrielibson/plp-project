package li2.plp.li2struct.command;

import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
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
import li2.plp.li2struct.memory.ListaValor;
import li2.plp.li2struct.util.TipoProcedimento;

public class ChamadaProcedimento implements Comando {

	private Id nomeProcedimento;

	private ListaExpressao parametrosReais;

	public ChamadaProcedimento(Id nomeProcedimento,
			ListaExpressao parametrosReais) {
		this.nomeProcedimento = nomeProcedimento;
		this.parametrosReais = parametrosReais;
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct amb) 
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, 
			ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException, 
			InstanciaStructJaDeclaradaException, InstanciaStructNaoDeclaradaException, 
			StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException {
		AmbienteExecucaoli2Struct ambiente = (AmbienteExecucaoli2Struct) amb;
		DefProcedimento procedimento = ambiente
				.getProcedimento(nomeProcedimento);

		/*
		 * o incrementa e o restaura neste ponto servem para criar as variveis
		 * que serao utilizadas pela execucao do procedimento
		 */
		ambiente.incrementa();
		ListaDeclaracaoParametro parametrosFormais = procedimento
				.getParametrosFormais();
		AmbienteExecucaoli2Struct aux = bindParameters(ambiente,
				parametrosFormais);
		aux = procedimento.getComando().executar(aux);
		aux.restaura();
		return aux;

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
		ListaValor listaValor = parametrosReais.avaliar(ambiente);
		while (listaValor.length() > 0) {
			ambiente.map(parametrosFormais.getHead().getId(), (Valor) listaValor
					.getHead());
			parametrosFormais = (ListaDeclaracaoParametro) parametrosFormais
					.getTail();
			listaValor = (ListaValor) listaValor.getTail();
		}
		return ambiente;
	}

	/**
	 * Realiza a verificacao de tipos desta chamada de procedimento, onde os
	 * tipos dos parametros formais devem ser iguais aos tipos dos parametros
	 * reais na ordem em que se apresentam.
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            tipos.
	 * @return <code>true</code> se a chamada de procedimeno est� bem tipada;
	 *         <code>false</code> caso contrario.
	 * @throws StructNaoDeclaradaException 
	 */
	public boolean checaTipo(AmbienteCompilacaoli2Struct amb)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, StructNaoDeclaradaException {

		TipoProcedimento tipoProcedimento = (TipoProcedimento) amb.get(this.nomeProcedimento);
		TipoProcedimento tipoParametrosReais = new TipoProcedimento(parametrosReais.getTipos(amb));
		return tipoProcedimento.eIgual(tipoParametrosReais);
	}
}
