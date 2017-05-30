package li2.plp.li2struct.command;

import java.io.BufferedReader;
import java.io.FileReader;
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

public class ReadFile implements IO {

	private Id idRetorno;
	private Valor key;
	private Valor fileName;

	public ReadFile(Id idRetorno, Valor key, Valor fileName) {
		this.idRetorno = idRetorno;
		this.key = key;
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
		// TODO Auto-generated method stub
		return true;
	}

	public String readingFile() throws IOException{
		String retorno = "";
		BufferedReader read;
		FileReader file = new FileReader(""+fileName.toString());
		read = new BufferedReader(file);
		String fileLine;
		String id;
		boolean isEndOfArq = false;

		while(!isEndOfArq){
			fileLine = read.readLine();

			if(fileLine != null){
				boolean pegaId = false;
				while(!pegaId){
					int fimid = fileLine.indexOf(" ");
					id = fileLine.substring(0, fimid).toString();

					if(id.equals(key)){
						fileLine = read.readLine();
						pegaId = true;
						retorno = fileLine;
					}
					fileLine = read.readLine();
				}

			}else{
				retorno = "Nao achamos a chave!!";
				isEndOfArq = true;
			}
		}
		read.close();
		return retorno;
	}


}
