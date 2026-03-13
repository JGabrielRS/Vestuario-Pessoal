package menusEspeciaisPack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backEnd.Look;
import estatisticaPack.AcessorioMaisUsado;
import estatisticaPack.CalcadoMaisUsado;
import estatisticaPack.LookMaisUsado;
import estatisticaPack.ParteBaixoMaisUsada;
import estatisticaPack.ParteIntimaMaisUsada;
import estatisticaPack.PartesCimaMaisUsada;
import itensPack.Item;

public class JanelaEmprestimo extends JFrame{
	Vector<Item> itens = new Vector<>();
	Vector<Item> parteCima = new Vector<>();
	Vector<Item> parteBaixo = new Vector<>();
	Vector<Item> calcado = new Vector<>();
	Vector<Item> acessorio = new Vector<>();
	Vector<Item> parteIntima = new Vector<>();
	Vector<Look> looks = new Vector<>();
	public JanelaEmprestimo	(String titulo, Vector<Item> itens, Vector<Look> looks, Vector<Item> parteCima, Vector<Item> parteBaixo, Vector<Item> calcado, Vector<Item> acessorio, Vector<Item> parteIntima) {
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
        
        ImageIcon ft_grafico = new ImageIcon("./imagens/maisemprestimo.png");
        Image imagemRedim2 = ft_grafico.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon grafico_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_emprestimo = new ImageIcon("./imagens/menosemprestimo.png");
        imagemRedim2 = ft_emprestimo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon emprestimo_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maquinadelavar = new ImageIcon("./imagens/calendario.png");
        imagemRedim2 = ft_maquinadelavar.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon maquinadelavar_redim = new ImageIcon(imagemRedim2);
        // Componentes
        JLabel ft_registro = new JLabel(grafico_redim, SwingConstants.CENTER);
        ft_registro.setPreferredSize(new Dimension(200, 200));   
        
        JLabel ft_devolucao = new JLabel(emprestimo_redim, SwingConstants.CENTER);
        ft_devolucao.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_calendario = new JLabel(maquinadelavar_redim, SwingConstants.CENTER);
        ft_calendario.setPreferredSize(new Dimension(200, 200));
        
        JButton botaoRegistro = new JButton("Registrar um empréstimo");
        botaoRegistro.addActionListener(e -> new JanelaRegEmprestimo("Registrar um empréstimo",itens));
        JButton botaoDevolução = new JButton("Registrar uma devolução");
        botaoDevolução.addActionListener(e -> new JanelaDevolucaoEmprestimo("Registrar uma devolução",itens));
        JButton botaoQntDias = new JButton("Verificar tempo de empréstimo");
        botaoQntDias.addActionListener(e -> new TempoEmprestimo("Verificar tempo de empréstimo",itens));
        
        // Adicionar imagens
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelCima.add(ft_registro, gbc);
        
        gbc.gridx = 1;
        panelCima.add(ft_devolucao, gbc);
        
        gbc.gridx = 4;
        panelCima.add(ft_calendario, gbc);
        
        // Adicionar botões
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelCima.add(botaoRegistro, gbc);
        
        gbc.gridx = 1;
        panelCima.add(botaoDevolução, gbc);
        
        gbc.gridx = 4;
        panelCima.add(botaoQntDias, gbc);
        
        
        panePrincipal.add(panelCima, BorderLayout.NORTH);
        panePrincipal.add(panelBaixo, BorderLayout.SOUTH);
        pack();
        setVisible(true);
	}
}
