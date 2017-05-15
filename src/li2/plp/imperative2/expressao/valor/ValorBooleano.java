package li2.plp.imperative2.expressao.valor;

import li2.plp.imperative2.exception.StructNaoDeclaradaException;
import li2.plp.imperative2.memory.AmbienteCompilacaoImperativa2;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;
import li2.plp.imperative2.util.Tipo;
import li2.plp.imperative2.util.TipoPrimitivo;


/**
 * Este valor primitivo encapsula um valor booleano.
 */
public class ValorBooleano implements ValorConcreto{

    private boolean valor;

    /**
     * Cria um objeto encapsulando o valor booleano fornecido.
     */
    public ValorBooleano(boolean valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor deste valor primitivo, i.e, ele mesmo.
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 amb) throws StructNaoDeclaradaException{
        return this;
    }

    /**
     * Retorna o valor booleano encapsulado pelo objeto do tipo <code>ValorBooleano</code>
     */
    public boolean valor() {
        return valor;
    }

    /**
     * Determina igualdade entre valores do tipo <code>ValorBooleano</code>
     */
    public boolean equals(ValorConcreto  obj){
    	if (obj instanceof ValorBooleano){
	        return valor == ((ValorBooleano) obj).valor();
    	} else {
    		return false;
    	}
    }

    /**
     * Retorna texto representando o valor booleano
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
    public boolean checaTipo(AmbienteCompilacaoImperativa2 amb) {
        return true;
    }

    /**
     * Retorna os tipos possiveis desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacaoImperativa2 amb) {
        return TipoPrimitivo.TIPO_BOOLEANO;
    }


}