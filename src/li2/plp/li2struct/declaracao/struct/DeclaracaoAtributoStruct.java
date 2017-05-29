package li2.plp.li2struct.declaracao.struct;

import li2.plp.li2struct.declaracao.Declaracao;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.TipoPrimitivo;

public class DeclaracaoAtributoStruct implements Declaracao{

	private TipoPrimitivo tipo;
	private Id id;
	
	
	public Id getId() {
		return id;
	}
	
	public TipoPrimitivo getTipo(){
		return tipo;
	}



	public DeclaracaoAtributoStruct(TipoPrimitivo tipo, Id id){
		this.tipo = tipo;
		this.id = id;
	}



	@Override
	public AmbienteCompilacaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente)
			throws InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente) throws InstanciaStructNaoDeclaradaException,
			InstanciaStructJaDeclaradaException, StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}


}
