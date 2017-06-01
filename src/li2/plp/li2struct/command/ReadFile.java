package li2.plp.li2struct.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoStruct;

public class ReadFile implements IO {

	private Id id;
	private Valor key;
	private Valor fileName;
	
	private HashMap<String, Tipo> idTipo;
	
	private static final String PATHNAME = "D:/workspace/";
	private static final String EXTENSAO = ".txt";
	
	private String tipoStruct;
	
	public ReadFile(Id id, Valor key, Valor file) {
		this.id = id;
		this.key = key;
		this.fileName = file;
		
		this.idTipo = new HashMap<String, Tipo>();
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException, EntradaInvalidaException {
		
		//ValorRef vr = (ValorRef) ambiente.get(id);
		this.lerRegistro(ambiente);
		return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException {
		boolean retorno = false;
		File file = new File(PATHNAME + fileName.toString() + EXTENSAO);
		if(!file.exists()){
			return false;
		}else{
			BufferedReader br;
			String [] att;
			try {
				br = new BufferedReader(new FileReader(file));
				if(br.ready()){
					tipoStruct = br.readLine();
					if(tipoStruct.equals(ambiente.get(id).getTipo().getIdName())){
						att = this.getAtributos(br);
						this.idTipo.put(att[0], ambiente.get(new Id(att[0])));
						retorno = true;
					}
					br.close();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retorno;
	}

	
	private void lerRegistro(AmbienteExecucaoli2Struct ambiente) throws EntradaInvalidaException{
		File file = new File(PATHNAME + fileName.toString() + EXTENSAO);
		if(!file.exists()){
			throw new EntradaInvalidaException("Arquivo não existe!");
		}else{
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				while(br.ready()){
					br.readLine();
					String [] att = this.getAtributos(br);
					montarRegistro(ambiente, att);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void montarRegistro(AmbienteExecucaoli2Struct ambiente, String[] valores){
		String [] att;
		for(String atributo : valores){
			att = atributo.split("=");
			Id id = new Id(att[0]);
			Tipo tipo = this.idTipo.get(att[1]);
			if(tipo instanceof TipoStruct){
				ValorRef valorRef = ambiente.getProxRef();
				ambiente.map(id, valorRef);
			}else {
				//TipoPrimitivo tp = (TipoPrimitivo)tipo;
				/*if(this.idTipo.get(att[1] instanceof )){
					
				}*/
			}
			
		}
	}
	
	private String[] getAtributos(BufferedReader br){
		String [] atributos = {};
		try {
			String [] strAux;
			String pk;
			while(br.ready()){
				String linha = br.readLine();
				strAux = linha.split("\\{");
				pk = strAux[0];
				if(pk.equals(key)){
					strAux[1] = strAux[1].replaceAll("//}", "");
					atributos = strAux[1].split(",");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return atributos;
	}
}
