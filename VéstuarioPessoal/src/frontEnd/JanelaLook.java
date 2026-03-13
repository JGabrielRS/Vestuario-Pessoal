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
import backEnd.Look;
import bancoDados.ExcluirTudo;
import editoresPack.EditorLook;
import itensPack.Item;

public class JanelaLook extends JFrame{
	Look look;
	public JanelaLook(String titulo, Vector<Item> itens, Vector<Look> looks, Vector<Item> parteCimaVetor, Vector<Item> parteBaixoVetor, Vector<Item> calcadoVetor, Vector<Item> acessorioVetor, Vector<Item> parteIntimaVetor, Look look) {
        super(titulo);
        this.look = look;
        
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
        
        ImageIcon ft_look1 = new ImageIcon("./imagens/look.png");
        Image imagemRedim = ft_look1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon look_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lixeira = new ImageIcon("./imagens/lixeira.png");
        imagemRedim = ft_lixeira.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lixeira_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lapis = new ImageIcon("./imagens/lapis.png");
        imagemRedim = ft_lapis.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lapis_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_look = new JLabel(look_redim, SwingConstants.CENTER);
        ft_look.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_look = new JLabel(look.getNome(), SwingConstants.CENTER);
        nome_look.setPreferredSize(new Dimension(200,50));
        nome_look.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Componentes
        JLabel parteCima = new JLabel("parte de cima:", SwingConstants.CENTER);
        parteCima.setPreferredSize(new Dimension(200, 50));  // Tamanho fixo para imagem
        
        JLabel parteBaixo = new JLabel("parte de baixo:", SwingConstants.CENTER);
        parteBaixo.setPreferredSize(new Dimension(200, 50));
        
        JLabel calcado = new JLabel("calçado:", SwingConstants.CENTER);
        calcado.setPreferredSize(new Dimension(200, 50));

        JLabel usos = new JLabel("usos:", SwingConstants.CENTER);
        usos.setPreferredSize(new Dimension(200, 50));
        
        JLabel parteIntima = new JLabel("parte intima:", SwingConstants.CENTER);
        parteIntima.setPreferredSize(new Dimension(200, 50));
        
        JLabel qntUso = new JLabel("quantidade de usos:", SwingConstants.CENTER);
        qntUso.setPreferredSize(new Dimension(200, 50));
        
        JLabel parteCima_look = new JLabel(look.mostrarParteCima().getTipo(), SwingConstants.CENTER);
        parteCima_look.setPreferredSize(new Dimension(100, 50));
        parteCima_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel parteBaixo_look = new JLabel(look.mostrarParteBaixo().getTipo(), SwingConstants.CENTER);
        parteBaixo_look.setPreferredSize(new Dimension(100, 50));
        parteBaixo_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel calcado_look = new JLabel(look.mostrarCalcado().getTipo(), SwingConstants.CENTER);
        calcado_look.setPreferredSize(new Dimension(100, 50));
        calcado_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

        JButton uso_look = new JButton("usos");
        uso_look.addActionListener(e -> new UsosLook("Usos", look));
        
        JLabel parteIntima_look = new JLabel(look.mostrarParteIntima().getTipo(), SwingConstants.CENTER);
        parteIntima_look.setPreferredSize(new Dimension(100, 50));
        parteIntima_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel qntUso_look = new JLabel(Integer.toString(look.getQntUso()), SwingConstants.CENTER);
        qntUso_look.setPreferredSize(new Dimension(100, 50));
        qntUso_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        JLabel lixeira = new JLabel(lixeira_redim, SwingConstants.CENTER);
        lixeira.setPreferredSize(new Dimension(100,100));
        JButton excluir = new JButton("Excluir Look");
        excluir.addActionListener(e -> excluirLook(look,looks));
        
        JLabel lapis = new JLabel(lapis_redim, SwingConstants.CENTER);
        lapis.setPreferredSize(new Dimension(100,100));
        JButton editar = new JButton("Editar Look");
        editar.addActionListener(e -> new EditorLook("Editar "+ look.getNome(), itens, looks, parteCimaVetor, parteBaixoVetor, calcadoVetor, acessorioVetor, parteIntimaVetor, look));
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_look, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(nome_look, gbc);
        
        // Adicionar nomes 
        gbc2.gridy = 0;
        
        gbc2.gridx = 0;
        panelCentral.add(parteCima, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(parteBaixo, gbc2);
        
        gbc2.gridy = 2;
        
        gbc2.gridx = 0;
        panelCentral.add(calcado, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(usos, gbc2);
        
        gbc2.gridy = 4;
        
        gbc2.gridx = 0;
        panelCentral.add(parteIntima, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(qntUso, gbc2);
        
        // Adicionar campos preenchidos
        gbc2.gridy = 1;
        
        gbc2.gridx = 0;
        panelCentral.add(parteCima_look, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(parteBaixo_look, gbc2);
        
        gbc2.gridy = 3;
                
        gbc2.gridx = 0;
        panelCentral.add(calcado_look, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(uso_look, gbc2);
        
        gbc2.gridy = 5;
        
        gbc2.gridx = 0;
        panelCentral.add(parteIntima_look, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(qntUso_look, gbc2);
        
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
	
	private void excluirLook(Look look, Vector<Look> looks) {
		try {	
			looks.remove(look);
			ExcluirTudo excluidor = new ExcluirTudo();
			excluidor.excluirPecas();
			for(int i = 0; i < looks.size(); i++) {
				looks.get(i).salvar();
			}
			this.dispose();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir a peça :" + e.getMessage());
		}
	}
}
