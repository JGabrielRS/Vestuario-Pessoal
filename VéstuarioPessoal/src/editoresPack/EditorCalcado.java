package editoresPack;

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

public class EditorCalcado extends JFrame{
	private Item calcado;
	private JTextArea editar_cor;
    private JTextArea editar_conservacao;
    private JTextArea editar_tamanho;
    private JTextArea editar_qntLavagem;
    private JTextArea editar_lojaOrigem;
    private JTextArea editar_qntUso;
	public EditorCalcado(String titulo, Item calcado, Vector<Item> itens) {
		super(titulo);
        this.calcado = calcado;
        
        JPanel panePrincipal = new JPanel(new BorderLayout());
        setContentPane(panePrincipal);
        
        // Painel Esquerdo 
        JPanel panelEsquerdo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);  // Margens
        gbc.anchor = GridBagConstraints.CENTER;    // Centralizar componentes
        
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
        
        ImageIcon ft_sapato = new ImageIcon("./imagens/tenis.png");
        Image imagemRedim = ft_sapato.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon sapato_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_disquete = new ImageIcon("./imagens/disquete.png");
        imagemRedim = ft_disquete.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon disquete_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_parteCima = new JLabel(sapato_redim, SwingConstants.CENTER);
        ft_parteCima.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_parteCima = new JLabel(calcado.getTipo(), SwingConstants.CENTER);
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
        
        // caixas de textos
        editar_cor = new JTextArea();
        editar_cor.setPreferredSize(new Dimension(100, 50));
        editar_cor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_cor.setAlignmentX(SwingConstants.CENTER);
        editar_cor.setText(calcado.getCor());
         
        editar_conservacao = new JTextArea();
        editar_conservacao.setPreferredSize(new Dimension(100, 50));
        editar_conservacao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_conservacao.setAlignmentX(SwingConstants.CENTER);
        editar_conservacao.setText(calcado.getConservacao());

        editar_tamanho = new JTextArea();
        editar_tamanho.setPreferredSize(new Dimension(100, 50));
        editar_tamanho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_tamanho.setAlignmentX(SwingConstants.CENTER);
        editar_tamanho.setText(calcado.getTamanho());
         
        editar_qntLavagem = new JTextArea();
        editar_qntLavagem.setPreferredSize(new Dimension(100, 50));
        editar_qntLavagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_qntLavagem.setAlignmentX(SwingConstants.CENTER);
        editar_qntLavagem.setText(Integer.toString(calcado.getQntLavagem()));
        
        editar_lojaOrigem = new JTextArea();
        editar_lojaOrigem.setPreferredSize(new Dimension(100, 50));
        editar_lojaOrigem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_lojaOrigem.setAlignmentX(SwingConstants.CENTER);
        editar_lojaOrigem.setText(calcado.getLojaOrigem());

        editar_qntUso = new JTextArea();
        editar_qntUso.setPreferredSize(new Dimension(100, 50));
        editar_qntUso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_qntUso.setAlignmentX(SwingConstants.CENTER);
        editar_qntUso.setText(Integer.toString(calcado.getQntUso()));
        
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
        panelCentral.add(editar_cor, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(editar_conservacao, gbc2);
        
        gbc2.gridy = 3;
                
        gbc2.gridx = 0;
        panelCentral.add(editar_tamanho, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(editar_qntLavagem, gbc2);
        
        gbc2.gridy = 5;
        
        gbc2.gridx = 0;
        panelCentral.add(editar_lojaOrigem, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(editar_qntUso, gbc2);
        
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
			itens.remove(calcado);
			String novaCor = editar_cor.getText();
			String novaConservacao = editar_conservacao.getText();
			String novoTamanho = editar_tamanho.getText();
			int novaQntLavagem = Integer.parseInt(editar_qntLavagem.getText());
            String novaLojaOrigem = editar_lojaOrigem.getText();
            int novaQntUso = Integer.parseInt(editar_qntUso.getText());
            calcado.mudar_cor(novaCor);
            calcado.mudar_conservacao(novaConservacao);
            calcado.mudarTamanho(novoTamanho);
            calcado.mudarQntLavagem(novaQntLavagem);
            calcado.mudar_lojaOrigem(novaLojaOrigem);
            calcado.mudarQntUso(novaQntUso);
			ExcluirTudo excluidor = new ExcluirTudo();
			itens.add(calcado);
			excluidor.excluirPecas();
			for(int i = 0; i < itens.size(); i++) {
				itens.get(i).salvar();
			}
			this.dispose();
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro de formato!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar a peça :"+e.getMessage());
		}
	}
}
