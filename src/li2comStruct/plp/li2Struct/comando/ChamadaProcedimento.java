package li2comStruct.plp.li2Struct.comando;

import li2comStruct.plp.expressions2.expression.Valor;
import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.imperative1.memory.ErroTipoEntradaException;
import li2comStruct.plp.imperative2.util.TipoProcedimento;
import li2comStruct.plp.li2Struct.declaracao.procedimento.DefProcedimento;
import li2comStruct.plp.li2Struct.declaracao.procedimento.ListaDeclaracaoParametro;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseJaDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.execucao.EntradaInvalidaException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.colecao.ListaValor;
import li2comStruct.plp.li2Struct.util.Tipo;

/**
 * Classe que representa a chamada de um m�todo.
 */
public class ChamadaProcedimento implements Comando {
    /**
     * O identificador que representa o nome do m�todo.
     */
    protected Id nomeProcedimento;
    /**
     * Par�metros passados para o m�todo.
     */
    protected ListaExpressao parametrosReais;

    /**
     * Construtor.
     * @param expressao A expressao chamadora do m�todo.
     * @param nomeProcedimento O nome do m�todo.
     * @param parametrosReais Os par�metros passados para a execu��o do m�todo.
     * @param
     */
    public ChamadaProcedimento(Id nomeProcedimento, ListaExpressao parametrosReais){
        this.nomeProcedimento = nomeProcedimento;
        this.parametrosReais = parametrosReais;
    }

    /**
	 * insere no contexto o resultado da associacao entre cada parametro formal
	 * e seu correspondente parametro atual
     * @throws ClasseNaoDeclaradaException 
     * @throws ObjetoNaoDeclaradoException 
	 */
	private AmbienteExecucaoImperativa2 bindParameters(
			AmbienteExecucaoImperativa2 ambiente,
			ListaDeclaracaoParametro parametrosFormais)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
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

	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		// TODO Auto-generated method stub
		return false;
	}
}
