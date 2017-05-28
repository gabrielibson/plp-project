package li2.plp.li2struct.expression.leftExpression;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;

public class Id extends li2.plp.expressions2.expression.Id implements LeftExpression{

	public Id(String strName) {
        super(strName);
    }

	public Valor avaliar(AmbienteExecucaoli2Struct ambiente) throws VariavelNaoDeclaradaException,
			VariavelJaDeclaradaException, InstanciaStructNaoDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}

	public Tipo getTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	public Id getId() {
		// TODO Auto-generated method stub
		return null;
/*import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.li2struct.excecao.declaracao.StructNaoDeclaradoException;
import li2.plp.li2struct.util.Tipo;

public class Id extends li2.plp.expressions2.expression.Id implements LeftExpression{
	
	public Id(String strName){
		super(strName);
	}
	
	public String toString(){
		return this.getIdName();
	}
	
	public Valor avaliar(AmbienteExecucaoImperativa2 ambiente) throws StructNaoDeclaradoException{
		return obterValorDeIdNoAmbiente(ambiente);
	}
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente){
		 boolean result = true;
	        ambiente.get(this); 
	        return result;
	}
	
	public Tipo getTipo(AmbienteCompilacaoImperativa ambiente) throws VariavelNaoDeclaradaException{
		return ambiente.get(this);
	}
	
	public Id getId(){
		return this;
	}
	
	public Valor obterValorDeIdNoAmbiente(AmbienteExecucaoImperativa2 ambiente) throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException{
		
		return ambiente.get(this);
		
>>>>>>> origin/arquivoJJ_karine_branch*/
	}
}
