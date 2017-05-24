package li2.plp.imperative2.expressao.leftExpression;

import li2.plp.imperative1.command.Atribuicao;
import li2.plp.imperative1.command.Comando;
/**
 * Representa uma express�o que fica do lado esquerdo de uma atribui��o ou
 * antes de uma chamada de m�todo.
 */
public interface LeftExpression extends Comando{
    /**
     * Obt�m o identificador dessa expressao.
     * @return o identificador dessa expressao. No caso de um acesso de atributo,
     * � o pr�prio atributo acessado. No caso de um Id, � ele mesmo.
     */
    abstract public Id getId();
}