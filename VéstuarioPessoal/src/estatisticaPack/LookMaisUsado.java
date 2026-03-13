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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backEnd.Look;
import bancoDados.ExcluirTudo;
import frontEnd.UsosLook;
import itensPack.Item;

public class LookMaisUsado extends JFrame{
	Look maisUsadoLook;
	public LookMaisUsado(String titulo, Vector<Item> itens, Vector<Look> looks, Vector<Item> parteCimaVetor, Vector<Item> parteBaixoVetor, Vector<Item> calcadoVetor, Vector<Item> acessorioVetor, Vector<Item> parteIntimaVetor) {
        super(titulo);
        int maiorUsoItem = 0;
        maisUsadoLook = null;
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
        
        for(int i = 0; i < looks.size(); i++) {
			if(looks.get(i).getQntUso() > maiorUsoItem) {
				maisUsadoLook = looks.get(i);
				maiorUsoItem = maisUsadoLook.getQntUso();
			}
		}
        ImageIcon ft_maislook1 = new ImageIcon("./imagens/look_maisusado.png");
        Image imagemRedim2 = ft_maislook1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maislook_redim = new ImageIcon(imagemRedim2);
        if(maisUsadoLook != null) {
	        // foto e tipo
	        JLabel ft_look = new JLabel(maislook_redim, SwingConstants.CENTER);
	        ft_look.setPreferredSize(new Dimension(200, 200));
	        
	        JLabel nome_look = new JLabel(maisUsadoLook.getNome(), SwingConstants.CENTER);
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
	        
	        JLabel parteCima_look = new JLabel(maisUsadoLook.mostrarParteCima().getTipo(), SwingConstants.CENTER);
	        parteCima_look.setPreferredSize(new Dimension(100, 50));
	        parteCima_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel parteBaixo_look = new JLabel(maisUsadoLook.mostrarParteBaixo().getTipo(), SwingConstants.CENTER);
	        parteBaixo_look.setPreferredSize(new Dimension(100, 50));
	        parteBaixo_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel calcado_look = new JLabel(maisUsadoLook.mostrarCalcado().getTipo(), SwingConstants.CENTER);
	        calcado_look.setPreferredSize(new Dimension(100, 50));
	        calcado_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	
	        JButton uso_look = new JButton("usos");
	        uso_look.addActionListener(e -> new UsosLook("Usos", maisUsadoLook));
	        
	        JLabel parteIntima_look = new JLabel(maisUsadoLook.mostrarParteIntima().getTipo(), SwingConstants.CENTER);
	        parteIntima_look.setPreferredSize(new Dimension(100, 50));
	        parteIntima_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
	        JLabel qntUso_look = new JLabel(Integer.toString(maisUsadoLook.getQntUso()), SwingConstants.CENTER);
	        qntUso_look.setPreferredSize(new Dimension(100, 50));
	        qntUso_look.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	        
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
	        
	        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
	        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        } else {
        	JLabel X = new JLabel("ft de um X", SwingConstants.CENTER);
	        X.setPreferredSize(new Dimension(200, 200));
	        X.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        JLabel nome_parteCima = new JLabel("Não Existe Look Mais Usado!", SwingConstants.CENTER);
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
