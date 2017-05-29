package li2.plp.li2struct.command;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

public class Write implements IO {

	private Expressao expressao;

	public Write(Expressao expressao) {
		this.expressao = expressao;
	}

	/**
	 * Escreve na saida padr�o.
	 * 
	 * @param ambiente
	 *            o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do comando
	 *         <code>write</code>.
	 * @throws StructNaoDeclaradaException 
	 * @throws InstanciaStructNaoDeclaradaException 
	 * 
	 */
	public AmbienteExecucaoli2Struct executar(
			AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, 
			InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		Valor valor = expressao.avaliar(ambiente);
        System.out.println(valor);
        return ambiente.write( valor);
		/*ambiente.write(expressao.avaliar(ambiente));
		return ambiente;*/
	}

	/**
	 * Realiza a verificacao de tipos da express�o a ser escrita na pelo comando
	 * <code>write</code>
	 * 
	 * @param ambiente
	 *            o ambiente de compila��o.
	 * @return <code>true</code> se a express�o a ser escrita est� bem tipada;
	 *         <code>false</code> caso contrario.
	 * @throws StructNaoDeclaradaException 
	 */
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		return expressao.checaTipo(ambiente);
	}

}
