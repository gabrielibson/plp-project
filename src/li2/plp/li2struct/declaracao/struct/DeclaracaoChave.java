package li2.plp.li2struct.declaracao.struct;

import li2.plp.li2struct.expression.leftExpression.Id;

public class DeclaracaoChave {
	
	Integer decChave;
	
	public DeclaracaoChave(Integer decChave){
		this.decChave = decChave;
	}

	public DeclaracaoChave(Id id) {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getDecChave(){
		return decChave;
	}

}
