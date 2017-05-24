package li2comStruct.plp.li2Struct;

import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.imperative1.memory.ErroTipoEntradaException;
import li2comStruct.plp.imperative1.memory.ListaValor;
import li2comStruct.plp.li2Struct.comando.Comando;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseJaDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.execucao.EntradaInvalidaException;
import li2comStruct.plp.li2Struct.excecao.execucao.EntradaNaoFornecidaException;
/**
 * Classe que representa um programa na linguagem OO.
 */
public class Programa {
  
    private Comando comando;

    /**
     * Construtor.
     * @param comando O comando executado.
     */
    public Programa(Comando comando){
        this.comando = comando;
    }
    
    /**
	 * Executa o programa.
	 * 
	 * @param ambiente
	 *            o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do programa.
	 * @throws ErroTipoEntradaException 
     * @throws EntradaInvalidaException 
     * @throws ClasseNaoDeclaradaException 
     * @throws ClasseJaDeclaradaException 
     * @throws ProcedimentoJaDeclaradoException 
     * @throws ProcedimentoNaoDeclaradoException 
     * @throws ObjetoNaoDeclaradoException 
     * @throws ObjetoJaDeclaradoException 
	 * 
	 * @exception EntradaNaoFornecidaException
	 *                se n�o for fornecida a tail de valores de entrada do
	 *                programa.
	 * 
	 */
	public ListaValor executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException, 
			ErroTipoEntradaException, ObjetoJaDeclaradoException, 
			ObjetoNaoDeclaradoException, ProcedimentoNaoDeclaradoException, 
			ProcedimentoJaDeclaradoException, ClasseJaDeclaradaException, 
			ClasseNaoDeclaradaException, EntradaInvalidaException {
		ambiente = comando.executar(ambiente);
		return ambiente.getSaida();
	}

	/**
	 * Realiza a verificacao de tipos do programa
	 * 
	 * @param ambiente
	 *            o ambiente de compila��o.
	 * @return <code>true</code> se o programa est� bem tipado;
	 *         <code>false</code> caso contrario.
	 * @throws ClasseNaoDeclaradaException 
	 * @throws ClasseJaDeclaradaException 
	 * @throws ProcedimentoJaDeclaradoException 
	 * @throws ProcedimentoNaoDeclaradoException 
	 * 
	 * @exception EntradaNaoFornecidaException
	 *                se n�o for fornecida a tail de valores de entrada do
	 *                programa.
	 * 
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException, 
			ClasseJaDeclaradaException, ClasseNaoDeclaradaException {
		return comando.checaTipo(ambiente);
	}
}