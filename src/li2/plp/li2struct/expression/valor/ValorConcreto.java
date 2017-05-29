package li2.plp.li2struct.expression.valor;

/**
 *
 * Classe que representa um valor concreto
 * 
 */
public interface ValorConcreto extends Valor {
    /**
     * Determina igualdade entre objetos do tipo <code>Valor</code>.
     * baseando-se  no conteudo armazenado em tais objetos.
     *
     * @param o Objeto com o qual eh feita comparacao.
     */
	public boolean equals(ValorConcreto valor);	
}
