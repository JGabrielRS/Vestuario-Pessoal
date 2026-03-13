package bancoDados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Vector;

import backEnd.Look;
import backEnd.Uso;
import itensPack.Acessorio;
import itensPack.Calcado;
import itensPack.Item;
import itensPack.ParteBaixo;
import itensPack.ParteCima;
import itensPack.ParteIntima;

public class Ler {
	private Vector<Uso> usos = new Vector<>();
	private Vector<Vector<String[]>> vetor = new Vector<>();
	private Vector<Vector<Vector<String[]>>> vetorLook = new Vector<>();
	
	public Ler(String i) throws FileNotFoundException {
		try {
		String pathdir = "./bancoDeDados";
		String pathArquivo = pathdir + '/' + "dadosSalvos.txt";
		FileReader arquivoLido = new FileReader(pathArquivo);
		BufferedReader leitor = new BufferedReader(arquivoLido);
		String linha; 
		while ((linha = leitor.readLine()) != null) {
			String[] campos = linha.trim().split("\\|");
			Vector<String[]> conj = new Vector<String[]>();
			conj.add(campos);
			vetor.add(conj);
		}
		leitor.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Ler(int i) throws FileNotFoundException {
		try {
		String pathdir = "./bancoDeDados";
		String pathArquivo = pathdir + '/' + "looksSalvos.txt";
		FileReader arquivoLido = new FileReader(pathArquivo);
		BufferedReader leitor = new BufferedReader(arquivoLido);
		String linha; 
		Vector<Vector<String[]>> lookAtual = null;
		while ((linha = leitor.readLine()) != null) {
			linha = linha.trim();
			if(linha.equals("*")) {
				if(lookAtual != null) {
					vetorLook.add(lookAtual);
					lookAtual = null;
				} else {
					lookAtual = new Vector<>();
				}
			}else if (lookAtual != null) {
				String[] campos = linha.trim().split("\\|");
				Vector<String[]> conj = new Vector<>();
				conj.add(campos);
				lookAtual.add(conj);
			}
		}
		leitor.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void mostrarPecas() {
		for (int i = 0; i < vetor.size(); i++) {
			Vector<String[]> uni = vetor.get(i);
			System.out.println("Linha " + (i+1));
            for (int x = 0; x < uni.size(); x++) {
            	String[] campos = uni.get(x);
                for(int j = 0; j < campos.length; j++) {
                	System.out.println("Campo " + (j+1) + ": " + campos[j]);
                }
            }
        }
	}
	public void mostrarLook() {
		for (int i = 0; i < vetorLook.size(); i++) {
			Vector<Vector<String[]>> vetorgeral = vetorLook.get(i);
			System.out.println("Look " + (i+1));
			for(int j = 0; j < vetorgeral.size(); j++) {
				Vector<String[]> pecas = vetorgeral.get(j);
				System.out.println("Peça " + (j+1));
	            for (int x = 0; x < pecas.size(); x++) {
	            	String[] campos = pecas.get(x);
	                for(int k = 0; k < campos.length; k++) {
	                	System.out.println("Campo " + (k+1) + ": " + campos[k]);
	                }
	            }
			}
        }
	}
	public Item criarPecas(int i) {
		Vector<String[]> uni = vetor.get(i);
		String parte = null;
		String tipo = null;
		String cor = null;
		String tamanho = null;
		String lojaOrigem = null;
		String conservacao = null;
		String emprestado = null;
		LocalDate inEmp = null;
		LocalDate fimEmp = null;
		int qntLavagens = 0;
		int qntUso = 0;
        for (int x = 0; x < uni.size(); x++) {
        	String[] campos = uni.get(x);
            for(int j = 0; j < campos.length; j++) {
                if(j == 0) {
                	parte = campos[j];
                }
                if(j == 1) {
                	tipo = campos[j];
                }
                if(j == 2) {
                	cor = campos[j];
                }
                if(j == 3) {
                	tamanho = campos[j];
                }
                if(j == 4) {
                	lojaOrigem = campos[j];
                }
                if(j == 5) {
                	conservacao = campos[j];
                }
                if(j == 6) {
                	emprestado = campos[j];
                }
                if(j == 7) {
                	String dataStr = campos[j];
                	LocalDate data = null;
                	boolean sera = campos[j].equals("null");
                	if(!sera) {
                		data = LocalDate.parse(dataStr);
                	}
                	inEmp = data;
                }
                if(j == 8) {
                	String dataStr = campos[j];
                	LocalDate data = null;
                	boolean sera = campos[j].equals("null");
                	if(!sera) {
                		data = LocalDate.parse(dataStr);
                	}
                	fimEmp = data;
                }
                if(j == 9) {
                	int inteiro = 0;
                	boolean sera = campos[j].equals("null");
                	if(!sera) {
                		inteiro = Integer.parseInt(campos[j]);
                	}
                	qntLavagens = inteiro;
               }
               if (j == 10) {
            	   int inteiro = 0;
            	   boolean sera = campos[j].equals("null");
            	   if(!sera) {
            		   inteiro = Integer.parseInt(campos[j]);
            	   }
            	   qntUso = inteiro;
               } 
            }
       }
       if(parte.equals("ParteCima")) {
    	   Item item = new ParteCima(tipo,cor,tamanho,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntLavagens,qntUso);
    	   return item;
       }
       if(parte.equals("ParteBaixo")) {
    	   Item item = new ParteBaixo(tipo,cor,tamanho,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntLavagens,qntUso);
    	   return item;
       }
       if(parte.equals("Calcado") ) {
    	   Item item = new Calcado(tipo,cor,tamanho,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntLavagens,qntUso);
    	   return item;
       }
       if(parte.equals("ParteIntima")) {
    	   Item item = new ParteIntima(tipo,cor,tamanho,lojaOrigem,conservacao,qntLavagens,qntUso);
    	   return item;
       }
       if(parte.equals("Acessorio")) {
    	   Item item = new Acessorio(tipo,cor,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntUso);
    	   return item;
       }
       return null;
	}
	public Look criarLooks(int i) {
		Item parteCima = null;
		Item parteBaixo = null;
		Item calcado = null;
		Item acessorio = null;
		Item parteIntima = null;
		String nome = null;
		String parte = null;
		String tipo = null;
		String cor = null;
		String tamanho = null;
		String lojaOrigem = null;
		String conservacao = null;
		String emprestado = null;
		LocalDate inEmp = null;
		LocalDate fimEmp = null;
		int qntLavagens = 0;
		int qntUso = 0;
		String data = null;
		String local = null;
		String horario = null;
		int qntUsoLook = 0;
		Vector<Vector<String[]>> looks = vetorLook.get(i);
		for (int x = 0; x < looks.size(); x++) {
			Vector<String[]> uni = looks.get(x);
			String[] campos = uni.get(0);
			if(x == 0) {
				nome = campos[0];
			}
			if(x >= 1 && x<=5) {
				parte = campos[0];
				tipo = campos[1];
				cor = campos[2];
				tamanho = campos[3];
				lojaOrigem = campos[4];
				conservacao = campos[5];
				emprestado = campos[6];
				if(!campos[7].equals("null")) {
					inEmp = LocalDate.parse(campos[7]);
				}
				if(!campos[8].equals("null")) {
					fimEmp = LocalDate.parse(campos[8]);
				}
				if(!campos[9].equals("null")) {
					qntLavagens = Integer.parseInt(campos[9]);
				}
	            if(!campos[10].equals("null")) {
	            	qntUso = Integer.parseInt(campos[10]);
	            }
	           
		       if(parte.equals("ParteCima")) {
		    	   parteCima = new ParteCima(tipo,cor,tamanho,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntLavagens,qntUso);
		       }
		       else if(parte.equals("ParteBaixo")) {
		    	   parteBaixo = new ParteBaixo(tipo,cor,tamanho,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntLavagens,qntUso);
		       }
		       else if(parte.equals("Calcado") ) {
		    	   calcado = new Calcado(tipo,cor,tamanho,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntLavagens,qntUso);
		       }
		       else if(parte.equals("ParteIntima")) {
		    	   parteIntima = new ParteIntima(tipo,cor,tamanho,lojaOrigem,conservacao,qntLavagens,qntUso);
		       }
		       else if(parte.equals("Acessorio")) {
		    	   acessorio = new Acessorio(tipo,cor,lojaOrigem,conservacao,emprestado,inEmp,fimEmp,qntUso);
		       }
			}
		    if(x == 6) {
		    	qntUsoLook = Integer.parseInt(campos[0]);
		    }
		    else if(x > 6) {
		    	data = campos[0];
		    	horario = campos[1];
		    	local = campos[2];
		    	Uso usotemp = new Uso(data,horario,local);
		    	usos.add(usotemp);
		    }
		}
		Look looktemp = new Look(nome,parteCima,parteBaixo,calcado,acessorio,parteIntima,usos,qntUsoLook);
		return looktemp;
	}
	public int getTamVetorPeca() {
		return vetor.size();
	}
	public int getTamVetorLook() {
		return vetorLook.size();
	}
}
