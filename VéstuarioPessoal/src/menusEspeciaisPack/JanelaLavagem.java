package menusEspeciaisPack;

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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backEnd.Lavagem;
import backEnd.Look;
import backEnd.Uso;
import bancoDados.ExcluirTudo;
import editoresPack.EditarUso;
import itensPack.Item;

public class JanelaLavagem extends JFrame{
	private Vector<Item> itens = new Vector<>();
	private Vector<Item> parteCima = new Vector<>();
	private Vector<Item> parteBaixo = new Vector<>();
	private Vector<Item> calcado = new Vector<>();
	private Vector<Item> parteIntima = new Vector<>();
	private Item parteCimatemp;
	private Item parteBaixotemp;
	private Item calcadotemp;
	private Item parteIntimatemp;
	
	public JanelaLavagem(String titulo, Vector<Item> itens, Vector<Item> parteCima, Vector<Item> parteBaixo, Vector<Item> calcado, Vector<Item> parteIntima) {
		super(titulo);
        this.itens = itens;
        this.parteCima = parteCima;
        this.parteBaixo = parteBaixo;
        this.calcado = calcado;
        this.parteIntima = parteIntima;
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
        
        ImageIcon ft_relogio = new ImageIcon("./imagens/maquinadelavar.png");
        Image imagemRedim = ft_relogio.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon acessorio_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_lixeira = new ImageIcon("./imagens/check.png");
        imagemRedim = ft_lixeira.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lixeira_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_maqLavar = new JLabel(acessorio_redim, SwingConstants.CENTER);
        ft_maqLavar.setPreferredSize(new Dimension(200, 200));
        
        JLabel lavagem = new JLabel("Lavagem", SwingConstants.CENTER);
        lavagem.setPreferredSize(new Dimension(200,50));
        lavagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Componentes
        JLabel parteCimaComp = new JLabel("parte de cima:", SwingConstants.CENTER);
        parteCimaComp.setPreferredSize(new Dimension(200, 50));  // Tamanho fixo para imagem
        
        JLabel parteBaixoComp = new JLabel("parte de baixo:", SwingConstants.CENTER);
        parteBaixoComp.setPreferredSize(new Dimension(200, 50));
        
        JLabel calcadoComp = new JLabel("calçado:", SwingConstants.CENTER);
        calcadoComp.setPreferredSize(new Dimension(200, 50));
        
        JLabel parteIntimaComp = new JLabel("parte intima:", SwingConstants.CENTER);
        parteIntimaComp.setPreferredSize(new Dimension(200, 50));
        
        JButton botaoParteCima = new JButton(parteCimatemp != null ? parteCimatemp.getTipo() : "Selecionar");
        JButton botaoParteBaixo = new JButton(parteBaixotemp != null ? parteBaixotemp.getTipo() : "Selecionar");
        JButton botaoParteIntima = new JButton(parteIntimatemp != null ? parteIntimatemp.getTipo() : "Selecionar");
        JButton botaoCalcado = new JButton(calcadotemp != null ? calcadotemp.getTipo() : "Selecionar");
        
        JPopupMenu menuParteCima = new JPopupMenu();
        if (parteCima != null && !parteCima.isEmpty()) {
            for (int i = 0; i < parteCima.size(); i++) {
                Item item = parteCima.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
            	menuItem.addActionListener(e -> {parteCimatemp = item; botaoParteCima.setText(item.getTipo());});
                menuParteCima.add(menuItem);
            }
        } else {
            menuParteCima.add(new JMenuItem("Nenhum item disponível"));
        }
        botaoParteCima.addActionListener(e -> menuParteCima.show(botaoParteCima, 0, botaoParteCima.getHeight()));
        JPopupMenu menuParteBaixo = new JPopupMenu();
        if (parteBaixo != null && !parteBaixo.isEmpty()) {
            for (int i = 0; i < parteBaixo.size(); i++) {
                Item item = parteBaixo.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
            	menuItem.addActionListener(e -> {parteBaixotemp = item; botaoParteBaixo.setText(item.getTipo());});
                menuParteBaixo.add(menuItem);
            }
        } else {
            menuParteBaixo.add(new JMenuItem("Nenhum item disponível"));
        }
        botaoParteBaixo.addActionListener(e -> menuParteBaixo.show(botaoParteBaixo, 0, botaoParteBaixo.getHeight()));
        JPopupMenu menuParteIntima = new JPopupMenu();
        if (parteIntima != null && !parteIntima.isEmpty()) {
            for (int i = 0; i < parteIntima.size(); i++) {
                Item item = parteIntima.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
            	menuItem.addActionListener(e -> {parteIntimatemp = item; botaoParteIntima.setText(item.getTipo());});
            	menuParteIntima.add(menuItem);
            }
        } else {
            menuParteIntima.add(new JMenuItem("Nenhum item disponível"));
        }
        botaoParteIntima.addActionListener(e -> menuParteIntima.show(botaoParteIntima, 0, botaoParteIntima.getHeight()));
        JPopupMenu menuCalcado = new JPopupMenu();
        if (calcado != null && !calcado.isEmpty()) {
            for (int i = 0; i < calcado.size(); i++) {
                Item item = calcado.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
            	menuItem.addActionListener(e -> {calcadotemp = item; botaoCalcado.setText(item.getTipo());});
            	menuCalcado.add(menuItem);
            }
        } else {
            menuCalcado.add(new JMenuItem("Nenhum item disponível"));
        }
        botaoCalcado.addActionListener(e -> menuCalcado.show(botaoCalcado, 0, botaoCalcado.getHeight()));
        
        JLabel V = new JLabel(lixeira_redim, SwingConstants.CENTER);
        V.setPreferredSize(new Dimension(100,100));
        JButton salvar = new JButton("Fazer a Lavagem");
        salvar.addActionListener(e -> lavarItens(itens));
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_maqLavar, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(lavagem, gbc);
        
        // Adicionar nomes 
        gbc2.gridy = 0;
        
        gbc2.gridx = 0;
        panelCentral.add(parteCimaComp, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(parteBaixoComp, gbc2);
        
        gbc2.gridy = 2;
        
        gbc2.gridx = 0;
        panelCentral.add(calcadoComp, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(parteIntimaComp, gbc2);
        
        gbc2.gridx = 1;
        
        // Adicionar campos preenchidos
        gbc2.gridy = 1;
        
        gbc2.gridx = 0;
        panelCentral.add(botaoParteCima, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(botaoParteBaixo, gbc2);
        
        gbc2.gridy = 3;
                
        gbc2.gridx = 0;
        panelCentral.add(botaoCalcado, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(botaoParteIntima, gbc2);
        
        gbc2.gridx = 1;
        
        // adicionar botao de salvar peça
        gbc3.gridy = 0;
        
        gbc3.gridx = 0;
        panelDireito.add(V,gbc3);
        gbc3.gridx = 1;
        panelDireito.add(salvar,gbc3);
        
        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        panePrincipal.add(panelDireito, BorderLayout.EAST);
        pack();
        setVisible(true);
	}
	
	private void lavarItens(Vector<Item> itens) {
		try {
			itens.remove(parteCimatemp);
			itens.remove(parteBaixotemp);
			itens.remove(calcadotemp);
			itens.remove(parteIntimatemp);
			Lavagem lavagem = new Lavagem(parteCimatemp,parteBaixotemp,calcadotemp,parteIntimatemp);
			lavagem.lavar();
			itens.add(parteCimatemp);
			itens.add(parteBaixotemp);
			itens.add(calcadotemp);
			itens.add(parteIntimatemp);
            ExcluirTudo excluidor = new ExcluirTudo();
			excluidor.excluirPecas();
			for(int i = 0; i < itens.size(); i++) {
				itens.get(i).salvar();
			}
			JOptionPane.showMessageDialog(this, "Lavagem Feita!");
			this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao lavar as peças :"+e.getMessage());
		}
	}
}