package li2.plp.li2struct.memory;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.util.Tipo;

public interface AmbienteCompilacaoli2Struct extends AmbienteLi2Struct<Tipo>{

	public Tipo getTipo(Id idArg) throws VariavelNaoDeclaradaException;
	
	public Tipo getTipoEntrada() throws VariavelNaoDeclaradaException;
}
