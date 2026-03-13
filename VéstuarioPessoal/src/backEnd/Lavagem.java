package backEnd;

import interfacesPack.ILavavel;
import itensPack.Calcado;
import itensPack.Item;
import itensPack.ParteBaixo;
import itensPack.ParteCima;
import itensPack.ParteIntima;

public class Lavagem implements ILavavel{
	protected String nome;
	protected ParteCima parteCima;
	protected ParteBaixo parteBaixo;
	protected Calcado calcado;
	protected ParteIntima parteIntima;
	
	public Lavagem(Item parteCima, Item parteBaixo, Item calcado, Item parteIntima) {
		this.parteCima = (ParteCima) parteCima;
		this.parteBaixo = (ParteBaixo) parteBaixo;
		this.calcado = (Calcado) calcado;
		this.parteIntima = (ParteIntima) parteIntima;
	}
	public void lavar() {
		parteCima.lavar();
		parteBaixo.lavar();
		calcado.lavar();
		parteIntima.lavar();
	}
	public int qntLavagens() {
		return 0;
	}
}
