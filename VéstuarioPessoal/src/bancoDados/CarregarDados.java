package bancoDados;

import java.io.FileNotFoundException;
import java.util.Vector;
import backEnd.Look;
import itensPack.Item;

public class CarregarDados {
	public static Vector<Item> carregarItens() throws FileNotFoundException {
        Ler leituraPecas = new Ler("pecas");
        Vector<Item> itens = new Vector<>();
        for(int i = 0; i < leituraPecas.getTamVetorPeca(); i++) {
			itens.add(leituraPecas.criarPecas(i));
		}
        return itens;
    }

    public static Vector<Look> carregarLooks() throws FileNotFoundException {
		Ler leituraLooks = new Ler(2);
    	Vector<Look> looks = new Vector<>();
		for(int i= 0; i < leituraLooks.getTamVetorLook(); i++) {
			looks.add(leituraLooks.criarLooks(i));
		}
        return looks;
    }
    
    public static Vector<Item> filtrarPorTipo(Vector<Item> itens, String parte) {
        Vector<Item> filtrados = new Vector<>();
		for(int i = 0; i < itens.size(); i++) {
			if(itens.get(i).parte.equals(parte)) {
				filtrados.add(itens.get(i));
			}
		}
        return filtrados;
    }
}
