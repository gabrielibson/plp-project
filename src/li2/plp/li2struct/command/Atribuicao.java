package li2.plp.li2struct.command;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.Expressao;
import li2.plp.li2struct.expression.leftExpression.AcessoAtributo;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.leftExpression.LeftExpression;
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.memory.Instancia;


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
	 * Executa a atribui��o.
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            valores.
	 * 
	 * @return o ambiente modificado pela execu��o da atribui��o.
	 * @throws StructNaoDeclaradaException 
	 * @throws InstanciaStructNaoDeclaradaException 
	 * 
	 */
	public AmbienteExecucaoli2Struct executar(
			AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, 
			InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		Id idVariavel = this.av.getId();
		if(this.av instanceof AcessoAtributo){
			Expressao expAV = ((AcessoAtributo)av).getExpressaoInstancia();
			ValorRef referencia = (ValorRef)expAV.avaliar(ambiente);
			Instancia instancia = ambiente.getInstancia(referencia);
            instancia.changeAtributo(idVariavel, expressao.avaliar(ambiente));
		}
		else
            ambiente.changeValor(idVariavel, expressao.avaliar(ambiente));
		return ambiente;
	}

	/**
	 * Um comando de atribui��o est� bem tipado, se o tipo do identificador � o
	 * mesmo da express�o. O tipo de um identificador � determinado pelo tipo da
	 * express�o que o inicializou (na declara��o).
	 * 
	 * @param ambiente
	 *            o ambiente que contem o mapeamento entre identificadores e
	 *            valores.
	 * 
	 * @return <code>true</code> se os tipos da atribui��o s�o v�lidos;
	 *         <code>false</code> caso contrario.
	 * @throws StructNaoDeclaradaException 
	 * 
	 */
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			StructNaoDeclaradaException {
		return expressao.checaTipo(ambiente)
				&& av.getTipo(ambiente).equals(expressao.getTipo(ambiente));
	}
}
