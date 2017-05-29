package li2.plp.li2struct.memory;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.Ambiente;
import li2.plp.li2struct.declaracao.struct.DefStruct;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;

public interface AmbienteLi2Struct<T> extends Ambiente<T>{

	public void mapDefStruct(Id idArg, DefStruct defStruct)
			throws StructJaDeclaradaException;
	
	public DefStruct getDefStruct(Id idArg) throws StructNaoDeclaradaException;
}
