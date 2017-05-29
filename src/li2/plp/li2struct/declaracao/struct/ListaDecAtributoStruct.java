package li2.plp.li2struct.declaracao.struct;


import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.TipoPrimitivo;

public class ListaDecAtributoStruct extends DeclaracaoAtributoStruct{



	public ListaDecAtributoStruct(TipoPrimitivo tipo, Id id) {
		super(tipo, id);
		// TODO Auto-generated constructor stub
	}


	public AmbienteCompilacaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente)
			throws InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente) throws InstanciaStructNaoDeclaradaException,
	InstanciaStructJaDeclaradaException, StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}


}
