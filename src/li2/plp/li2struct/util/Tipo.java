package li2.plp.li2struct.util;

import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;

public interface Tipo {

	public Id getTipo();
	
	public boolean equals(Object obj);
	
	public boolean eValido(AmbienteCompilacaoli2Struct ambiente) throws StructNaoDeclaradaException;
}
