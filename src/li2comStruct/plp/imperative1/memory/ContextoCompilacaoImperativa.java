package li2comStruct.plp.imperative1.memory;

import li2comStruct.plp.expressions1.util.Tipo;
import li2comStruct.plp.expressions2.memory.ContextoCompilacao;
import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ContextoCompilacaoImperativa extends ContextoCompilacao 
	implements AmbienteCompilacaoImperativa {

    /**
     * A pilha de blocos de contexto.
     */    
    private ListaValor entrada;

    /**
     * Construtor da classe.
     */
    public ContextoCompilacaoImperativa(ListaValor entrada){
        super();
        this.entrada = entrada;        
    }

    public Tipo getTipoEntrada() throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
    		EntradaVaziaException {
        if(entrada == null || entrada.getHead() == null) {
            throw new EntradaVaziaException();
        }
        Tipo aux = entrada.getHead().getTipo(this);
        entrada = (ListaValor)entrada.getTail();
        return aux;            
    }
    
}

