package li2.plp.imperative2.expressao.leftExpression;

import li2.plp.imperative2.expressao.Expressao;
/**
 * Classe que representa um acesso de atributo.
 */
public abstract class AcessoAtributo implements LeftExpression{

    /**
     * Identificador.
     */
    private Id id;
    /**
     * Construtor
     * @param id Identificador
     */
    public AcessoAtributo(Id id) {
        this.id = id;
    }
    /**
     * Obt�m o identificador.
     * @return o identificador.
     */
    public Id getId(){
        return id;
    }
    /**
     * Obt�m uma expressao
     * @return uma express�o.
     */
    public abstract Expressao getExpressaoObjeto();
}