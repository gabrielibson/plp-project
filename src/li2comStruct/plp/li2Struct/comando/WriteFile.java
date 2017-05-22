package li2comStruct.plp.li2Struct.comando;

import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.command.IO;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.imperative1.memory.ErroTipoEntradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;

/**
 * Comando de escrita.
 */
public class WriteFile implements IO {
	/**
	 * Expressï¿½o a ser escrita.
	 */
    private Id id;
    private Valor valor;
	/**
	 * Construtor.
	 * @param expressï¿½o Expressï¿½o a ser escrita.
	 */
    public WriteFile(Id id, Valor valor){
        this.id = id;
        this.valor = valor;
    }

    /**
     * Escreve na saida padrï¿½o.
     * @param ambiente o ambiente de execuï¿½ï¿½o.
     * @return o ambiente depois de modificado pela execuï¿½ï¿½o
     * do comando <code>write</code>.
     * @throws ClasseNaoDeclaradaException 
     */
    public AmbienteExecucaoImperativa2 executar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
        ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {
        /*Valor valor = expressao.avaliar(ambiente);
        System.out.println(valor);*/
    	
    	//TODO implementar lógica de execução do write file
        return null; 
    }

    /**
     * Realiza a verificacao de tipos da expressï¿½o a ser escrita na
     * pelo comando <code>write</code>
     * @param ambiente o ambiente de compilaï¿½ï¿½o.
     * @return <code>true</code> se a expressï¿½o a ser escrita estï¿½ bem tipada;
     *          <code>false</code> caso contrario.
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
        ClasseNaoDeclaradaException {
    	return (this.id.checaTipo(ambiente) && this.valor.checaTipo(ambiente));
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
