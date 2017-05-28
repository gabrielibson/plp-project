package li2.plp.li2struct.expression.valor;

import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

/**
 * Objetos desta classe encapsulam valor inteiro.
 */
public class ValorInteiro implements ValorConcreto {

    private int valor;

    /**
     * Cria <code>ValorInteiro</code> contendo o valor fornecido.
     */
    public ValorInteiro(int valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor inteiro encapsulado pelo objeto deste tipo.
     */
    public int valor() {
        return valor;
    }

    /**
     * Retorna o valor deste valor primitivo, i.e., ele mesmo.
     */
    public Valor avaliar (AmbienteExecucaoli2Struct amb) throws StructNaoDeclaradaException {
        return this;
    }

    /**
     * Determina igualdade entre objetos deste tipo
     */
    public boolean equals(ValorConcreto obj) {
    	if (obj instanceof ValorInteiro){
    		return valor == ((ValorInteiro) obj).valor();
    	} else {
    		return false;
    	}
    }

    /**
     * Retorna texto representando o valor inteiro do objeto desta classe.
     */
    public String toString() {
        return String.valueOf(valor);
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
        return TipoPrimitivo.TIPO_INTEIRO;
    }
}
