package li2.plp.li2struct.command;

import li2.plp.expressions2.expression.ValorBooleano;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.TipoPrimitivo;

public class While implements Comando {

	private Expressao expressao;

	private Comando comando;

	public While(Expressao expressao, Comando comando) {
		this.expressao = expressao;
		this.comando = comando;
	}

	/**
	 * Implementa o comando <code>while</code>.
	 * 
	 * @param ambiente
	 *            o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do comando
	 *         <code>while</code>.
	 * @throws ErroTipoEntradaException 
	 * 
	 */
/*	public AmbienteExecucaoImperativa executar(
			AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException, ErroTipoEntradaException {
		while (((ValorBooleano) expressao.avaliar(ambiente)).valor()) {
			ambiente = comando.executar(ambiente);
		}
		return ambiente;
	}*/

	/**
	 * Realiza a verificacao de tipos da express�o e dos comandos do comando
	 * <code>while</code>
	 * 
	 * @param ambiente
	 *            o ambiente de compila��o.
	 * @return <code>true</code> se os comando s�o bem tipados;
	 *         <code>false</code> caso contrario.
	 */
/*	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return expressao.checaTipo(ambiente)
				&& expressao.getTipo(ambiente).eBooleano()
				&& comando.checaTipo(ambiente);
	}*/

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
			StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException {
		while ( ((ValorBooleano)expressao.avaliar(ambiente)).valor() ) {
            ambiente = comando.executar(ambiente);
        }
        return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		return expressao.checaTipo(ambiente) &&
	               ((TipoPrimitivo)expressao.getTipo(ambiente)).eBooleano() &&
	               comando.checaTipo(ambiente);
	}

}
