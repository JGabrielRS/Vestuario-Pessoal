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
import javax.swing.SwingConstants;
import itensPack.Acessorio;
import itensPack.Calcado;
import itensPack.Item;
import itensPack.ParteBaixo;
import itensPack.ParteCima;

public class TempoEmprestimo extends JFrame{
	private Vector<Item> itens = new Vector<>();
	private Item itemtemp;

	
	public TempoEmprestimo(String titulo, Vector<Item> itens) {
		super(titulo);
        this.itens = itens;
        Vector<Item> itensEmp = new Vector<>();
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
        
        ImageIcon ft_emprestimo = new ImageIcon("./imagens/check.png");
        Image imagemRedim2 = ft_emprestimo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon emprestimo_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maquinadelavar = new ImageIcon("./imagens/calendario.png");
        imagemRedim2 = ft_maquinadelavar.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon maquinadelavar_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maquinadelavar2 = new ImageIcon("./imagens/X.png");
        imagemRedim2 = ft_maquinadelavar2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon maquinadelavar_redim2 = new ImageIcon(imagemRedim2);
        
        for(int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getEmprestado().equals("Emprestado")) {
				itensEmp.add(itens.get(i));
			}
		}
        if(itens.size() > 0) {
	        // foto e tipo
	        JLabel ft_calendario = new JLabel(maquinadelavar_redim, SwingConstants.CENTER);
	        ft_calendario.setPreferredSize(new Dimension(200, 200));
	        ft_calendario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        JLabel tempoEmprestimo = new JLabel("Ver Tempo de Emprestimo", SwingConstants.CENTER);
	        tempoEmprestimo.setPreferredSize(new Dimension(200,50));
	        tempoEmprestimo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        // Componentes
	        JLabel itemComp = new JLabel("Item:", SwingConstants.CENTER);
	        itemComp.setPreferredSize(new Dimension(200, 50));
	        
	        JButton botaoItem = new JButton(itemtemp != null ? itemtemp.getTipo() : "Selecionar");
	        
	        JPopupMenu menuItemEscolhido = new JPopupMenu();
	        if (itensEmp != null && !itensEmp.isEmpty()) {
	            for (int i = 0; i < itensEmp.size(); i++) {
	                Item item = itensEmp.get(i);
	            	JMenuItem menuItem = new JMenuItem(item.getTipo());
	            	menuItem.addActionListener(e -> {itemtemp = item; botaoItem.setText(item.getTipo());});
	                menuItemEscolhido.add(menuItem);
	            }
	        } else {
	            menuItemEscolhido.add(new JMenuItem("Nenhum item disponível"));
	        }
	        botaoItem.addActionListener(e -> menuItemEscolhido.show(botaoItem, 0, botaoItem.getHeight()));
	        
	        JLabel V = new JLabel(emprestimo_redim, SwingConstants.CENTER);
	        V.setPreferredSize(new Dimension(100,100));
	        JButton salvar = new JButton("Ver tempo de emprestimo");
	        salvar.addActionListener(e -> verTempEmp());
	        
	        // Adicionar imagem
	        gbc.gridy = 0;
	        
	        gbc.gridx = 0;
	        panelEsquerdo.add(ft_calendario, gbc);
	        
	        // Adicionar tipo
	        gbc.gridy = 1;
	        
	        gbc.gridx = 0;
	        panelEsquerdo.add(tempoEmprestimo, gbc);
	        
	        // Adicionar nomes 
	        gbc2.gridy = 0;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(itemComp, gbc2);
	        
	        // Adicionar campos preenchidos
	        gbc2.gridy = 1;
	        
	        gbc2.gridx = 0;
	        panelCentral.add(botaoItem, gbc2);
	        
	        // adicionar botao de salvar peça
	        gbc3.gridy = 0;
	        
	        gbc3.gridx = 0;
	        panelDireito.add(V,gbc3);
	        gbc3.gridx = 1;
	        panelDireito.add(salvar,gbc3);
	        
	        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
	        panePrincipal.add(panelCentral, BorderLayout.CENTER);
	        panePrincipal.add(panelDireito, BorderLayout.EAST);
        }else {
        	JLabel X = new JLabel(maquinadelavar_redim2, SwingConstants.CENTER);
	        X.setPreferredSize(new Dimension(200, 200));
	        JLabel nome_parteCima = new JLabel("Não Há Peças Emprestadas!", SwingConstants.CENTER);
	        nome_parteCima.setPreferredSize(new Dimension(200,50));
	        nome_parteCima.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        gbc.gridy = 0;
	        gbc.gridx = 0;
	        panelEsquerdo.add(X, gbc);
	        gbc.gridy = 1;	        
	        gbc.gridx = 0;
	        panelEsquerdo.add(nome_parteCima, gbc);
	        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
        }
	    pack();
        setVisible(true);
	}
	
	private void verTempEmp() {
		try {
			if(itemtemp.getEmprestado().equals("Emprestado")) {
				if(itemtemp.getParte().equals("ParteCima")) {
					itemtemp = (ParteCima) itemtemp;
				}else if(itemtemp.getParte().equals("ParteBaixo")) {
					itemtemp = (ParteBaixo) itemtemp;
				}else if(itemtemp.getParte().equals("Calcado")) {
					itemtemp = (Calcado) itemtemp;
				}else if(itemtemp.getParte().equals("Acessorio")) {
					itemtemp = (Acessorio) itemtemp;
				}
				int dias = itemtemp.quantidadeDeDiasDesdeOEmprestimo();
				JOptionPane.showMessageDialog(this, "O item está emprestado há " + dias + " dias!");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Esta peça não está emprestada!");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro :"+e.getMessage());
		}
	}
}
