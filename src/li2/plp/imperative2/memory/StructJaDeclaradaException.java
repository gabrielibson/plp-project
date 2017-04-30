package li2.plp.imperative2.memory;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;

public class StructJaDeclaradaException extends
		IdentificadorJaDeclaradoException {

	private static final long serialVersionUID = -1793156786677618760L;

	public StructJaDeclaradaException(Id id) {
		super("Struct " + id + " já declarada.");
	}

}
