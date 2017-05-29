package li2.plp.li2struct.memory;


import li2.plp.expressions2.memory.Ambiente;
import li2.plp.imperative2.declaration.DefStruct;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;

public interface Ambienteli2Struct<T> extends Ambiente<T>{
	
	public void mapDefStruct(Id id, DefStruct defStruct) throws StructJaDeclaradaException;
		
	
	public DefStruct getDefStruct(Id id) throws StructNaoDeclaradaException;
	
}
