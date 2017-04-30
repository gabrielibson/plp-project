package li2.plp.imperative2.memory;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;

public class StructNaoDeclaradaException extends
		IdentificadorNaoDeclaradoException {

	private static final long serialVersionUID = -5023666514074530307L;

	public StructNaoDeclaradaException(Id id) {
		super("Struct " + id + " nao declarada.");
	}

}
