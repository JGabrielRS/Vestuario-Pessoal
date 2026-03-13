package bancoDados;

import java.io.FileWriter;
import java.io.IOException;

public class ExcluirTudo {
	private String caminhoPecas;
	private String caminhoLooks;
	public ExcluirTudo() {
		caminhoPecas = "./bancoDeDados/dadosSalvos.txt";
		caminhoLooks = "./bancoDeDados/looksSalvos.txt";
	}
	public void excluirLooks() {
		try(FileWriter excluidor = new FileWriter(caminhoLooks,false)){
		}catch(IOException e) {
			System.err.println("Erro ao excluir dados de " + e.getMessage());
		}
	}
	public void excluirPecas() {
		try(FileWriter excluidor = new FileWriter(caminhoPecas,false)){
		}catch(IOException e) {
			System.err.println("Erro ao excluir dados de " + e.getMessage());
		}
	}
}
