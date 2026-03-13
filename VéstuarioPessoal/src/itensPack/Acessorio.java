package itensPack;

import java.time.LocalDate;

import bancoDados.Salvar;
import interfacesPack.IEmprestavel;

public class Acessorio extends Item implements IEmprestavel{
	
	public Acessorio(String tipo) {
		super(tipo);
		this.tipo = tipo;
		cor = null;
		lojaOrigem = null;
		conservacao = null;
		inEmp = null;
		fimEmp = null;
	}
	public Acessorio(String tipo, String cor, String lojaOrigem, String conservacao) {
		super(tipo);
		this.tipo = tipo;
		this.cor = cor;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
		inEmp = null;
		fimEmp = null;
	}
	public Acessorio(String tipo, String cor, String lojaOrigem, String conservacao, int qntUso) {
		super(tipo, cor, lojaOrigem, conservacao);
		this.parte = "Acessorio";
		this.tipo = tipo;
		this.cor = cor;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
		this.qntUso = qntUso;
		this.emprestado = false;
		this.inEmp = null;
		this.fimEmp = null;
	}
	public Acessorio(String tipo, String cor, String lojaOrigem, String conservacao, String emprestado, LocalDate inEmp, LocalDate fimEmp, int qntUso) {
		super(tipo, cor, lojaOrigem, conservacao);
		this.parte = "Acessorio";
		this.tipo = tipo;
		this.cor = cor;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
		this.qntUso = qntUso;
		if(emprestado.equals("Emprestado")) {
			this.emprestado = true;
		}else {
			this.emprestado = false;
		}
		this.inEmp = inEmp;
		this.fimEmp = fimEmp;
	}
	public String getParte() {
		return parte;
	}
	public String getTipo(){
		return tipo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void mudar_cor(String cor) {
		this.cor = cor;
	}
	public String getCor(){
		return cor;
	}
	public void mudar_lojaOrigem(String lojaOrigem) {
		this.lojaOrigem = lojaOrigem;
	}
	public String getLojaOrigem(){
		return lojaOrigem;
	}
	public void mudar_conservacao(String conservacao) {
		this.conservacao = conservacao;
	}
	public String getConservacao(){
		return conservacao;
	}
	public String getEmprestado(){
		String emp;
		if(emprestado) {
			emp = "Emprestado";
		}else {
			emp = "Não Emprestado";
		}
		return emp;
	}
	public LocalDate getInEmp() {
		return inEmp;
	}
	public LocalDate getFimEmp() {
		return fimEmp;
	}
	public int getQntLavagens() {
		return qntLavagens;
	}
	public void registrarEmprestimo(){
		this.inEmp = LocalDate.now();
		emprestado = true;
	}
	public int quantidadeDeDiasDesdeOEmprestimo(){
		int inAno = this.inEmp.getYear();
		int inMes = this.inEmp.getMonthValue();
		int inDia = this.inEmp.getDayOfMonth();
		LocalDate agr = LocalDate.now();
		int agrAno = agr.getYear();
		int agrMes = agr.getMonthValue();
		int agrDia = agr.getDayOfMonth();
		int dias = agrDia - inDia;
		int meses = (agrMes - inMes) * 31;
		int anos = (agrAno - inAno)* 365;
		int total = dias + meses + anos;
		return total;
	}
	public void registrarDevolução(){
		fimEmp = LocalDate.now();
		emprestado = false;
	}
	public void registrarUso() {
		qntUso++;
	}
	public int getQntUso() {
		return qntUso;
	}
	public void salvar() {
		String emp;
		if(emprestado) {
			emp = "Emprestado";
		}else {
			emp = "Não Emprestado";
		}
		Salvar salva = new Salvar(parte,tipo,cor,tamanho,lojaOrigem,conservacao,emp,inEmp, fimEmp, qntLavagens, qntUso);
		salva.salvarPartes();
	}
}
