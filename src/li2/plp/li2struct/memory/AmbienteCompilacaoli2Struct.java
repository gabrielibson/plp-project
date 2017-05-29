package li2.plp.li2struct.memory;

import li2.plp.li2struct.declaracao.struct.ListaDecAtributoStruct;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.util.Tipo;

public interface AmbienteCompilacaoli2Struct extends Ambienteli2Struct<Tipo>{
	
	public Tipo getTipo(Id id) throws InstanciaStructNaoDeclaradaException;
	
	public void mapAtributosStruct(Id id, ListaDecAtributoStruct listaDecAtributoStruct) throws StructJaDeclaradaException;
	
	public ListaDecAtributoStruct getDecAtributosStruct(Id id) throws StructNaoDeclaradaException;
	
	public Tipo getTipoEntrada() throws InstanciaStructNaoDeclaradaException;
	
}
