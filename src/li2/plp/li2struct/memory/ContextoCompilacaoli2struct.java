package li2.plp.li2struct.memory;

import java.util.HashMap;
import java.util.Stack;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.declaracao.procedimento.ListaDeclaracaoParametro;
import li2.plp.li2struct.declaracao.struct.DefStruct;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.util.Tipo;

/**
 * Representa o contexto de compila�ao.
 */
public class ContextoCompilacaoli2struct implements AmbienteCompilacaoli2Struct {

    /**
     * A pilha de tipos do contexto. Onde o tipo do id pode ser
     * um tipo primitivo ou uma classe.
     */
    private Stack<HashMap<Id, Tipo>> pilha;

    /**
     * A pilha de procedimentos do contexto.
     */
    private Stack<HashMap<Id, ListaDeclaracaoParametro>> pilhaProcedimento;


    /**
     * mapeamento de classes do contexto.
     * nao � necessaria uma pilha, pois ha apenas um nivel de mapeamentos
     */
    private HashMap<Id, DefStruct> mapDefStruct;  

     /**
     * A tail de valores inicias do contexto.
     */
    private ListaValor entrada;

    /**
     * O Construtor da classe.
     */
    public ContextoCompilacaoli2struct(ListaValor entrada){
        pilha = new Stack<HashMap<Id, Tipo>>();
        pilhaProcedimento = new Stack<HashMap<Id, ListaDeclaracaoParametro>>();
        mapDefStruct = new HashMap<Id, DefStruct>();  //cria mapeamento ids def structs
        this.entrada = entrada;
    }

    /**
     * Incrementa a pilha do ambiente, passando para o pr�ximo estado.
     */
    public void incrementa(){
        pilha.push(new HashMap<Id, Tipo>());
        pilhaProcedimento.push(new HashMap<Id, ListaDeclaracaoParametro>());
    }

    /**
     * Restaura o estado do ambiente.
     */
    public void restaura(){
        pilha.pop();
        pilhaProcedimento.pop();
    }
    /**
     * Mapeia um identificador a um tipo.
     * @param idArg Identificador
     * @param tipoId Tipo que deve ser associado ao identificador.
     * @throws VariavelJaDeclaradaException quando o id j� foi declarado.
     */
    public void map(Id idArg, Tipo tipoId)
        throws VariavelJaDeclaradaException {
        HashMap<Id, Tipo> aux = pilha.peek();
        if (aux.put(idArg, tipoId) != null) {
            throw new VariavelJaDeclaradaException(idArg);
        }
    }

    /**
     * Mapeia um identificador representando um m�todo aos seus par�metros.
     * @param idArg identificador do m�todo.
     * @param parametrosId Par�metros do m�todo
     * @throws ProcedimentoJaDeclaradoException quando o procedimento j� foi
     * declarado.
     */
    public void mapParametrosProcedimento(Id idArg, ListaDeclaracaoParametro parametrosId)
        throws ProcedimentoJaDeclaradoException {
        HashMap<Id, ListaDeclaracaoParametro> aux = pilhaProcedimento.peek();
        if (aux.put(idArg, parametrosId) != null) {
            throw new ProcedimentoJaDeclaradoException(idArg);
        }
    }

    /**
     * Mapeia um identificador a uma definição de struct.
     * @param idArg o nome da classe
     * @param defStruct Definição de Struct.
     * @throws ClasseJaDeclaradaException quando a classe j� foi declarada.
     */
    public void mapDefStruct(Id idArg, DefStruct defStruct)
        throws StructJaDeclaradaException {
        if (mapDefStruct.put(idArg, defStruct) != null) {
            throw new StructJaDeclaradaException(idArg);
        }
    }

    /**
     * Obt�m o tipo associado a um dado identificador
     * @param idArg Identificador
     * @return Tipo associado a um dado identificador
     * @throws VariavelNaoDeclaradaException quando id n�o foi declarado.
     */
    public Tipo get(Id idArg)
        throws VariavelNaoDeclaradaException {
        Tipo result = null;
        Stack<HashMap<Id, Tipo>> auxStack = new Stack<HashMap<Id, Tipo>>();
        while (result == null && !pilha.empty()) {
			HashMap<Id, Tipo> aux = pilha.pop();
            auxStack.push(aux);
            result = aux.get(idArg);
        }
        while (!auxStack.empty()) {
            pilha.push(auxStack.pop());
        }
        if (result == null) {
            throw new VariavelNaoDeclaradaException(idArg);
        } else {
            return result;
        }
    }

    /**
     * Obt�m a tail de par�metros associada a um identificador que representa
     * nome do m�todo.
     * @param idArg Identificador que representa o nome do m�todo.
     * @return Lista de par�metros Lista de par�metros associada a um identificador que representa
     * nome do m�todo.
     * @throws ProcedimentoNaoDeclaradoException quando n�o foi declarado nenhum
     * m�todo com esse id.
     */
    public ListaDeclaracaoParametro getParametrosProcedimento(Id idArg)
        throws ProcedimentoNaoDeclaradoException  {
        ListaDeclaracaoParametro result = null;
        Stack<HashMap<Id, ListaDeclaracaoParametro>> auxStack = new Stack<HashMap<Id, ListaDeclaracaoParametro>>();
        while (result == null && !pilhaProcedimento.empty()) {
            HashMap<Id, ListaDeclaracaoParametro> aux = pilhaProcedimento.pop();
            auxStack.push(aux);
            result = aux.get(idArg);
        }
        while (!auxStack.empty()) {
            pilhaProcedimento.push(auxStack.pop());
        }
        if (result == null) {
            throw new ProcedimentoNaoDeclaradoException(idArg);
        } else {
            return result;
        }
    }

    /**
     * Obt�m a defini��o da classe cujo nome � idArg
     * @param idArg Nome da classe.
     * @return a defini��o da classe.
     * @throws ClasseNaoDeclaradaException quando nao foi declarada nenhuma
     * classe com esse nome.
     */
    public DefStruct getDefStruct(Id idArg)
        throws StructNaoDeclaradaException  {
        DefStruct result = null;
        result = this.mapDefStruct.get(idArg);
        if (result == null) {
            throw new StructNaoDeclaradaException(idArg);
        } else {
            return result;
        }
    }

    /**
     * Obt�m o tipo da entrada atual para este ambiente.
     * @return o tipo da entrada.
     * @throws VariavelNaoDeclaradaException quando a entrada atual �
     * uma vari�vel n�o declarada.
     */
    public Tipo getTipoEntrada()
        throws VariavelNaoDeclaradaException {
        Tipo aux =  entrada.getHead().getTipo(this);
        entrada = (ListaValor)entrada.getTail();
        return aux;
    }
    
    /**
     * Obt�m o tipo associado a um dado identificador
     * @param idArg Identificador
     * @return Tipo associado a um dado identificador
     * @throws VariavelNaoDeclaradaException quando id n�o foi declarado.
     */
    public Tipo getTipo(Id idArg)
        throws VariavelNaoDeclaradaException {
        Tipo result = null;
        Stack<HashMap<Id, Tipo>> auxStack = new Stack<HashMap<Id, Tipo>>();
        while (result == null && !pilha.empty()) {
			HashMap<Id, Tipo> aux = pilha.pop();
            auxStack.push(aux);
            result = aux.get(idArg);
        }
        while (!auxStack.empty()) {
            pilha.push(auxStack.pop());
        }
        if (result == null) {
            throw new VariavelNaoDeclaradaException(idArg);
        } else {
            return result;
        }
    }
}

