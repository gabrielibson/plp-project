package li2.plp.li2struct.memory;


import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;



import java.util.HashMap;
import java.util.Stack;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.declaracao.procedimento.DefProcedimento;
import li2.plp.li2struct.declaracao.struct.DefStruct;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.util.Tipo;


public interface AmbienteExecucaoli2Struct extends AmbienteLi2Struct<Valor>{
	
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
    public HashMap<ValorRef, Instancia> getMapInstancias();

    /**
     * Mapeia um valor refer�ncia a um objeto.
     * @param valorRef Valor refer�ncia.
     * @param objeto Objeto.
     * @throws ObjetoJaDeclaradoException Quando esse objeto j� foi declarado.
     */
    public void mapInstancia(ValorRef valorRef, Instancia instancia) throws InstanciaStructJaDeclaradaException;

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
    public Instancia getInstancia(ValorRef valorRef) throws InstanciaStructNaoDeclaradaException;

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
    public AmbienteExecucaoli2Struct write(Valor v);

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
    public ContextoExecucaoli2struct getContextoIdValor();
    
    /**
     * Obt�m o valor associado a um determinado identificador.
     * @param idArg Identificador
     * @return o valor associado a um determinado identificador.
     * @throws VariavelNaoDeclaradaException Quando a vari�vel n�o foi
     * declarada.
     */
    public Valor getValor(Id idArg) throws VariavelNaoDeclaradaException;

}
