package li2.plp.li2struct.expression.leftExpression;

public class AcessoAtributo implements LeftExpression{

	private Id id;
	
	public AcessoAtributo(Id id) {
        this.id = id;
    }

	public Id getId(){
		return id;
	}

}
