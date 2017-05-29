package li2.plp.li2struct.expression.valor;

import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

/**
 * Este valor primitivo encapsula um String.
 */
public class ValorString implements ValorConcreto{

    private String valor;

    /**
     * cria um objeto encapsulando o String fornecido
     */
    public ValorString(String valor) {
        this.valor = valor;
    }

    /**
     * Retorna texto representando o valor string do objeto desta classe.
     *
     * @return texto representando o valor string do objeto desta classe.
     */
    public String toString() {
        return valor;
    }

    /**
     * Determina igualdade entre  objetos desta classe
     */
    public boolean equals(ValorConcreto obj){
    	if (obj instanceof ValorString){
	        return valor.equals( ((ValorString) obj).valor());
    	} else {
    		return false;
    	}    	
    }

    /**
     * Retorna o valor deste valor primitivo, i.e, ele mesmo.
     */
    public Valor avaliar(AmbienteExecucaoli2Struct amb) throws StructNaoDeclaradaException {
        return this;
    }

    /**
     * Retorna o string encapsulado pelo objeto desta classe
     */
    public String valor(){
        return valor;
    }

    /**
     * Realiza a verificacao de tipos desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return <code>true</code> se os tipos da expressao s�o v�lidos;
     *          <code>false</code> caso contrario.
     */
    public boolean checaTipo(AmbienteCompilacaoli2Struct amb) {
        return true;
    }

    /**
     * Retorna os tipos possiveis desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoli2Struct amb) {
        return TipoPrimitivo.TIPO_STRING;
    }
}
