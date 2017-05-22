package li2comStruct.plp.li2Struct.comando;

import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.command.Comando;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.imperative1.memory.ErroTipoEntradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ObjetoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.expressao.Expressao;
import li2comStruct.plp.li2Struct.expressao.leftExpression.AcessoAtributo;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.expressao.leftExpression.LeftExpression;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorRef;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.InstanciaStruct;
/**
 * Classe que representa um comando de atribui��o.
 */
public class Atribuicao implements Comando {
	/**
	 * Lado esquerdo do comando de atribui��o.
	 */
    protected LeftExpression av;
    
	/**
	 * Express�o cujo valor ser� atribu�do ao lado esquerdo.
	 */
    protected Expressao expressao;
    
	/**
	 * Construtor.
	 * @param av Lado esquerdo
	 * @param expressao Express�o cujo valor ser� atribu�do ao lado esquerdo.
	 */
    public Atribuicao(LeftExpression av, Expressao expressao){
        this.av = av;
        this.expressao = expressao;
    }

    /**
     * Executa  a atribui��o.
     *
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e valores.
     * @return o ambiente modificado pela execu��o da atribui��o.
     * @throws ClasseNaoDeclaradaException 
     *
     */
    public AmbienteExecucaoImperativa2 executar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
               ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException {

        Id idVariavel =  av.getId();
        if ( av instanceof AcessoAtributo){
            
        	// se for acesso a atributo, tem de alterar o ambiente do objeto!
            Expressao expAV = (Expressao) ((AcessoAtributo)av).getExpressaoObjeto();
            ValorRef referencia = (ValorRef)expAV.avaliar((AmbienteExecucaoImperativa2) ambiente);
            InstanciaStruct obj = ((AmbienteExecucaoImperativa2) ambiente).getObjeto(referencia);
            obj.changeAtributo(idVariavel, (Valor) expressao.avaliar((AmbienteExecucaoImperativa2) ambiente));
        }
        else
            ambiente.changeValor(idVariavel, expressao.avaliar((AmbienteExecucaoImperativa2) ambiente));
        return ambiente;
    }

    /**
     * Um comando de atribui��o est� bem tipado, se o tipo do identificador �
     * o mesmo da express�o. O tipo de um identificador � determinado pelo
     * tipo da express�o que o inicializou (na declara��o).
     *
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e valores.
     * @return <code>true</code> se os tipos da atribui��o s�o v�lidos;
     *          <code>false</code> caso contrario.
     *
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
        return expressao.checaTipo(ambiente) &&
              (av.getTipo(ambiente).equals(expressao.getTipo(ambiente)));
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