package itensPack;

import java.time.LocalDate;

import bancoDados.Salvar;

public abstract class Item {
	public String parte = null;
	protected String tipo;
	protected String cor;
	protected String lojaOrigem;
	protected String conservacao;
	protected boolean emprestado = false;
	protected LocalDate inEmp;
	protected LocalDate fimEmp;
	protected int qntLavagens = 0;
	protected int qntUso = 0;
	protected String tamanho = null;
	
	public Item(String tipo) {
		this.tipo = tipo;
		cor = null;
		lojaOrigem = null;
		conservacao = null;
	}
	public Item(String tipo, String cor, String lojaOrigem, String conservacao) {
		this.tipo = tipo;
		this.cor = cor;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
	}
	public String getParte() {
		return parte;
	}
	public String getTipo(){
		return tipo;
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
	public void registrarUso() {
		qntUso++;
	}
	public int getQntUso() {
		return qntUso;
	}
	public int getQntLavagem() {
		return qntLavagens;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void mudarTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public void mudarQntLavagem(int qntLavagens) {
		this.qntLavagens = qntLavagens;
	}
	public void mudarQntUso(int qntUso) {
		this.qntUso = qntUso;
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
	public void salvar() {
		String emp;
		if(emprestado) {
			emp = "Emprestado";
		}else {
			emp = "Não Emprestado";
		}
		Salvar salva = new Salvar(parte,tipo,cor,tamanho,lojaOrigem,conservacao,emp,inEmp,fimEmp,qntLavagens,qntUso);
		salva.salvarPartes();
	}
}
