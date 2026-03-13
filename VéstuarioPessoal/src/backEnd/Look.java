package backEnd;

import java.util.Vector;

import bancoDados.Salvar;
import itensPack.Acessorio;
import itensPack.Calcado;
import itensPack.Item;
import itensPack.ParteBaixo;
import itensPack.ParteCima;
import itensPack.ParteIntima;

public class Look {
	private String nome;
	private ParteCima parteCima;
	private ParteBaixo parteBaixo;
	private Calcado calcado;
	private Acessorio acessorio;
	private ParteIntima parteIntima;
	private	Vector<Uso> usos = new Vector<Uso>();
	private int qntUso;
	
	public Look (String nome, Item parteCima, Item parteBaixo, Item calcado) {
		this.nome = nome;
		ParteCima parteCima1 = (ParteCima) parteCima;
		this.parteCima = parteCima1;
		ParteBaixo parteBaixo1 = (ParteBaixo) parteBaixo;
		this.parteBaixo = parteBaixo1;
		Calcado calcado1 = (Calcado) calcado;
		this.calcado = calcado1;
	}
	public Look (String nome, Item parteCima, Item parteBaixo, Item calcado, Item acessorio, Item parteIntima) {
		this.nome = nome;
		ParteCima parteCima1 = (ParteCima) parteCima;
		ParteBaixo parteBaixo1 = (ParteBaixo) parteBaixo;
		Calcado calcado1 = (Calcado) calcado;
		Acessorio acessorio1 = (Acessorio) acessorio;
		ParteIntima parteIntima1 = (ParteIntima) parteIntima;
		this.parteCima = parteCima1;
		this.parteBaixo = parteBaixo1;
		this.calcado = calcado1;
		this.acessorio = acessorio1;
		this.parteIntima = parteIntima1;
		qntUso = usos.size();
	}
	public Look (String nome, Item parteCima, Item parteBaixo, Item calcado, Item acessorio, Item parteIntima, int qntUsos) {
		this.nome = nome;
		ParteCima parteCima1 = (ParteCima) parteCima;
		ParteBaixo parteBaixo1 = (ParteBaixo) parteBaixo;
		Calcado calcado1 = (Calcado) calcado;
		Acessorio acessorio1 = (Acessorio) acessorio;
		ParteIntima parteIntima1 = (ParteIntima) parteIntima;
		this.parteCima = parteCima1;
		this.parteBaixo = parteBaixo1;
		this.calcado = calcado1;
		this.acessorio = acessorio1;
		this.parteIntima = parteIntima1;
		qntUso = qntUsos;
	}
	public Look (String nome, Item parteCima, Item parteBaixo, Item calcado, Item acessorio, Item parteIntima,Vector<Uso> usos, int qntUsos) {
		this.nome = nome;
		ParteCima parteCima1 = (ParteCima) parteCima;
		ParteBaixo parteBaixo1 = (ParteBaixo) parteBaixo;
		Calcado calcado1 = (Calcado) calcado;
		Acessorio acessorio1 = (Acessorio) acessorio;
		ParteIntima parteIntima1 = (ParteIntima) parteIntima;
		this.parteCima = parteCima1;
		this.parteBaixo = parteBaixo1;
		this.calcado = calcado1;
		this.acessorio = acessorio1;
		this.parteIntima = parteIntima1;
		this.usos = usos;
		qntUso = qntUsos;
	}
	public String mostrarNome() {
		return nome;
	}
	public ParteCima mostrarParteCima() {
		return parteCima;
	}
	public ParteBaixo mostrarParteBaixo() {
		return parteBaixo;
	}
	public Calcado mostrarCalcado() {
		return calcado;
	}
	public Acessorio mostrarAcessorio() {
		return acessorio;
	}
	public ParteIntima mostrarParteIntima() {
		return parteIntima;
	}
	public void mudarParteCima(Item parteCimaNova) {
		ParteCima parteCima1 = (ParteCima) parteCimaNova;
		parteCima = parteCima1;
	}
	public void mudarParteBaixo(Item parteBaixoNova) {
		ParteBaixo parteBaixo1 = (ParteBaixo) parteBaixoNova;
		parteBaixo = parteBaixo1;
	}
	public void mudarCalcado(Item calcadoNovo) {
		Calcado calcado1 = (Calcado) calcadoNovo;
		calcado = calcado1;
	}
	public void mudarParteIntima(Item parteIntimaNova) {
		ParteIntima parteIntima1 = (ParteIntima) parteIntimaNova;
		parteIntima = parteIntima1;
	}
	public void mudarAcessorio(Item acessorioNovo) {
		Acessorio acessorio1 = (Acessorio) acessorioNovo;
		acessorio = acessorio1;
	}
	public void excluirUso(Uso uso) {
		usos.remove(uso);
	}
	public void mudarQntUso(int qntUso) {
		this.qntUso = qntUso;
	}
	public void registrarUso(String data, String horario, String local) {
		Uso uso = new Uso(data, horario, local);
		usos.add(uso);
		qntUso = usos.size();
	}
	public void registrarUso(Uso uso) {
		usos.add(uso);
	}
	public Uso procurarUso(String data, String horario) {
		boolean achado = false;
		int i;
		for(i = 0; i < usos.size(); i++) {
			if(usos.get(i).data == data && usos.get(i).horario.equals(data)) {
				achado = true;
				break;
			}
		}
		if(achado == false) {
			return null;
		}
		return usos.get(i);
		
	}
	public String getDataUso(String data, String horario) {
		Uso uso = procurarUso(data,horario);
		return uso.data;
	}
	public String getHorarioUso(String data, String horario) {
		Uso uso = procurarUso(data, horario);
		return uso.horario;
	}
	public String getLocalUso(String data, String horario) {
		Uso uso = procurarUso(data, horario);
		return uso.local;
	}
	public int getQntUso() {
		return qntUso;
	}
	public String getNome() {
		return nome;
	}
	public Vector<Uso> getUso() {
		return usos;
	}
	public void salvar() {
		Salvar salva = new Salvar(nome,parteCima,parteBaixo,calcado,acessorio,parteIntima,usos,qntUso);
		salva.salvarLook();
	}
}
