package li2.plp.li2struct.declaracao.struct;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class DeclaracaoAtributoStruct{
	
	Id id;
	Tipo tipo;
	
	public DeclaracaoAtributoStruct(Id id, Tipo tipo){
		this.id = id;
		this.tipo = tipo;
	}
	
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente) 
			throws StructNaoDeclaradaException {
		return tipo.eValido(ambiente);
	}
	
	public AmbienteCompilacaoli2Struct elabora(
			AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.map(id, tipo);
		return ambiente;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}
