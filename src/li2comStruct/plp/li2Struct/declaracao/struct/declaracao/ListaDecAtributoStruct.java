package li2comStruct.plp.li2Struct.declaracao.struct.declaracao;

/**
 * Classe representando a declara��o de mais de uma classe.
 */
public class ListaDecAtributoStruct {
	
	private DeclaracaoAtributoStruct declaracaoAtributoStruct;
	private ListaDecAtributoStruct listaDecAttStruct;
	
	public ListaDecAtributoStruct(DeclaracaoAtributoStruct declaracaoAtributoStruct) {
		super();
		this.declaracaoAtributoStruct = declaracaoAtributoStruct;
	}

	public ListaDecAtributoStruct(DeclaracaoAtributoStruct declaracaoAtributoStruct, 
			ListaDecAtributoStruct listaDecAttStruct) {
		super();
		this.declaracaoAtributoStruct = declaracaoAtributoStruct;
		this.listaDecAttStruct = listaDecAttStruct;
	}
	
	
	public ListaDecAtributoStruct() {
		// TODO Auto-generated constructor stub
	}
	
	
}
