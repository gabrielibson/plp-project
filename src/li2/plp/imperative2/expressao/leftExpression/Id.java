package li2.plp.imperative2.expressao.leftExpression;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative2.declaration.ClasseNaoDeclaradaException;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.expressions2.expression.Valor;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;;
import li2.plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import li2.plp.orientadaObjetos1.util.Tipo;

/**
 * Classe que representa um identificador.
 */
public class Id extends Id implements LeftExpression{ //,IDominio{
    
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
        throws VariavelJaDeclaradaException, ProcedimentoJaDeclaradoException, VariavelNaoDeclaradaException {
        return avaliar(ambiente);
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
    public boolean checaTipo(AmbienteCompilacaoImperativa amb) throws VariavelNaoDeclaradaException {
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
    public Tipo getTipo(AmbienteCompilacaoImperativa amb) throws VariavelNaoDeclaradaException {
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
        return ambiente.get(this);
    }
}