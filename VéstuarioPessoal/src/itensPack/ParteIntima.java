package itensPack;

import java.time.LocalDate;

import bancoDados.Salvar;
import interfacesPack.ILavavel;

public class ParteIntima extends Item implements ILavavel{
	
	public ParteIntima(String tipo) {
		super(tipo);
		this.tipo = tipo;
		cor = null;
		tamanho = null;
		lojaOrigem = null;
		conservacao = null;
		qntLavagens = 0;
	}
	public ParteIntima(String tipo, String cor, String tamanho, String lojaOrigem, String conservacao) {
		super(tipo);
		this.tipo = tipo;
		this.cor = cor;
		this.tamanho = tamanho;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
		qntLavagens = 0;
	}
	public ParteIntima(String tipo, String cor, String tamanho, String lojaOrigem, String conservacao, int qntLavagens, int qntUso) {
		super(tipo, cor, lojaOrigem, conservacao);
		this.parte = "ParteIntima";
		this.tipo = tipo;
		this.cor = cor;
		this.tamanho = tamanho;
		this.lojaOrigem = lojaOrigem;
		this.conservacao = conservacao;
		this.qntLavagens = qntLavagens;
		this.qntUso = qntUso;
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
	public void mudar_tamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getTamanho(){
		return tamanho;
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
		String emp = "Não Emprestado";
		return emp;
	}
	public LocalDate getInEmp() {
		return inEmp;
	}
	public LocalDate getFimEmp() {
		return fimEmp;
	}
	public void lavar() {
		qntLavagens++;
	}
	public int qntLavagens() {
		return qntLavagens;
	}
	public void registrarUso() {
		qntUso++;
	}
	public int getQntUso() {
		return qntUso;
	}
	public void salvar() {
		String emp = "null";
		Salvar salva = new Salvar(parte,tipo,cor,tamanho,lojaOrigem,conservacao,emp,inEmp,fimEmp,qntLavagens,qntUso);
		salva.salvarPartes();
	}
}
