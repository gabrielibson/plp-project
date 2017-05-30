package li2.plp.li2struct.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.memory.ProcedimentoJaDeclaradoException;
import li2.plp.imperative2.memory.ProcedimentoNaoDeclaradoException;
import li2.plp.li2struct.exception.EntradaInvalidaException;
import li2.plp.li2struct.exception.InstanciaStructJaDeclaradaException;
import li2.plp.li2struct.exception.InstanciaStructNaoDeclaradaException;
import li2.plp.li2struct.exception.StructJaDeclaradaException;
import li2.plp.li2struct.exception.StructNaoDeclaradaException;
import li2.plp.li2struct.expression.leftExpression.Id;
import li2.plp.li2struct.expression.valor.Valor;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.TipoStruct;

public class WriteFile implements IO{

	private Id idInstancia;
	private Valor fileName;

	public WriteFile(Id idInstancia, Valor fileName) {
		this.idInstancia = idInstancia;
		this.fileName = fileName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException, EntradaInvalidaException {
		// TODO Auto-generated method stub


		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException {

		boolean resultado = false;
		if (ambiente.getTipo(idInstancia) instanceof TipoStruct){
			try {
				escrevendoArquivo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultado = true;
		}
		return resultado;
	}

	public void escrevendoArquivo() throws IOException{
		FileWriter fWriter = new FileWriter(""+fileName.toString());
		BufferedWriter writer = new BufferedWriter(fWriter);
		String valoresInstanciados = getValoresInstanciados().toString();

		writer.append(valoresInstanciados + "\n");
		writer.close();
	}

	//NESSE MÉTODO PEGAREMOS OS VALORES INSTANCIADOS DA STRUCT DECLARADA
	public String getValoresInstanciados(){
		String retorno = "1, 2, 3";
		return retorno;
	}

}
