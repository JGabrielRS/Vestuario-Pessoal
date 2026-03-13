package criarPack;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import bancoDados.ExcluirTudo;
import itensPack.Item;
import itensPack.ParteIntima;

public class criarParteIntima extends JFrame{
	private JTextArea adicionar_tipo;
	private JTextArea adicionar_cor;
    private JTextArea adicionar_conservacao;
    private JTextArea adicionar_tamanho;
    private JTextArea adicionar_qntLavagem;
    private JTextArea adicionar_lojaOrigem;
    private JTextArea adicionar_qntUso;
	public criarParteIntima(String titulo, Vector<Item> itens) {
		super(titulo);
        
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
        
        // Painel Direito
        JPanel panelDireito = new JPanel(new GridBagLayout());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(10, 20, 10, 20);
        gbc3.anchor = GridBagConstraints.CENTER;
       
        ImageIcon ft_cueca = new ImageIcon("./imagens/cueca.png");
        Image imagemRedim = ft_cueca.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon cueca_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_disquete = new ImageIcon("./imagens/disquete.png");
        imagemRedim = ft_disquete.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon disquete_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_parteCima = new JLabel(cueca_redim, SwingConstants.CENTER);
        ft_parteCima.setPreferredSize(new Dimension(200, 200));
        
        JLabel tipo = new JLabel("tipo:", SwingConstants.CENTER);
        tipo.setPreferredSize(new Dimension(200, 50));
        adicionar_tipo = new JTextArea();
        adicionar_tipo.setPreferredSize(new Dimension(100, 50));
        adicionar_tipo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_tipo.setAlignmentX(SwingConstants.CENTER);
        adicionar_tipo.setText("ex: Cueca");
        
        // Componentes
        JLabel cor = new JLabel("cor:", SwingConstants.CENTER);
        cor.setPreferredSize(new Dimension(200, 50)); 
        
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
        
        // caixas de textos
        adicionar_cor = new JTextArea();
        adicionar_cor.setPreferredSize(new Dimension(100, 50));
        adicionar_cor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_cor.setAlignmentX(SwingConstants.CENTER);
        adicionar_cor.setText("ex: Verde");
         
        adicionar_conservacao = new JTextArea();
        adicionar_conservacao.setPreferredSize(new Dimension(100, 50));
        adicionar_conservacao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_conservacao.setAlignmentX(SwingConstants.CENTER);
        adicionar_conservacao.setText("ex: Usada");

        adicionar_tamanho = new JTextArea();
        adicionar_tamanho.setPreferredSize(new Dimension(100, 50));
        adicionar_tamanho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_tamanho.setAlignmentX(SwingConstants.CENTER);
        adicionar_tamanho.setText("ex: M");
         
        adicionar_qntLavagem = new JTextArea();
        adicionar_qntLavagem.setPreferredSize(new Dimension(100, 50));
        adicionar_qntLavagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_qntLavagem.setAlignmentX(SwingConstants.CENTER);
        
        adicionar_lojaOrigem = new JTextArea();
        adicionar_lojaOrigem.setPreferredSize(new Dimension(100, 50));
        adicionar_lojaOrigem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_lojaOrigem.setAlignmentX(SwingConstants.CENTER);
        adicionar_lojaOrigem.setText("ex: Adidas");

        adicionar_qntUso = new JTextArea();
        adicionar_qntUso.setPreferredSize(new Dimension(100, 50));
        adicionar_qntUso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adicionar_qntUso.setAlignmentX(SwingConstants.CENTER);
        
        JLabel disquete = new JLabel(disquete_redim, SwingConstants.CENTER);
        disquete.setPreferredSize(new Dimension(100,100));
        JButton salvar = new JButton("Salvar alterações");
        
        salvar.addActionListener(e -> salvarAlteracoes(itens));
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_parteCima, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(tipo, gbc);
        
        gbc.gridy = 2;
    
        gbc.gridx = 0;
        panelEsquerdo.add(adicionar_tipo, gbc);
        
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
        panelCentral.add(adicionar_cor, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(adicionar_conservacao, gbc2);
        
        gbc2.gridy = 3;
                
        gbc2.gridx = 0;
        panelCentral.add(adicionar_tamanho, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(adicionar_qntLavagem, gbc2);
        
        gbc2.gridy = 5;
        
        gbc2.gridx = 0;
        panelCentral.add(adicionar_lojaOrigem, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(adicionar_qntUso, gbc2);
        
        // adicionar botao de salvar peça
        gbc3.gridy = 0;
        
        gbc3.gridx = 0;
        panelDireito.add(disquete,gbc3);
        gbc3.gridx = 1;
        panelDireito.add(salvar,gbc3);
        
        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        panePrincipal.add(panelDireito, BorderLayout.EAST);
        pack();
        setVisible(true);
	}
	
	private void salvarAlteracoes(Vector<Item> itens) {
		try {
			String novoTipo = adicionar_tipo.getText();
			String novaCor = adicionar_cor.getText();
			String novaConservacao = adicionar_conservacao.getText();
			String novoTamanho = adicionar_tamanho.getText();
			int novaQntLavagem = Integer.parseInt(adicionar_qntLavagem.getText());
            String novaLojaOrigem = adicionar_lojaOrigem.getText();
            int novaQntUso = Integer.parseInt(adicionar_qntUso.getText());
            Item novoParteIntima = new ParteIntima(novoTipo,novaCor,novoTamanho,novaLojaOrigem,novaConservacao,novaQntLavagem,novaQntUso);
			ExcluirTudo excluidor = new ExcluirTudo();
			itens.add(novoParteIntima);
			excluidor.excluirPecas();
			for(int i = 0; i < itens.size(); i++) {
				itens.get(i).salvar();
			}
			this.dispose();
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro de formato!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao criar a peça :"+e.getMessage());
		}
	}
}
