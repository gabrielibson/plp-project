package li2comStruct.plp.li2Struct.memoria;

import li2comStruct.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2comStruct.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.imperative1.declaration.Declaracao;
import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2comStruct.plp.imperative1.memory.EntradaVaziaException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.expressao.valor.Valor;
import li2comStruct.plp.li2Struct.expressao.valor.ValorRef;
/**
 * Conjunto formado pelo nome da classe de um objeto e o seu estado
 * representado pelo ambiente de execu��o.
 */
public class InstanciaStruct extends Declaracao{
    /**
     * Identificador da classe a que pertence o objeto.
     */
    private Id classeObjeto;

    /**
     * Estado do objeto no ambiente de execu��o.
     */
    private ContextoObjeto estado;

    public InstanciaStruct(){
    	
    }
    
    /**
     * Construtor.
     * @param classeObjeto Classe a que pertence este objeto.
     * @param estadoObj Estado do objeto no ambiente de execu��o.
     */
    public InstanciaStruct(Id classeObjeto,  ContextoObjeto estadoObj) {
        this.classeObjeto = classeObjeto; 
        this.estado = estadoObj;
    }

	/**
     * Obtem o identificador da classe do objeto.
     * @return o identificador da classe do objeto.
     */
    public Id getClasse() {
         return classeObjeto;
    }

    /**
     * Obt�m o atual estado do objeto, conforme o ambiente de execu��o.
     * @return o atual estado do objeto, conforme o ambiente de execu��o.
     */
    public ContextoObjeto getEstado() {
         return estado;
    }

    /**
     * Altera o ambiente de Execu��o, que representa o novo estado do objeto.
     * @param novoEstado o novo estado do objeto.
     */
    public void setEstado(ContextoObjeto novoEstado) {
         this.estado = novoEstado;
    }

    /**
     * insere e mapeia o atributo this do objeto
     * @param vr
     */
	public void mapThis(ValorRef vr) { 
		Id id = new Id("this");
		this.getEstado().remove(id);
        this.getEstado().put(id, vr);
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

	@Override
	public AmbienteExecucaoImperativa elabora(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		// TODO Auto-generated method stub
		return false;
	}
}
