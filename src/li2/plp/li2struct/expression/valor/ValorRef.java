package li2.plp.li2struct.expression.valor;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

/**
 * Classe que representa a refer�ncia a um objeto.
 */
public class ValorRef implements Valor{
    /**
     * Primeira referencia valida na memoria
     */
    public static final int VALOR_INICIAL = 0;
    /**
     * Valor que representa a refer�ncia.
     */
    private int valor;
    /**
     * Construtor.
     * @param valor O valor que representa a refer�ncia.
     */
    public ValorRef(int valor){
        if ( valor >= ValorRef.VALOR_INICIAL){
             this.valor = valor;
    }
        else this.valor = VALOR_INICIAL;
    }

    /**
     * Obt�m o valor.
     * @return o valor refer�ncia.
     */
    public int valor() {
        return valor;
    }
    /**
     * Avalia um certo valor refer�ncia.
     * @param ambiente o ambiente de execu�ao
     * @return o valor associado a uma dada refer�ncia.
     */
	public Valor avaliar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		return this;
	}

    //Os m�todos getTipo e checaTipo de ValorRef
    //n�o foram utilizados nessa linguagem.
    public int hashCode() {
        return valor;
    }
    /**
     * Obt�m o tipo associado a este valor refer�ncia no ambiente de compila�ao.
     * @param amb o ambiente de compila��o.
     * @return o tipo deste valor refer�ncia.
     */
    public Tipo getTipo(AmbienteCompilacaoli2Struct amb) {
        return (Tipo) TipoPrimitivo.TIPO_INTEIRO;
    }
    
    /**
     * Checa o tipo deste valor referencia no ambiente de compila��o.
     * @param amb o ambiente de compila��o
     * @return true em todos os casos.
     */
    public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		return true;
	}
    
    /**
     * Compara dois valores
     * @param val o valor que vai ser comparado com este.
     * @return true se os valores forem iguais e false, caso contr�rio.
     */
    public boolean equals(Valor val){
        if ( val instanceof ValorRef)
            return valor == ((ValorRef)val).valor();
        else return false;
    }

    /**
     * Incrementa este valor refer�ncia.
     * @return um novo valor refer�ncia.
     */
    public ValorRef incrementa(){
        valor = valor + 1;
        return this;
    }

	

}
