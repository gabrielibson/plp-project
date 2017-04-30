package li2.plp.imperative2.util;

import static li2.plp.expressions1.util.ToStringProvider.listToString;

import java.util.ArrayList;
import java.util.List;

import li2.plp.expressions1.util.Tipo;

public class TipoStruct implements Tipo {

	private List<Tipo> tiposVariaveisFormais = new ArrayList<Tipo>();

	public TipoStruct() {
	}

	public boolean eBooleano() {
		return false;
	}

	public boolean eIgual(Tipo tipo) {
		if (tipo instanceof TipoStruct) {
			TipoStruct tipoProc = (TipoStruct) tipo;
			return tipoProc.tiposVariaveisFormais
					.equals(this.tiposVariaveisFormais);
		}

		return tipo.eIgual(this);
	}

	public boolean eInteiro() {
		return false;
	}

	public boolean eString() {
		return false;
	}

	public boolean eValido() {
		boolean retorno = true;
		for (Tipo tipo : tiposVariaveisFormais) {
			retorno &= tipo.eValido();
		}

		return retorno;
	}

	public String getNome() {
		return listToString(this.tiposVariaveisFormais, "{", "}", ",");
	}

	public Tipo intersecao(Tipo outroTipo) {
		if (outroTipo.eIgual(this))
			return this;
		else
			return null;
	}

}
