package li2comStruct.plp.li2Struct.declaracao.struct;

import li2comStruct.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2comStruct.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseJaDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoJaDeclaradoException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import li2comStruct.plp.li2Struct.memoria.AmbienteCompilacaoImperativa2;
import li2comStruct.plp.li2Struct.memoria.AmbienteExecucaoImperativa2;

/**
 * Classe representando a declara��o de mais de uma classe.
 */
public class DecClasseComposta implements DecClasse{
	/**
	 * Primeira declara��o de classe.
	 */
    private DecClasse declaracao1;
    /**
     * Segunda declara��o de classe, que pode ser simples ou composta.
     */
    private DecClasse declaracao2;
	/**
	 * Construtor.
	 * @param parametro1 Primeira declara��o de classe.
	 * @param parametro2 Segunda parte da declara��o de classe composta.
	 */
    public  DecClasseComposta(DecClasse declaracao1, DecClasse declaracao2){
        this.declaracao1 = declaracao1;
        this.declaracao2 = declaracao2;
    }
    /**
     * Cria um mapeamento do identificador para esta declara��o 
     * de classe no ambiente  de execucao
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e valores.
     * @return o ambiente modificado pela inicializa��o da classe.
     */
    public AmbienteExecucaoImperativa2 elabora(AmbienteExecucaoImperativa2 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               ClasseNaoDeclaradaException, ClasseJaDeclaradaException,
               ProcedimentoNaoDeclaradoException,ProcedimentoJaDeclaradoException{
        return declaracao2.elabora(declaracao1.elabora(ambiente));
    }
    /**
     * Verifica se a declara��o est� bem tipada, ou seja, se as duas
     * declara��es est�o bem tipadas
     * @param ambiente o ambiente que contem o mapeamento entre identificadores
     *  e seus tipos.
     * @return <code>true</code> se os tipos da declara��o s�o v�lidos;
     *          <code>false</code> caso contrario.
     */
    public boolean checaTipo(AmbienteCompilacaoImperativa2 ambiente)
        throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
        ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
        ProcedimentoNaoDeclaradoException,ProcedimentoJaDeclaradoException{
        return declaracao1.checaTipo(ambiente) && declaracao2.checaTipo(ambiente);
    }
}
