package li2comStruct.plp.li2Struct.expressao.valor;

import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;
import li2comStruct.plp.li2Struct.util.Tipo;
import li2comStruct.plp.li2Struct.util.TipoStruct;

/**
 * Este valor primitivo encapsula um valor do tipo Null.
 */
public class ValorNull implements ValorConcreto {


    /**
     * Retorna texto representando o valor string do objeto desta classe.
     *
     * @return texto representando o valor string do objeto desta classe.
     */
    public String toString() {
      return "null";
    }

    /**
     * Determina igualdade entre  objetos desta classe
     */
    public boolean equals(ValorConcreto v){
        if ( v instanceof ValorNull)
              return true;
        else return false;
  }

    /**
     * Retorna ele mesmo.
     */
    public Valor avaliar(AmbienteExecucaoImperativa2 amb) throws ClasseNaoDeclaradaException {
        return this;
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
        return TipoStruct.TIPO_NULL;
    }
}