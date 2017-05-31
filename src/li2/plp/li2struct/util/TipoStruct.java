package li2.plp.li2struct.util;

import java.util.ArrayList;
import java.util.List;

import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;

public class TipoStruct implements Tipo{

	private Id tipoStruct;
	private List<Tipo> tiposListaAtributosFormais = new ArrayList<Tipo>();

	public Id getTipo() {
		return tipoStruct;
	}
	
	public TipoStruct(Id tipoStruct){
		this.tipoStruct = tipoStruct;
	}
	
	public TipoStruct(Id tipoStruct, List<Tipo> tiposListaAtributosFormais){
		this.tipoStruct = tipoStruct;
		this.tiposListaAtributosFormais.addAll(tiposListaAtributosFormais);
	}

	/**
	 * Construtor da classe.
	 *
	 * @param tipo o tipo da expressao associada.
	 */

	public TipoStruct(List<Tipo> tiposAtributosReais) {
		this.tiposListaAtributosFormais.addAll(tiposAtributosReais);
	}
	
	 /**
     * Indica se esta classe &eacute; um tipo v�lido, ou seja, se j� tiver sido declarada.
     *
     * @return <code>true</code> se esta classe for um tipo v�lido (j� declarada);
     *          <code>false</code> caso contrario.
     */
	public boolean eValido(AmbienteCompilacaoli2Struct ambiente)
			throws StructNaoDeclaradaException {
		boolean retorno = false;
		for (Tipo tipo : this.tiposListaAtributosFormais) {
			retorno &= tipo.eValido(ambiente);
		}

		return retorno;
	}
	
	/**
     * Compara este tipo com o tipo dado.
     *
     * @return <code>true</code> se se tratarem do mesmo tipo;
     *          <code>false</code> caso contrario.
     */
	public boolean equals(Tipo tipo) {
		if (tipo instanceof TipoStruct) {
			TipoStruct tipoStruct = (TipoStruct) tipo;
			return tipoStruct.tiposListaAtributosFormais.
						equals(this.tiposListaAtributosFormais);
		}
		return ((TipoStruct) tipo).equals(this);
	}


}
