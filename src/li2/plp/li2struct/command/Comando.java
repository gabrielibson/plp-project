package li2.plp.li2struct.command;

import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

/*
 * A execucao de um comando ocorre em um determinado ambiente. O
 * resultado de tal execucao � a modifica��o deste ambiente, i.e., comandos
 *tem efeito colateral.
 */


/**
 * Interface representando um comando na linguagem.
 */
public interface Comando{

    /**
     * Executa este comando.
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e valores.
     * @return o ambiente modificado pela execu��o do comando.
     */
    public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
               InstanciaStructJaDeclaradaException, InstanciaStructNaoDeclaradaException,
               ProcedimentoNaoDeclaradoException,ProcedimentoJaDeclaradoException,
               StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException;
    /**
     * Realiza a verificacao de tipos deste comando.
     *
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e tipos.
     * @return <code>true</code> se os comando s�o bem tipados;
     *          <code>false</code> caso contrario.
     */
    public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
        ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
        StructJaDeclaradaException, StructNaoDeclaradaException;

}

