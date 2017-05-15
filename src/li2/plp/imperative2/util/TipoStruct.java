package li2.plp.imperative2.util;

import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.expressao.leftExpression.Id;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;

/**
 * Classe que representa os possiveis tipos de uma expressao.
 */
public class TipoStruct implements Tipo {

    /**
     * Indica que a expressao associada &eacute; uma classe.
     */
    private Id tipoStruct;

    /**
     * Indica que a expressao associada &eacute; nula.
     */
    public static final Id NULL = new Id("NULL");

    /**
     * Constante de tipo nulo.
     */
    public static final Tipo TIPO_NULL = new TipoStruct(NULL);

     /**
     * Construtor da classe.
     *
     * @param tipo o tipo da expressao associada.
     */

     public TipoStruct(Id tipoStruct) {
        this.tipoStruct = tipoStruct;
     }


    /**
     * Retorna o tipo da expressao associada.
     *
     * @return o tipo da expressao associada.
     */
    public Id getTipo() {
        return tipoStruct;
    }


    /**
     * Indica se esta classe &eacute; um tipo v�lido, ou seja, se j� tiver sido declarada.
     *
     * @return <code>true</code> se esta classe for um tipo v�lido (j� declarada);
     *          <code>false</code> caso contrario.
     */

    public boolean eValido(AmbienteCompilacaoImperativa2 ambiente)
         throws StructNaoDeclaradaException {
        boolean resposta = false;
        try{
             resposta =  (tipoStruct == NULL) || (ambiente.getDefStruct(tipoStruct) != null);
         }
         catch(StructNaoDeclaradaException c){
              resposta = false;
         }
         return resposta;
    }

    /**
     * Compara este tipo com o tipo dado.
     *
     * @return <code>true</code> se se tratarem do mesmo tipo;
     *          <code>false</code> caso contrario.
     */
    public boolean equals(Object obj) {
        return (obj instanceof TipoStruct) &&
               ((TipoStruct)obj).tipoStruct.equals(this.tipoStruct);
    }
    /**
     * Retorna  a descri��o textual do tipo.
     * @return  a descri��o textual do tipo.
     */
    public String toString() {
        return tipoStruct.toString();
    }
}
