package li2.plp.imperative2.memory;

import java.util.HashMap;
import java.util.Stack;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.expression.valor.ValorRef;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.ListaValor;
import li2.plp.imperative2.declaration.DefProcedimento;
import li2.plp.imperative2.exception.InstanciaStructJaDeclaradoException;
import li2.plp.imperative2.exception.InstanciaStructNaoDeclaradoException;
import li2.plp.imperative2.exception.execucao.EntradaInvalidaException;
import li2.plp.imperative2.expressao.valor.Valor;
import li2.plp.imperative2.util.Tipo;


public interface AmbienteExecucaoImperativa2 extends AmbienteExecucaoImperativa {

	public void mapProcedimento(Id idArg, DefProcedimento procedimentoId)
			throws ProcedimentoJaDeclaradoException;

	public DefProcedimento getProcedimento(Id idArg)
			throws ProcedimentoNaoDeclaradoException;

	
	/**
     * Obt�m a pilha de valores associados a identificadores
     * @return a pilha de valores associados a identificadores.
     */
	public Stack<HashMap<Id, Valor>> getPilha();

    /**
     * Retorna a pilha com as defini�oes das classes.
     * @return a pilha com as defini�oes das classes.
     */
    public HashMap<Id, DefStruct> getMapDefStruct();

    /**
     * Obt�m o mapeamento com os objetos e seus valores.
     * @return o mapeamento com os objetos e seus valores.
     */
    public HashMap<ValorRef, InstanciaStruct> getMapInstancias();

    /**
     * Mapeia um valor refer�ncia a um objeto.
     * @param valorRef Valor refer�ncia.
     * @param objeto Objeto.
     * @throws ObjetoJaDeclaradoException Quando esse objeto j� foi declarado.
     */
    public void mapStruct(ValorRef valorRef, InstanciaStruct instanciaStruct) throws InstanciaStructJaDeclaradoException;

    /**
     * Altera o valor associado a um identificador.
     * @param idArg Identificador.
     * @param valorId O valor a ser associado ao identificador.
     * @throws VariavelNaoDeclaradaException Quando a vari�vel n�o foi
     * declarada.
     */
    public void changeValor(Id idArg, Valor valorId) throws VariavelNaoDeclaradaException;

    /**
     * Obt�m o objeto associado a um dado valor referencia.
     * @param valorRef Valor refer�ncia
     * @return o objeto associado a um dado valor referencia.
     * @throws ObjetoNaoDeclaradoException Quando o objeto n�o foi declarado.
     */
    public InstanciaStruct getInstanciaStruct(ValorRef valorRef) throws InstanciaStructNaoDeclaradoException;

    /**
     * Obt�m a pr�xima refer�ncia de acordo com o contexto atual de execu��o.
     * @return a pr�xima refer�ncia de acordo com o contexto atual de execu��o.
     */
    public ValorRef getProxRef();

    /**
     * Obt�m o valor referencia atual.
     * @return o  valor referencia atual.
     */
    public ValorRef getRef();

    /**
     * L� da entrada padr�o e associa o conte�do a um determinado identificador.
     * @param tipoIdLido Tipo do identificador ao qual ser� associado o valor
     * lido.
     * @return o valor lido.
     * @throws EntradaInvalidaException Quando a entrada fornecida n�o pode
     * ser atribu�da ao tipo do identificador.
     */
    public Valor read(Tipo tipoIdLido) throws EntradaInvalidaException;

    /**
     * Escreve um valor 'v' na sa�da.
     * @param v O valor a ser escrito.
     * @return o ambiente de execu��o, que representa o estado atual.
     */
    public AmbienteExecucaoImperativa2 write(Valor v);

    /**
     * Obt�m a entrada.
     * @return a entrada.
     */
    public ListaValor getEntrada();

    /**
     * Obt�m a sa�da.
     * @return a sa�da.
     */
    public ListaValor getSaida();

    /**
     * Obt�m um novo contexto de execu��o com a mesma entrada, sa�da e pilha
     * de mapeamentos id/valor.
     * @return um novo contexto de execu��o com a mesma entrada, sa�da e pilha
     * de mapeamentos id/valor.
     */
    public ContextoExecucaoImperativa2 getContextoIdValor();
    
    /**
     * Obt�m o valor associado a um determinado identificador.
     * @param idArg Identificador
     * @return o valor associado a um determinado identificador.
     * @throws VariavelNaoDeclaradaException Quando a vari�vel n�o foi
     * declarada.
     */
    public Valor getValor(Id idArg) throws VariavelNaoDeclaradaException;
}
