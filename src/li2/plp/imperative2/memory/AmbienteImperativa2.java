package li2.plp.imperative2.memory;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.Ambiente;
import li2.plp.imperative2.exception.StructJaDeclaradaException;
import li2.plp.imperative2.exception.StructNaoDeclaradaException;

/**
 * Interface que representa um ambiente.
 */
public interface AmbienteImperativa2<T> extends Ambiente<T>{
	
	/**
	 * Mapeia um identificador a um defini��o de classe.
	 * 
	 * @param idArg
	 *            o nome da classe
	 * @param defStruct
	 *            Defini��o da Struct.
	 * @throws ClasseJaDeclaradaException
	 *             quando a classe j� foi declarada.
	 */
	public void mapDefStruct(Id idArg, DefStruct defStruct)
			throws StructJaDeclaradaException;

	/**
	 * Obt�m a defini��o da classe cujo nome � idArg
	 * 
	 * @param idArg
	 *            Nome da classe.
	 * @return a defini��o da classe.
	 * @throws ClasseNaoDeclaradaException
	 *             quando nao foi declarada nenhuma classe com esse nome.
	 */
	public DefStruct getDefStruct(Id idArg) throws StructNaoDeclaradaException;
	
	
}