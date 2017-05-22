package li2comStruct.plp.li2Struct.memoria;

import li2comStruct.plp.expressions2.expression.Id;
import li2comStruct.plp.expressions2.memory.Ambiente;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseJaDeclaradaException;
import li2comStruct.plp.li2Struct.excecao.declaracao.ClasseNaoDeclaradaException;

/**
 * Interface que representa um ambiente.
 */
public interface AmbienteImperativa2<T> extends Ambiente<T>{
	
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
	public void mapDefClasse(Id idArg, DefStruct defClasse)
			throws ClasseJaDeclaradaException;

	/**
	 * Obt�m a defini��o da classe cujo nome � idArg
	 * 
	 * @param idArg
	 *            Nome da classe.
	 * @return a defini��o da classe.
	 * @throws ClasseNaoDeclaradaException
	 *             quando nao foi declarada nenhuma classe com esse nome.
	 */
	public DefStruct getDefClasse(Id idArg) throws ClasseNaoDeclaradaException;
	
	
}