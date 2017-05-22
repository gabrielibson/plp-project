package li2comStruct.plp.li2Struct.expressao.valor;

import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoPrimitivo;

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
    public Valor avaliar (AmbienteExecucaoImperativa2 amb) throws ClasseNaoDeclaradaException {
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
        return TipoPrimitivo.TIPO_INTEIRO;
    }

}
