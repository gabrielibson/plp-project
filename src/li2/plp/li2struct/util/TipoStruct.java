package li2.plp.li2struct.util;

import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;

public class TipoStruct implements Tipo{


	/**
	 * Indica que a expressao associada &eacute; nula.
	 */
	public static final Id NULL = new Id("NULL");

	/**
	 * Constante de tipo nulo.
	 */
	public static final Tipo TIPO_NULL = new TipoStruct(NULL);



	private Id tipoStruct;

	public Id getTipo() {
		// TODO Auto-generated method stub
		return tipoStruct;
	}

	/**
	 * Construtor da classe.
	 *
	 * @param tipo o tipo da expressao associada.
	 */

	public TipoStruct(Id tipoStruct) {
		this.tipoStruct = tipoStruct;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retorna  a descri��o textual do tipo.
	 * @return  a descri��o textual do tipo.
	 */
	public String toString() {
		return tipoStruct.toString();
	}
	
	 /**
     * Indica se esta classe &eacute; um tipo v�lido, ou seja, se j� tiver sido declarada.
     *
     * @return <code>true</code> se esta classe for um tipo v�lido (j� declarada);
     *          <code>false</code> caso contrario.
     */
	
	

	public boolean eValido(AmbienteCompilacaoli2Struct ambiente)
			throws StructNaoDeclaradaException {

		boolean resposta = false;
		/*try{
			//ATENCAO: COLOCAR NO AMBIENTE DE COMPILACAO STRUCT-I2 getDEfStruct E MUDAR AQUIIII
			resposta =  (tipoStruct == NULL) || (ambiente.getDefStruct(tipoStruct) != null);
		}
		catch(StructNaoDeclaradaException c){
			resposta = false;
		}*/
		return resposta;
	}
	
	/**
     * Compara este tipo com o tipo dado.
     *
     * @return <code>true</code> se se tratarem do mesmo tipo;
     *          <code>false</code> caso contrario.
     */
/*    public boolean equals(Object obj) {
        return (obj instanceof TipoStruct) &&
               ((TipoStruct)obj).tipoStruct.equals(this.tipoStruct);
    }
*/


}

