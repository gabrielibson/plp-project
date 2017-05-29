package li2.plp.li2struct.declaracao;

import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

public interface Declaracao {

	public AmbienteCompilacaoli2Struct elabora(AmbienteExecucaoli2Struct ambiente) throws 
	InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException, 
	StructJaDeclaradaException, StructNaoDeclaradaException;
	
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente) throws 
	InstanciaStructNaoDeclaradaException, InstanciaStructJaDeclaradaException, 
	StructJaDeclaradaException, StructNaoDeclaradaException;
}
