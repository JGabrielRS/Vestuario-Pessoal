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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backEnd.Look;
import itensPack.Item;

public class Estatistica extends JFrame{
	Vector<Item> itens = new Vector<>();
	Vector<Item> parteCima = new Vector<>();
	Vector<Item> parteBaixo = new Vector<>();
	Vector<Item> calcado = new Vector<>();
	Vector<Item> acessorio = new Vector<>();
	Vector<Item> parteIntima = new Vector<>();
	Vector<Look> looks = new Vector<>();
	public Estatistica(String titulo, Vector<Item> itens, Vector<Look> looks, Vector<Item> parteCima, Vector<Item> parteBaixo, Vector<Item> calcado, Vector<Item> acessorio, Vector<Item> parteIntima) {
        super(titulo);
        this.itens = itens;
        this.parteCima = parteCima;
        this.parteBaixo = parteBaixo;
        this.calcado = calcado;
        this.acessorio = acessorio;
        this.parteIntima = parteIntima;
        this.looks = looks;
        JPanel panePrincipal = new JPanel(new BorderLayout());
        setContentPane(panePrincipal);
        
        // Painel cima
        JPanel panelCima = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);  
        gbc.anchor = GridBagConstraints.CENTER;    
        
        // Painel baixo
        JPanel panelBaixo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 20, 10, 20);  
        gbc2.anchor = GridBagConstraints.CENTER; 
        
        ImageIcon ft_maiscamisa = new ImageIcon("./imagens/camisa_maisusada.png");
        Image imagemRedim2 = ft_maiscamisa.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscamisa_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maiscalca = new ImageIcon("./imagens/calca_maisusada.png");
        imagemRedim2 = ft_maiscalca.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscalca_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maiscueca = new ImageIcon("./imagens/cueca_maisusada.png");
        imagemRedim2 = ft_maiscueca.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscueca_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maissapato = new ImageIcon("./imagens/tenis_maisusada.png");
        imagemRedim2 = ft_maissapato.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maissapato_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maisrelogio = new ImageIcon("./imagens/relogio_maisusado.png");
        imagemRedim2 = ft_maisrelogio.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maisacessorio_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maislook1 = new ImageIcon("./imagens/look_maisusado.png");
        imagemRedim2 = ft_maislook1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maislook_redim = new ImageIcon(imagemRedim2);
        
        // Componentes
        JLabel ft_parteCima = new JLabel(maiscamisa_redim, SwingConstants.CENTER);
        ft_parteCima.setPreferredSize(new Dimension(200, 200));  
        
        JLabel ft_parteBaixo = new JLabel(maiscalca_redim, SwingConstants.CENTER);
        ft_parteBaixo.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_parteIntima = new JLabel(maiscueca_redim, SwingConstants.CENTER);
        ft_parteIntima.setPreferredSize(new Dimension(200, 200));

        JLabel ft_calcado = new JLabel(maissapato_redim, SwingConstants.CENTER);
        ft_calcado.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_acessorio = new JLabel(maisacessorio_redim, SwingConstants.CENTER);
        ft_acessorio.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_look = new JLabel(maislook_redim, SwingConstants.CENTER);
        ft_look.setPreferredSize(new Dimension(200, 200));
        
        JButton botaoParteCima = new JButton("Parte de Cima Mais Usada");
        botaoParteCima.addActionListener(e -> new PartesCimaMaisUsada("Partes de Cima Mais Usada",parteCima));
        JButton botaoParteBaixo = new JButton("Parte de Baixo Mais Usada");
        botaoParteBaixo.addActionListener(e -> new ParteBaixoMaisUsada("Parte de Baixo Mais Usada",parteBaixo));
        JButton botaoParteIntima = new JButton("Parte Intima Mais Usada");
        botaoParteIntima.addActionListener(e -> new ParteIntimaMaisUsada("Parte Intima Mais Usada",parteIntima));
        JButton botaoCalcado = new JButton("Calcado Mais usado");
        botaoCalcado.addActionListener(e -> new CalcadoMaisUsado("Calçado Mais Usado",calcado));
        JButton botaoAcessorio = new JButton("Acessorio Mais Usado");
        botaoAcessorio.addActionListener(e -> new AcessorioMaisUsado("Acessorio mais Usado",acessorio));
        JButton botaoLook = new JButton("Look Mais Usado");
        botaoLook.addActionListener(e -> new LookMaisUsado("Look Mais Usado", itens,looks,parteCima,parteBaixo,calcado,acessorio,parteIntima));
        
        // Adicionar imagens
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelCima.add(ft_parteCima, gbc);
        
        gbc.gridx = 1;
        panelCima.add(ft_parteBaixo, gbc);
        
        gbc.gridx = 2;
        panelCima.add(ft_calcado, gbc);
        
        gbc.gridx = 3;
        panelCima.add(ft_acessorio, gbc);
        
        gbc.gridx = 4;
        panelCima.add(ft_parteIntima, gbc);
        
        gbc.gridx = 5;
        panelCima.add(ft_look, gbc);
        
        // Adicionar botões
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelCima.add(botaoParteCima, gbc);
        
        gbc.gridx = 1;
        panelCima.add(botaoParteBaixo, gbc);
        
        gbc.gridx = 2;
        panelCima.add(botaoCalcado, gbc);
        
        gbc.gridx = 3;
        panelCima.add(botaoAcessorio, gbc);
        
        gbc.gridx = 4;
        panelCima.add(botaoParteIntima, gbc);
        
        gbc.gridx = 5;
        panelCima.add(botaoLook, gbc);
        
        
        panePrincipal.add(panelCima, BorderLayout.NORTH);
        panePrincipal.add(panelBaixo, BorderLayout.SOUTH);
        pack();
        setVisible(true);
	}
}
