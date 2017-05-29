package li2.plp.li2struct.memory;


import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.util.Tipo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public interface AmbienteCompilacaoli2Struct extends AmbienteCompilacao{

	public Tipo getTipo(Id idArg) throws VariavelNaoDeclaradaException;
	
	public Tipo getTipoEntrada() throws VariavelNaoDeclaradaException;

}
