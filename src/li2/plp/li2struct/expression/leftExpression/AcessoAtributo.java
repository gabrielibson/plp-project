package li2.plp.li2struct.expression.leftExpression;

import li2.plp.li2struct.expression.Expressao;

public abstract class AcessoAtributo implements LeftExpression{

	private Id id;
	
	public AcessoAtributo(Id id) {
        this.id = id;
    }

	public Id getId(){
		return id;
	}
	
	public abstract Expressao getExpressaoInstancia();

}
