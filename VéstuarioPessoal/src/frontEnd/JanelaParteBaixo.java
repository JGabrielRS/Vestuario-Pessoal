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
import editoresPack.EditorParteBaixo;
import itensPack.Item;

public class JanelaParteBaixo extends JFrame{
	Item parteBaixo;
	public JanelaParteBaixo(String titulo, Item parteBaixo, Vector<Item> itens) {
        super(titulo);
        this.parteBaixo = parteBaixo;
        
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
        
        ImageIcon ft_calca = new ImageIcon("./imagens/calca.png");
        Image imagemRedim = ft_calca.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon calca_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lixeira = new ImageIcon("./imagens/lixeira.png");
        imagemRedim = ft_lixeira.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lixeira_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lapis = new ImageIcon("./imagens/lapis.png");
        imagemRedim = ft_lapis.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lapis_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_parteBaixo = new JLabel(calca_redim, SwingConstants.CENTER);
        ft_parteBaixo.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_parteBaixo = new JLabel(parteBaixo.getTipo(), SwingConstants.CENTER);
        nome_parteBaixo.setPreferredSize(new Dimension(200,50));
        nome_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
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
        
        JLabel cor_parteBaixo = new JLabel(parteBaixo.getCor(), SwingConstants.CENTER);
        cor_parteBaixo.setPreferredSize(new Dimension(100, 50));
        cor_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel conservacao_parteBaixo = new JLabel(parteBaixo.getConservacao(), SwingConstants.CENTER);
        conservacao_parteBaixo.setPreferredSize(new Dimension(100, 50));
        conservacao_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel tamanho_parteBaixo = new JLabel(parteBaixo.getTamanho(), SwingConstants.CENTER);
        tamanho_parteBaixo.setPreferredSize(new Dimension(100, 50));
        tamanho_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

        JLabel qntLavagem_parteBaixo = new JLabel(Integer.toString(parteBaixo.getQntLavagem()), SwingConstants.CENTER);
        qntLavagem_parteBaixo.setPreferredSize(new Dimension(100, 50));
        qntLavagem_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel lojaOrigem_parteBaixo = new JLabel(parteBaixo.getLojaOrigem(), SwingConstants.CENTER);
        lojaOrigem_parteBaixo.setPreferredSize(new Dimension(100, 50));
        lojaOrigem_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel qntUso_parteBaixo = new JLabel(Integer.toString(parteBaixo.getQntUso()), SwingConstants.CENTER);
        qntUso_parteBaixo.setPreferredSize(new Dimension(100, 50));
        qntUso_parteBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel lixeira = new JLabel(lixeira_redim, SwingConstants.CENTER);
        lixeira.setPreferredSize(new Dimension(100,100));
        JButton excluir = new JButton("Excluir Peça");
        excluir.addActionListener(e -> excluirParteBaixo(parteBaixo,itens));
        
        JLabel lapis = new JLabel(lapis_redim, SwingConstants.CENTER);
        lapis.setPreferredSize(new Dimension(100,100));
        JButton editar = new JButton("Editar Peça");
        editar.addActionListener(e -> new EditorParteBaixo("Editar "+ parteBaixo.getTipo(), parteBaixo, itens));
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_parteBaixo, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(nome_parteBaixo, gbc);
        
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
        panelCentral.add(cor_parteBaixo, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(conservacao_parteBaixo, gbc2);
        
        gbc2.gridy = 3;
                
        gbc2.gridx = 0;
        panelCentral.add(tamanho_parteBaixo, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(qntLavagem_parteBaixo, gbc2);
        
        gbc2.gridy = 5;
        
        gbc2.gridx = 0;
        panelCentral.add(lojaOrigem_parteBaixo, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(qntUso_parteBaixo, gbc2);
        
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
	
	private void excluirParteBaixo(Item parteBaixo, Vector<Item> itens) {
		try {	
			itens.remove(parteBaixo);
			ExcluirTudo excluidor = new ExcluirTudo();
			excluidor.excluirPecas();
			for(int i = 0; i < itens.size(); i++) {
				itens.get(i).salvar();
			}
			this.dispose();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir a peça :" + e.getMessage());
		}
	}
}
