package li2comStruct.plp.li2Struct.util;

import li2comStruct.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.expressao.leftExpression.Id;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;

/**
 * Classe que representa os possiveis tipos de uma expressao.
 */
public class TipoStruct implements Tipo {

    /**
     * Indica que a expressao associada &eacute; uma classe.
     */
    private Id tipoClasse;

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

     public TipoStruct(Id tipoClasse) {
        this.tipoClasse = tipoClasse;
     }


    /**
     * Retorna o tipo da expressao associada.
     *
     * @return o tipo da expressao associada.
     */
    public Id getTipo() {
        return tipoClasse;
    }


    /**
     * Indica se esta classe &eacute; um tipo v�lido, ou seja, se j� tiver sido declarada.
     *
     * @return <code>true</code> se esta classe for um tipo v�lido (j� declarada);
     *          <code>false</code> caso contrario.
     */

    public boolean eValido(AmbienteCompilacaoImperativa2 ambiente)
         throws ClasseNaoDeclaradaException {
        boolean resposta = false;
        try{
             resposta =  (tipoClasse == NULL) || (ambiente.getDefClasse(tipoClasse) != null);
         }
         catch(ClasseNaoDeclaradaException c){
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
               ((TipoStruct)obj).tipoClasse.equals(this.tipoClasse);
    }
    /**
     * Retorna  a descri��o textual do tipo.
     * @return  a descri��o textual do tipo.
     */
    public String toString() {
        return tipoClasse.toString();
    }


	public boolean eValido(AmbienteCompilacaoImperativa ambiente) throws ClasseNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}
}
