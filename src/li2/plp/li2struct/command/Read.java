package li2.plp.li2struct.command;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;

public class Read implements IO {

	private Id id;

	public Read(Id id) {
		this.id = id;
	}

	/**
	 * L� da entrada padr�o.
	 * 
	 * @param ambiente
	 *            o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do comando read.
	 * @throws ErroTipoEntradaException 
	 * 
	 */
	public AmbienteExecucaoImperativa executar(
			AmbienteExecucaoImperativa ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			EntradaVaziaException, ErroTipoEntradaException {
				
		Valor valorID = ambiente.get(id);
		Valor valorRead =ambiente.read();
		if (valorID.getTipo(null).eIgual(valorRead.getTipo(null))) {
			ambiente.changeValor(id, valorRead );
		}else{
			throw new ErroTipoEntradaException("Tipo do valor de entrada lido incomp�tivel" +
					" com tipo da vari�vel (" + id.getIdName() + ")");
		}
		
		
		
		
		return ambiente;
	}

	/**
	 * Realiza a verificacao de tipos da entrada
	 * 
	 * @param ambiente
	 *            o ambiente de compila��o.
	 * @return <code>true</code> se a express�o da entrada est� bem tipada;
	 *         <code>false</code> caso contrario.
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelNaoDeclaradaException, EntradaVaziaException,
			VariavelJaDeclaradaException {
		//return id.getTipo(ambiente).equals(ambiente.getTipoEntrada());
		return true;
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException, ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
			StructJaDeclaradaException, StructNaoDeclaradaException, EntradaInvalidaException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException, StructNaoDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}

}
