package li2comStruct.plp.li2Struct.expressao.leftExpression;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;

/**
 * Classe que representa um identificador.
 */
public class Id extends li2comStruct.plp.expressions2.expression.Id implements LeftExpression{ //,IDominio{
    
	/**
     * Construtor.
     * @param strName Nome do identificador.
     */
    public Id(String strName) {
        super(strName);
    }
    /**
     * Retorna o nome desse identificador.
     * @return o nome do identificador.
     */
    public String toString() {
        return this.getIdName();
    }

    /**
     * Retorna o valor deste identificador.
     * @param ambiente o ambiente de execu��o, com o mapeamento de identificadores
     * a valores.
     * @return o valor deste identificador
     * @throws VariavelNaoDeclaradaException 
     * @exception VariavelNaoDeclaradaException se este identificador nao
     *  estiver no ambiente.
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, ClasseNaoDeclaradaException, VariavelNaoDeclaradaException {
        return obterValorDeIdNoAmbiente(ambiente);
    }

    /**
     * Realiza a verificacao de tipos desta expressao.
     * @param ambiente o ambiente de compila��o.
     * @return <code>true</code> se os tipos da expressao s�o v�lidos;
     *          <code>false</code> caso contrario.
     * @throws VariavelNaoDeclaradaException 
     * @exception VariavelNaoDeclaradaException se este identificador nao
     *          estiver no ambiente.
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 amb) throws VariavelNaoDeclaradaException {
        boolean result = true;
        amb.get(this); // verifica se est� no ambiente
        return result;
    }

    /**
     * Retorna os tipos possiveis desta expressao.
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     * @throws VariavelNaoDeclaradaException 
     * @exception VariavelNaoDeclaradaException se este identificador nao
     *          estiver no ambiente.
     */
    public Tipo getTipo(AmbienteCompilacaoImperativa2 amb) throws VariavelNaoDeclaradaException {
        return amb.get(this);
    }
    /**
     * Obt�m este identificador.
     * @return este Id.
     */
    public Id getId(){
        return this;
    }

    /**
     * Retorna o valor do Objeto representado por um certo id
     * @param ambiente � o Ambiente de Execu��o
     * @return o valor do Objeto representado por um certo id
     * @throws VariavelNaoDeclaradaException 
     */
    private Valor obterValorDeIdNoAmbiente(AmbienteExecucaoImperativa2 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
        return (Valor) ambiente.get(this);
    }
}