package estatisticaPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import itensPack.Item;

public class ParteBaixoMaisUsada extends JFrame{
	Vector<Item> parteBaixo;
	public ParteBaixoMaisUsada(String titulo,Vector<Item> parteBaixo) {
        super(titulo);
        this.parteBaixo = parteBaixo;
        Item maisUsadoItem = null;
        int maiorUsoItem = 0;
        JPanel panePrincipal = new JPanel(new BorderLayout());
        setContentPane(panePrincipal);
        
        // Painel Esquerdo 
        JPanel panelEsquerdo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20); 
        gbc.anchor = GridBagConstraints.CENTER;    
        
        // Painel Central
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 20, 10, 20);
        gbc2.anchor = GridBagConstraints.CENTER;
        
        for(int i = 0; i < parteBaixo.size(); i++) {
			if(parteBaixo.get(i).getQntUso() > maiorUsoItem) {
				maisUsadoItem = parteBaixo.get(i);
				maiorUsoItem = parteBaixo.get(i).getQntUso();
			}
		}
        ImageIcon ft_maiscalca = new ImageIcon("./imagens/calca_maisusada.png");
        Image imagemRedim2 = ft_maiscalca.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscalca_redim = new ImageIcon(imagemRedim2);
     
        if(maisUsadoItem != null) {
	        // foto e tipo
	        JLabel ft_parteCima = new JLabel(maiscalca_redim, SwingConstants.CENTER);
	        ft_parteCima.setPreferredSize(new Dimension(200, 200));
	        
	        JLabel nome_parteCima = new JLabel(maisUsadoItem.getTipo(), SwingConstants.CENTER);
	        nome_parteCima.setPreferredSize(new Dimension(200,50));
	        nome_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        // Componentes
	        JLabel cor = new JLabel("cor:", SwingConstants.CENTER);
	        cor.setPreferredSize(new Dimension(200, 50));  // Tamanho fixo para imagem
	        
	        JLabel conservacao = new JLabel("conservação:", SwingConstants.CENTER);
	        conservacao.setPreferredSize(new Dimension(200, 50));
	        
	        JLabel tamanho = new JLabel("tamanho:", SwingConstants.CENTER);
	        tamanho.setPreferredSize(new Dimension(200, 50));
	
	        JLabel qntLavagem = new JLabel("quantidade de lavagens:", SwingConstants.CENTER);
	        qntLavagem.setPreferredSize(new Dimension(200, 50));
	        
	        JLabel lojaOrigem = new JLabel("loja de origem:", SwingConstants.CENTER);
	        lojaOrigem.setPreferredSize(new Dimension(200, 50));
	        
	        JLabel qntUso = new JLabel("quantidade de usos:", SwingConstants.CENTER);
	        qntUso.setPreferredSize(new Dimension(200, 50));
	        
	        JLabel cor_parteCima = new JLabel(maisUsadoItem.getCor(), SwingConstants.CENTER);
	        cor_parteCima.setPreferredSize(new Dimension(100, 50));
	        cor_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel conservacao_parteCima = new JLabel(maisUsadoItem.getConservacao(), SwingConstants.CENTER);
	        conservacao_parteCima.setPreferredSize(new Dimension(100, 50));
	        conservacao_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel tamanho_parteCima = new JLabel(maisUsadoItem.getTamanho(), SwingConstants.CENTER);
	        tamanho_parteCima.setPreferredSize(new Dimension(100, 50));
	        tamanho_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	
	        JLabel qntLavagem_parteCima = new JLabel(Integer.toString(maisUsadoItem.getQntLavagem()), SwingConstants.CENTER);
	        qntLavagem_parteCima.setPreferredSize(new Dimension(100, 50));
	        qntLavagem_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel lojaOrigem_parteCima = new JLabel(maisUsadoItem.getLojaOrigem(), SwingConstants.CENTER);
	        lojaOrigem_parteCima.setPreferredSize(new Dimension(100, 50));
	        lojaOrigem_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel qntUso_parteCima = new JLabel(Integer.toString(maisUsadoItem.getQntUso()), SwingConstants.CENTER);
	        qntUso_parteCima.setPreferredSize(new Dimension(100, 50));
	        qntUso_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        // Adicionar imagem
	        gbc.gridy = 0;
	        
	        gbc.gridx = 0;
	        panelEsquerdo.add(ft_parteCima, gbc);
	        
	        // Adicionar tipo
	        gbc.gridy = 1;
	        
	        gbc.gridx = 0;
	        panelEsquerdo.add(nome_parteCima, gbc);
	        
	        // Adicionar nomes 
	        gbc2.gridy = 0;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(cor, gbc2);
	        
	        gbc2.gridx = 1;
	        panelCentral.add(conservacao, gbc2);
	        
	        gbc2.gridy = 2;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(tamanho, gbc2);
	        
	        gbc2.gridx = 1;
	        panelCentral.add(qntLavagem, gbc2);
	        
	        gbc2.gridy = 4;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(lojaOrigem, gbc2);
	        
	        gbc2.gridx = 1;
	        panelCentral.add(qntUso, gbc2);
	        
	        // Adicionar campos preenchidos
	        gbc2.gridy = 1;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(cor_parteCima, gbc2);
	        
	        gbc2.gridx = 1;
	        panelCentral.add(conservacao_parteCima, gbc2);
	        
	        gbc2.gridy = 3;
	                
	        gbc2.gridx = 0;
	        panelCentral.add(tamanho_parteCima, gbc2);
	        
	        gbc2.gridx = 1;
	        panelCentral.add(qntLavagem_parteCima, gbc2);
	        
	        gbc2.gridy = 5;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(lojaOrigem_parteCima, gbc2);
	        
	        gbc2.gridx = 1;
	        panelCentral.add(qntUso_parteCima, gbc2);
	        
	        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
	        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        }else {
        	JLabel X = new JLabel("ft de um X", SwingConstants.CENTER);
	        X.setPreferredSize(new Dimension(200, 200));
	        X.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        JLabel nome_parteCima = new JLabel("Não Existe Parte de Cima mais Usada!", SwingConstants.CENTER);
	        nome_parteCima.setPreferredSize(new Dimension(200,50));
	        nome_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        gbc.gridy = 0;
	        gbc.gridx = 0;
	        panelEsquerdo.add(X, gbc);
	        gbc.gridy = 1;	        
	        gbc.gridx = 0;
	        panelEsquerdo.add(nome_parteCima, gbc);
        }
        pack();
        setVisible(true);
    }
}
