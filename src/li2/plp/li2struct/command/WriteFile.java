package li2.plp.li2struct.command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import li2.plp.li2struct.expression.valor.ValorRef;
import li2.plp.li2struct.memory.AmbienteCompilacaoli2Struct;
import li2.plp.li2struct.memory.AmbienteExecucaoli2Struct;
import li2.plp.li2struct.memory.ContextoInstancia;
import li2.plp.li2struct.memory.Instancia;
import li2.plp.li2struct.util.Tipo;
import li2.plp.li2struct.util.TipoStruct;

public class WriteFile implements IO{

	private Id idRegistro;
	private Valor fileName;
	private static final String PATHNAME = "D:/workspace/";
	private static final String EXTENSAO = ".txt";
	private FileWriter fw = null;
	Tipo tipo;
	
	public WriteFile(Id id, Valor file) {
		this.idRegistro = id;
		this.fileName = file;
	}

	public AmbienteExecucaoli2Struct executar(AmbienteExecucaoli2Struct ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			InstanciaStructJaDeclaradaException,
			InstanciaStructNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException, EntradaInvalidaException {
		
		ValorRef vr = (ValorRef) ambiente.get(idRegistro);
		Instancia instancia = ambiente.getMapInstancias().get(vr);
		ContextoInstancia valoresInstancia = instancia.getEstado();
		if(this.verificaIntegridadeChave(valoresInstancia, vr)){
			this.escreverRegistro(valoresInstancia);
		}else{
			throw new EntradaInvalidaException("Violação de Chave Primária");
		}
		
		return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoli2Struct ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, StructJaDeclaradaException,
			StructNaoDeclaradaException {
		this.tipo = ambiente.get(idRegistro);
		if(tipo instanceof TipoStruct){
			return true;
		}
		else{
			return false;
		}
	}

	private void escreverRegistro(ContextoInstancia hashValores) throws EntradaInvalidaException{
		 try {
			File file = new File(PATHNAME+fileName.toString()+EXTENSAO);
			if(!file.exists()){
				fw = new FileWriter(file, true);
				BufferedWriter buffWrite = new BufferedWriter(fw);
				buffWrite.append(tipo.getTipo().getIdName());
				buffWrite.newLine();
				buffWrite.close();
			}
			fw = new FileWriter(file, true);
			BufferedWriter buffWrite = new BufferedWriter(fw);
			Id chave = new Id("chave");
			Valor valor = hashValores.getEstado().get(chave);
			if(valor == null){
				throw new EntradaInvalidaException("Atributo chave não declarado!");
			}
			String indice = valor.toString();
			buffWrite.append(indice);
			hashValores.getEstado().remove(chave, valor);
			buffWrite.append(hashValores.getEstado().toString());
			buffWrite.newLine();
			buffWrite.close();
			System.out.println("Registro salvo com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean verificaIntegridadeChave(ContextoInstancia hashValores, ValorRef valorRef)
			throws EntradaInvalidaException{
		boolean retorno = true;
		File file = new File(PATHNAME+fileName.toString()+EXTENSAO);
		if(file.exists()){
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				if(verificarTipoStructNoArquivo(br, valorRef)){
					Id chave = new Id("chave");
					Valor valor = hashValores.getEstado().get(chave);
					String indice = valor.toString();
					String [] strAux;
					String pk;
					while(br.ready()){
						String linha = br.readLine();
						strAux = linha.split("\\{");
						pk = strAux[0];
						if(pk.equals(indice)){
							retorno = false;
							break;
						}
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
			
		}else{
			retorno = true;
		}
		return retorno;
	}
	
	private boolean verificarTipoStructNoArquivo(BufferedReader br, ValorRef valorRef) 
			throws EntradaInvalidaException{
		boolean retorno = false;
		try {
			if(br.ready()){
				String linha = br.readLine();
				if(linha.equals(this.tipo.getTipo().getIdName())){
					retorno = true;
				}else{
					throw new EntradaInvalidaException("Tipo da struct não se aplica ao tipo do arquivo");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public Id getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Id idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Valor getFileName() {
		return fileName;
	}

	public void setFileName(Valor fileName) {
		this.fileName = fileName;
	}

}
