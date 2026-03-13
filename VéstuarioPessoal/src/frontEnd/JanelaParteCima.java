package frontEnd;

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
import javax.swing.SwingConstants;
import bancoDados.ExcluirTudo;
import editoresPack.EditorParteCima;
import itensPack.Item;

public class JanelaParteCima extends JFrame{
	Item parteCima;
	public JanelaParteCima(String titulo, Item parteCima, Vector<Item> itens) {
        super(titulo);
        this.parteCima = parteCima;
        
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
        
        ImageIcon ft_camisa = new ImageIcon("./imagens/camisa.png");
        Image imagemRedim = ft_camisa.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon camisa_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lixeira = new ImageIcon("./imagens/lixeira.png");
        imagemRedim = ft_lixeira.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lixeira_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lapis = new ImageIcon("./imagens/lapis.png");
        imagemRedim = ft_lapis.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lapis_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_parteCima = new JLabel(camisa_redim, SwingConstants.CENTER);
        ft_parteCima.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_parteCima = new JLabel(parteCima.getTipo(), SwingConstants.CENTER);
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
        
        JLabel cor_parteCima = new JLabel(parteCima.getCor(), SwingConstants.CENTER);
        cor_parteCima.setPreferredSize(new Dimension(100, 50));
        cor_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel conservacao_parteCima = new JLabel(parteCima.getConservacao(), SwingConstants.CENTER);
        conservacao_parteCima.setPreferredSize(new Dimension(100, 50));
        conservacao_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel tamanho_parteCima = new JLabel(parteCima.getTamanho(), SwingConstants.CENTER);
        tamanho_parteCima.setPreferredSize(new Dimension(100, 50));
        tamanho_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

        JLabel qntLavagem_parteCima = new JLabel(Integer.toString(parteCima.getQntLavagem()), SwingConstants.CENTER);
        qntLavagem_parteCima.setPreferredSize(new Dimension(100, 50));
        qntLavagem_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel lojaOrigem_parteCima = new JLabel(parteCima.getLojaOrigem(), SwingConstants.CENTER);
        lojaOrigem_parteCima.setPreferredSize(new Dimension(100, 50));
        lojaOrigem_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel qntUso_parteCima = new JLabel(Integer.toString(parteCima.getQntUso()), SwingConstants.CENTER);
        qntUso_parteCima.setPreferredSize(new Dimension(100, 50));
        qntUso_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel lixeira = new JLabel(lixeira_redim, SwingConstants.CENTER);
        lixeira.setPreferredSize(new Dimension(100,100));
        JButton excluir = new JButton("Excluir Peça");
        excluir.addActionListener(e -> excluirParteCima(parteCima,itens));
        
        JLabel lapis = new JLabel(lapis_redim, SwingConstants.CENTER);
        lapis.setPreferredSize(new Dimension(100,100));
        JButton editar = new JButton("Editar Peça");
        editar.addActionListener(e -> new EditorParteCima("Editar "+ parteCima.getTipo(), parteCima, itens));
        
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
        
        // adicionar botao de excluir e editar peça
        gbc3.gridy = 0;
        
        gbc3.gridx = 0;
        panelDireito.add(lixeira,gbc3);
        gbc3.gridx = 1;
        panelDireito.add(excluir,gbc3);
        
        gbc3.gridy = 1;
        
        gbc3.gridx = 0;
        panelDireito.add(lapis,gbc3);
        gbc3.gridx = 1;
        panelDireito.add(editar,gbc3);
        
        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        panePrincipal.add(panelDireito, BorderLayout.EAST);
        pack();
        setVisible(true);
    }
	
	private void excluirParteCima(Item parteCima, Vector<Item> itens) {
		try {	
			itens.remove(parteCima);
			ExcluirTudo excluidor = new ExcluirTudo();
			excluidor.excluirPecas();
			for(int i = 0; i < itens.size(); i++) {
				itens.get(i).salvar();
			}
			this.dispose();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir a peça :"+ e.getMessage());
		}
	}
}
