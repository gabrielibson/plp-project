package li2comStruct.plp.li2Struct.comando;

import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.imperative1.memory.ErroTipoEntradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.execucao.EntradaInvalidaException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;

/**
 * Representa um comando de leitura do arquivo de registros.
 */
public class ReadFile implements IO{
	/**
	 * O identificador ao qual será atribuído o valor lido.
	 */
    private Id id;
	/**
	 * Valor chave do registro.
	 */
    private Valor key;
    
    /**
	 * Valor nome do arquivo.
	 */
    private Valor file;
	/**
	 * Construtor.
	 * @param id O identificador ao qual serï¿½ a atribuï¿½do o valor lido.
	 */
    public ReadFile ( Id id, Valor key, Valor file){
        this.id = id;
        this.key = key;
        this.file = file;
    }

    /**
     * Lï¿½ da entrada padrï¿½o.
     * @param ambiente o ambiente de execuï¿½ï¿½o.
     * @return o ambiente depois de modificado pela execuï¿½ï¿½o
     * do comando read.
     *
     */
    public AmbienteExecucaoImperativa2 executar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, EntradaInvalidaException {
        //TODO implementar lógica de leitura do arquivo
        return ambiente;
    }

    /**
     * Realiza a verificacao de tipos da entrada
     * @param ambiente o ambiente de compilaï¿½ï¿½o.
     * @return <code>true</code> se a expressï¿½o da entrada estï¿½ bem tipada;
     *          <code>false</code> caso contrario.
     * @throws ClasseNaoDeclaradaException 
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
//      Alteramos a implementaï¿½ï¿½o, pois em tempo de compilaï¿½ï¿½o nï¿½o se pode saber
//      o tipo da entrada que serï¿½ lida.

//        Tipo tipo = ambiente.getTipoEntrada();
//        Tipo tipo2 = id.getTipo(ambiente);
    	boolean retorno = false;
    	if(id.checaTipo(ambiente) && this.key.checaTipo(ambiente) && this.file.checaTipo(ambiente)){
    		retorno = true;
    	}
        return retorno;

        //return id.getTipo(ambiente).equals(ambiente.getTipoEntrada());
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
