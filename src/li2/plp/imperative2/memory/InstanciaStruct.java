package li2.plp.imperative2.memory;

import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.expressao.leftExpression.Id;
import li2.plp.imperative2.expressao.valor.Valor;

/**
 * Conjunto formado pelo nome da classe de um objeto e o seu estado
 * representado pelo ambiente de execu��o.
 */
public class InstanciaStruct {
    /**
     * Identificador da classe a que pertence o objeto.
     */
    private Id structInstancia;

    /**
     * Estado do objeto no ambiente de execu��o.
     */
    private ContextoInstanciaStruct estado;

    /**
     * Construtor.
     * @param structInstancia Struct a que pertence esta inst�ncia.
     * @param estadoInstancia Estado da inst�ncia no ambiente de execu��o.
     */
    public InstanciaStruct(Id structInstancia,  ContextoInstanciaStruct estadoInstancia) {
        this.structInstancia = structInstancia; 
        this.estado = estadoInstancia;
    }

	/**
     * Obtem o identificador da classe do objeto.
     * @return o identificador da classe do objeto.
     */
    public Id getStruct() {
         return structInstancia;
    }

    /**
     * Obt�m o atual estado do objeto, conforme o ambiente de execu��o.
     * @return o atual estado do objeto, conforme o ambiente de execu��o.
     */
    public ContextoInstanciaStruct getEstado() {
         return estado;
    }

    /**
     * Altera o ambiente de Execu��o, que representa o novo estado do objeto.
     * @param novoEstado o novo estado do objeto.
     */
    public void setEstado(ContextoInstanciaStruct novoEstado) {
         this.estado = novoEstado;
    }

	/**
	 * muda o valor de um atributo do objeto
	 * @param idVariavel
	 * @param valor
	 * @throws VariavelNaoDeclaradaException
	 */
	public void changeAtributo(Id idVariavel, Valor valor) throws VariavelNaoDeclaradaException{
		
		if (this.getEstado().containsKey(idVariavel)) {
        	this.getEstado().remove(idVariavel);
        	this.getEstado().put(idVariavel, valor);
        }
        else
        {
        	throw new VariavelNaoDeclaradaException(idVariavel);
        }
	}

}
