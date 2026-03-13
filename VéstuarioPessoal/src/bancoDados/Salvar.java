package bancoDados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Vector;

import backEnd.Uso;
import itensPack.Acessorio;
import itensPack.Calcado;
import itensPack.ParteBaixo;
import itensPack.ParteCima;
import itensPack.ParteIntima;

public class Salvar{
	public String nome;
	public String parte;
	public String tipo;
	public String cor;
	public String tamanho;
	public String lojaOrigem;
	public String conservacao;
	public String emprestado;
	public Vector<Uso> usos = new Vector<Uso>();
	public int qntLavagens;
	public int qntUso;
	public LocalDate inEmp;
	public LocalDate fimEmp;
	public ParteCima parteCima;
	public ParteBaixo parteBaixo;
	public Calcado calcado;
	public Acessorio acessorio;
	public ParteIntima parteIntima;
	
	public Salvar(String parte,String tipo, String cor, String tamanho, String lojaOrigem, String conservacao, String emprestado, LocalDate inEmp, LocalDate fimEmp, int qntLavagens, int qntUso) {
		this.parte = parte;
		this.tipo = tipo;
		this.cor = cor;
		this.tamanho = tamanho;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
		this.emprestado = emprestado;
		this.inEmp = inEmp;
		this.fimEmp = fimEmp;
		this.qntLavagens = qntLavagens;
		this.qntUso = qntUso;
	}
	public Salvar(String nome, ParteCima parteCima, ParteBaixo parteBaixo, Calcado calcado, Acessorio acessorio, ParteIntima parteIntima, Vector<Uso> usos, int qntUso) {
		this.nome = nome;
		this.parteCima = parteCima;
		this.parteBaixo = parteBaixo;
		this.calcado = calcado;
		this.acessorio = acessorio;
		this.parteIntima = parteIntima;
		this.usos = usos;
		this.qntUso = qntUso;
	}
	public void salvarPartes() {
		String pathdir = "./bancoDeDados";
		File diretorio = new File(pathdir);
		if(!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		try {
			String pathArquivo = pathdir + '/' + "dadosSalvos.txt";
			FileWriter arquivo = new FileWriter(pathArquivo, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println( parte + '|' + tipo +'|' + cor +'|' + tamanho +'|' + lojaOrigem +'|' + conservacao +'|' + emprestado + '|' + inEmp + '|' + fimEmp + '|' + qntLavagens + '|' + qntUso + '|' );
			gravador.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}	}
	public void salvarLook() {
		String pathdir = "./bancoDeDados";
		File diretorio = new File(pathdir);
		if(!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		try {
			String pathArquivo = pathdir + '/' + "looksSalvos.txt";
			FileWriter arquivo = new FileWriter(pathArquivo, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("*");
			gravador.println(nome);
			gravador.println( parteCima.getParte() + '|' + parteCima.getTipo() +'|' + parteCima.getCor() +'|' + parteCima.getTamanho() +'|' + parteCima.getLojaOrigem() +'|' + parteCima.getConservacao() +'|' + parteCima.getEmprestado() + '|' + parteCima.getInEmp() + '|' + parteCima.getFimEmp() + '|' + parteCima.qntLavagens()+ '|' + parteCima.getQntUso()+ '|' );
			gravador.println( parteBaixo.getParte() + '|' + parteBaixo.getTipo() +'|' + parteBaixo.getCor() +'|' + parteBaixo.getTamanho() +'|' + parteBaixo.getLojaOrigem() +'|' + parteBaixo.getConservacao() +'|' + parteBaixo.getEmprestado() + '|' + parteBaixo.getInEmp() + '|' + parteBaixo.getFimEmp() + '|' + parteBaixo.qntLavagens()+ '|' + parteBaixo.getQntUso()+ '|'  );
			gravador.println( calcado.getParte() + '|' + calcado.getTipo() +'|' + calcado.getCor() +'|' + calcado.getTamanho() +'|' + calcado.getLojaOrigem() +'|' + calcado.getConservacao() +'|' + calcado.getEmprestado() + '|' + calcado.getInEmp() + '|' + calcado.getFimEmp() + '|' + calcado.qntLavagens()+ '|' + calcado.getQntUso() + '|' );
			gravador.println( acessorio.getParte() + '|' + acessorio.getTipo() +'|' + acessorio.getCor() +'|' + acessorio.getTamanho() +'|' + acessorio.getLojaOrigem() +'|' + acessorio.getConservacao() +'|' + acessorio.getEmprestado() + '|' + acessorio.getInEmp() + '|' + acessorio.getFimEmp() + '|' + acessorio.getQntLavagens()+ '|' + acessorio.getQntUso() + '|');
			gravador.println( parteIntima.getParte() + '|' + parteIntima.getTipo() +'|' + parteIntima.getCor() +'|' + parteIntima.getTamanho() +'|' + parteIntima.getLojaOrigem() +'|' + parteIntima.getConservacao() +'|' + parteIntima.getEmprestado() + '|' + parteIntima.getInEmp() + '|' + parteIntima.getFimEmp() + '|' + parteIntima.qntLavagens()+ '|' + parteIntima.getQntUso()+ '|'  );
			gravador.println(qntUso);
			for(int i = 0; i < usos.size(); i++) {
				Uso usotemp = usos.get(i);
				gravador.println(usotemp.data + '|' + usotemp.horario + '|' + usotemp.local);
			}
			gravador.println("*");
			gravador.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
