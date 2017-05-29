package li2.plp.li2struct.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

import li2.plp.expressions2.memory.Contexto;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.declaracao.procedimento.DefProcedimento;
import li2.plp.li2struct.declaracao.struct.DefStruct;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.expression.valor.ValorBooleano;
import li2.plp.li2struct.expression.valor.ValorInteiro;
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.expression.valor.ValorString;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoPrimitivo;

public class ContextoExecucaoli2struct implements AmbienteExecucaoli2Struct {

    /**
	 * A pilha de blocos de contexto.
	 */
    private Stack<HashMap<Id, Valor>> pilha;

    /**
	 * o Mapeamento de classes do contexto.
	 */
    private HashMap<Id, DefStruct> mapDefStruct;

    /**
	 * o mapeamento de objetos do contexto.
	 */

    private HashMap<ValorRef, InstanciaStruct> mapInstancias;

    /**
	 * A pilha de blocos de contexto.
	 */
    private ListaValor entrada;

    /**
	 * A pilha de blocos de contexto.
	 */
    private ListaValor saida;

    /**
	 * A refer�ncia do objeto a ser inserido na pilha de objetos
	 */
    private ValorRef proxRef;
    
    private Contexto<DefProcedimento> contextoProcedimentos;

    /**
	 * Construtor utilizado quando queremos ler do teclado.
	 */
    public ContextoExecucaoli2struct(){
        pilha = new Stack<HashMap<Id, Valor>>();

        mapInstancias = new HashMap<ValorRef, InstanciaStruct>();              	

        mapDefStruct = new HashMap<Id, DefStruct>();    // criacao do mapeamento de classes
        
        this.entrada = null;
        this.saida = new ListaValor();
        this.contextoProcedimentos = new Contexto<DefProcedimento>();
    }

    /**
	 * Construtor da classe.
	 */
    public ContextoExecucaoli2struct(AmbienteExecucaoli2Struct ambiente) throws VariavelJaDeclaradaException{
       proxRef = ambiente.getRef();
       this.mapInstancias = ambiente.getMapInstancias();
       this.mapDefStruct = ambiente.getMapDefStruct();
       this.entrada = ambiente.getEntrada();
       this.saida = ambiente.getSaida();
  }

    /**
	 * Construtor.
	 * 
	 * @param entrada
	 *            Entrada para o contexto de execu��o.
	 */
    public ContextoExecucaoli2struct(ListaValor entrada){
        pilha = new Stack<HashMap<Id, Valor>>();

        mapInstancias = new HashMap<ValorRef, InstanciaStruct>();       

        mapDefStruct = new HashMap<Id, DefStruct>();    // inicializacao do map
        
        this.entrada = entrada;
        this.saida = new ListaValor();
        contextoProcedimentos = new Contexto<DefProcedimento>();
    }

    /**
	 * Obt�m a pilha de valores associados a identificadores
	 * 
	 * @return a pilha de valores associados a identificadores.
	 */
    public Stack<HashMap<Id, Valor>> getPilha(){
       return this.pilha;
    }
    
    public void setPilha(Stack<HashMap<Id, Valor>> pilha) {
		this.pilha = pilha;
	}

	public void setSaida(ListaValor saida) {
		this.saida = saida;
	}    

    /**
	 * Retorna a pilha com as defini�oes das classes.
	 * 
	 * @return a pilha com as defini�oes das classes.
	 */
    public HashMap<Id, DefStruct> getMapDefStruct(){
       return this.mapDefStruct;
    }

    /**
	 * Obt�m o mapeamento com os objetos e seus valores.
	 * 
	 * @return o mapeamento com os objetos e seus valores.
	 */
    public HashMap<ValorRef, InstanciaStruct> getMapInstancias(){
       return this.mapInstancias;
    }

    /**
	 * L� da entrada padr�o e associa o conte�do a um determinado identificador.
	 * 
	 * @param tipoIdLido
	 *            Tipo do identificador ao qual ser� associado o valor lido.
	 * @return o valor lido.
	 * @throws EntradaInvalidaException
	 *             Quando a entrada fornecida n�o pode ser atribu�da ao tipo do
	 *             identificador.
	 */
    public Valor read(Tipo tipoIdLido) throws EntradaInvalidaException {
      String valorLido = leEntrada();
      if (valorLido!=null){
        valorLido = valorLido.trim();
        if (tipoIdLido instanceof TipoPrimitivo){
            TipoPrimitivo tipo = (TipoPrimitivo) tipoIdLido;
            try {
              if (tipo.eBooleano()){
                  return new ValorBooleano(Boolean.parseBoolean(valorLido));
              } else if (tipo.eInteiro()){
                  return new ValorInteiro(Integer.parseInt(valorLido));
              } else if (tipo.eString()){
                  return new ValorString(valorLido);
              }
            }
            catch(NumberFormatException e){
              throw new EntradaInvalidaException("O tipo da entrada e o da vari�vel"+
                                                 " a ser lida s�o diferentes!");
            }
        }
      }
      throw new EntradaInvalidaException("O tipo da vari�vel a ser lida n�o � um tipo Primitivo!");
    }

    /**
	 * Este m�todo l� uma entrada que pode ser de uma tail ou do teclado
	 * 
	 * @return Obt�m uma entrada que pode ser de uma tail ou do teclado
	 * @exception Lan�a
	 *                uma exce��o se a tail com os valores nao tiver mais
	 *                elementos.
	 */
    private String leEntrada() throws EntradaInvalidaException{
      if(this.entrada==null) {
        return leDaEntradaPadrao();
      } else {
        // Se nao tivermos mais nada na tail de valores
        if(entrada.length()==0) {
          throw new EntradaInvalidaException("N�mero de argumentos menor do que o n�mero de reads!");
        }
        return leDaListaValor();
      }
    }
    /**
	 * Este m�todo l� da entrada padr�o
	 * 
	 * @return o que o usu�rio digitou na entrada padr�o
	 */
    private String leDaEntradaPadrao(){
      try {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
      }
      catch (IOException e){
         System.out.println("Erro no valor lido da entrada padr�o");
      }
      return "";
    }

    /**
	 * Este m�todo l� da entrada padr�o
	 * 
	 * @return o que o usu�rio digitou na entrada padr�o
	 */
    private String leDaListaValor(){
      String retorno = entrada.getHead().toString();
      entrada = (ListaValor)entrada.getTail();
      return retorno;
    }

    /**
	 * Obt�m a sa�da.
	 * 
	 * @return a sa�da.
	 */
    public ListaValor getSaida() {
        return saida;
    }

    /**
	 * Obt�m a entrada.
	 * 
	 * @return a entrada.
	 */
    public ListaValor getEntrada(){
        return entrada;
    }

    /**
	 * Escreve um valor 'v' na sa�da.
	 * 
	 * @param v
	 *            O valor a ser escrito.
	 * @return o ambiente de execu��o, que representa o estado atual.
	 */
    public AmbienteExecucaoli2Struct write(Valor v){
        saida.write(v);
        return this;
    }
    /**
	 * Incrementa a pilha do ambiente, passando para o pr�ximo estado.
	 */
    public void incrementa() {
        pilha.push(new HashMap<Id, Valor>());
        this.contextoProcedimentos.incrementa();
        // pilhaDefClasse.push(new HashIdDefClasse()); // s� incrementa no
		// construtor
        // pilhaObjeto.push(new HashValorObjeto()); // s� incrementa no
		// construtor
    }

    /**
	 * Restaura o estado do ambiente.
	 */
    public void restaura(){
        pilha.pop();
        this.contextoProcedimentos.restaura();
        // pilhaDefClasse.pop(); // n�o restaura
        // pilhaObjeto.pop(); // n�o restaura
    }

    /**
	 * Mapeia um identificador a um valor.
	 * 
	 * @param idArg
	 *            Identificador.
	 * @param valorId
	 *            Valor que vai ser associado ao identificador.
	 * @throws VariavelJaDeclaradaException
	 *             Quando a vari�vel j� foi declarada.
	 */
    public void map(Id idArg, Valor valorId)
        throws VariavelJaDeclaradaException {
		HashMap<Id, Valor> aux = pilha.peek();
        if (aux.put(idArg, valorId) != null) {
            throw new VariavelJaDeclaradaException(idArg);
        }

    }

    /**
	 * Mapeia um identificador a um defini��o de classe.
	 * 
	 * @param idArg
	 *            o nome da classe
	 * @param defClasse
	 *            Defini��o da Classe.
	 * @throws ClasseJaDeclaradaException
	 *             quando a classe j� foi declarada.
	 */
    public void mapDefStruct(Id idArg, DefStruct defStruct)
        throws StructJaDeclaradaException {
		if (this.mapDefStruct.put(idArg, defStruct) != null) {
            throw new StructJaDeclaradaException(idArg);
        }
    }

    /**
	 * Mapeia um valor refer�ncia a um objeto.
	 * 
	 * @param valorRef
	 *            Valor refer�ncia.
	 * @param instancia
	 *            Objeto.
	 * @throws ObjetoJaDeclaradoException
	 *             Quando esse objeto j� foi declarado.
	 */
     public void mapInstancia(ValorRef valorRef, InstanciaStruct instancia)
        throws InstanciaStructJaDeclaradaException{
        if (this.mapInstancias.put(valorRef, instancia) != null) {
            throw new InstanciaStructJaDeclaradaException(instancia.getIdInstancia());
        }
    }

    /**
	 * Altera o valor associado a um identificador.
	 * 
	 * @param idArg
	 *            Identificador.
	 * @param valorId
	 *            O valor a ser associado ao identificador.
	 * @throws VariavelNaoDeclaradaException
	 *             Quando a vari�vel n�o foi declarada.
	 */
    public void changeValor(Id idArg, Valor valorId)
        throws VariavelNaoDeclaradaException {
        Valor result = null;
        Stack<HashMap<Id, Valor>> auxStack = new Stack<HashMap<Id, Valor>>();
        boolean found = false;
        while (result == null && !pilha.empty()) {
			HashMap<Id, Valor> aux = pilha.pop();
            auxStack.push(aux);
            if (aux.containsKey(idArg)) {
            	aux.remove(idArg);
            	aux.put(idArg, valorId);
            	found = true;
            	break;
            }
        }
        while (!auxStack.empty()) {
            pilha.push(auxStack.pop());
        }
        if (!found) {
            throw new VariavelNaoDeclaradaException(idArg);
        }
    }

    /**
	 * Obt�m o valor associado a um determinado identificador.
	 * 
	 * @param idArg
	 *            Identificador
	 * @return o valor associado a um determinado identificador.
	 * @throws VariavelNaoDeclaradaException
	 *             Quando a vari�vel n�o foi declarada.
	 */
    public Valor get( Id idArg )
        throws VariavelNaoDeclaradaException {
        Valor result = null;
        Stack<HashMap<Id, Valor>> auxStack = new Stack<HashMap<Id, Valor>>();
        while (result == null && !pilha.empty()) {
            HashMap<Id, Valor> aux = pilha.pop();
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
	 * Obt�m a defini��o da classe cujo nome � idArg
	 * 
	 * @param idArg
	 *            Nome da classe.
	 * @return a defini��o da classe.
	 * @throws ClasseNaoDeclaradaException
	 *             quando nao foi declarada nenhuma classe com esse nome.
	 */
    public DefStruct getDefStruct(Id idArg)
        throws StructNaoDeclaradaException  {
        DefStruct result = null;
        result = this.mapDefStruct.get(idArg);
        return result;
    }

    /**
	 * Obt�m o objeto associado a um dado valor referencia.
	 * 
	 * @param valorRef
	 *            Valor refer�ncia
	 * @return o objeto associado a um dado valor referencia.
	 * @throws ObjetoNaoDeclaradoException
	 *             Quando o objeto n�o foi declarado.
	 */
    public InstanciaStruct getInstancia(ValorRef valorRef)
        throws InstanciaStructNaoDeclaradaException{
        InstanciaStruct result = null;
        result = mapInstancias.get(valorRef);
        if (result == null) {
            throw new InstanciaStructNaoDeclaradaException(new Id(valorRef.toString()));
        } else {
            return result;
        }
    }

    /**
	 * Obt�m a pr�xima refer�ncia de acordo com o contexto atual de execu��o.
	 * 
	 * @return a pr�xima refer�ncia de acordo com o contexto atual de execu��o.
	 */
    public ValorRef getProxRef() {
        ValorRef aux = new ValorRef(proxRef.valor());
        proxRef = proxRef.incrementa();
        return aux;
    }

    /**
	 * Obt�m o valor referencia atual.
	 * 
	 * @return o valor referencia atual.
	 */
    public ValorRef getRef() {
        if (proxRef == null)
            proxRef = new ValorRef(ValorRef.VALOR_INICIAL);
          return proxRef;
    }

    /**
	 * Retorna a representa��o textual do contexto de execu��o.
	 * 
	 * @return a representa��o textual do contexto de execu��o.
	 */
    public String toString() {
        String resposta = null;
        Valor valor = null;
        InstanciaStruct instancia = null;
        Stack<HashMap<Id, Valor>> auxStack = new Stack<HashMap<Id, Valor>>();

        while (!pilha.empty()) {
			HashMap<Id, Valor> aux = pilha.pop();
            auxStack.push(aux);
			for (Id id : aux.keySet()) {
                valor = aux.get(id);
                resposta = id + " " + valor + "\n";
            }
        }
        while (!auxStack.empty()) {
            pilha.push(auxStack.pop());
        }

        for(ValorRef valorRef : this.mapInstancias.keySet()) {
        	instancia = this.mapInstancias.get(valorRef);
            resposta = valorRef + " " + instancia + "\n";
        }
        
        return resposta;
    }

    /**
	 * Obt�m um novo contexto de execu��o com a mesma entrada, sa�da e pilha de
	 * mapeamentos id/valor.
	 * 
	 * @return um novo contexto de execu��o com a mesma entrada, sa�da e pilha
	 *         de mapeamentos id/valor.
	 */
    public ContextoExecucaoli2struct getContextoIdValor() {
        ContextoExecucaoli2struct ambiente = new ContextoExecucaoli2struct(this.getEntrada());
        ambiente.pilha = this.pilha;
        ambiente.saida = this.saida;
        return ambiente;
    }
    
    /**
	 * Obt�m o valor associado a um determinado identificador.
	 * 
	 * @param idArg
	 *            Identificador
	 * @return o valor associado a um determinado identificador.
	 * @throws VariavelNaoDeclaradaException
	 *             Quando a vari�vel n�o foi declarada.
	 */
    public Valor getValor( Id idArg )
        throws VariavelNaoDeclaradaException {
        Valor result = null;
        Stack<HashMap<Id, Valor>> auxStack = new Stack<HashMap<Id, Valor>>();
        while (result == null && !pilha.empty()) {
            HashMap<Id, Valor> aux = pilha.pop();
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

	public void mapProcedimento(Id idArg, DefProcedimento procedimentoId) throws ProcedimentoJaDeclaradoException {
		try {
			this.contextoProcedimentos.map(idArg, procedimentoId);
		} catch (VariavelJaDeclaradaException e) {
			throw new ProcedimentoJaDeclaradoException(idArg);
		}
	}

	public DefProcedimento getProcedimento(Id idArg) throws ProcedimentoNaoDeclaradoException {
		try {
			return this.contextoProcedimentos.get(idArg);
		} catch (VariavelNaoDeclaradaException e) {
			throw new ProcedimentoNaoDeclaradoException(idArg);
		}

	}

	@Override
	public void mapDefStruct(li2.plp.expressions2.expression.Id idArg, DefStruct defStruct)
			throws StructJaDeclaradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DefStruct getDefStruct(li2.plp.expressions2.expression.Id idArg) throws StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void map(li2.plp.expressions2.expression.Id idArg, Valor tipoId) throws VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Valor get(li2.plp.expressions2.expression.Id idArg) throws VariavelNaoDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}



}