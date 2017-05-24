package li2.plp.li2struct.expression.leftExpression;

public class AcessoAtributoId extends AcessoAtributo{

	protected LeftExpression av;
	
	public AcessoAtributoId(LeftExpression av, Id id){
        super(id);
        this.av = av;
    }
	
	
}
