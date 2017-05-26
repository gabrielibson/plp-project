package li2.plp.li2struct.util;

import li2.plp.expressions2.expression.Id;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.li2struct.excecao.declaracao.StructNaoDeclaradoException;

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
	@Override
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
	public boolean eValido(AmbienteCompilacaoImperativa ambiente)
			throws StructNaoDeclaradoException {
		boolean resposta = false;
		try{
			//ATENCAO: COLOCAR NO AMBIENTE DE COMPILACAO STRUCT-I2 getDEfStruct E MUDAR AQUIIII
			resposta =  (tipoStruct == NULL) || (ambiente.getDefClasse(tipoStruct) != null);
		}
		catch(StructNaoDeclaradoException c){
			resposta = false;
		}
		return resposta;
	}

}
