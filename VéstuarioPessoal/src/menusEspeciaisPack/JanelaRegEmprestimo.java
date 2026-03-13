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
import bancoDados.ExcluirTudo;
import itensPack.Item;
import itensPack.ParteIntima;

public class JanelaRegEmprestimo extends JFrame{
	private Vector<Item> itens = new Vector<>();
	private Item itemtemp;

	
	public JanelaRegEmprestimo(String titulo, Vector<Item> itens) {
		super(titulo);
        this.itens = itens;
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
        
        ImageIcon ft_grafico = new ImageIcon("./imagens/maisemprestimo.png");
        Image imagemRedim2 = ft_grafico.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon grafico_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_emprestimo = new ImageIcon("./imagens/check.png");
        imagemRedim2 = ft_emprestimo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon emprestimo_redim = new ImageIcon(imagemRedim2);
        // foto e tipo
        JLabel ft_registro = new JLabel(grafico_redim, SwingConstants.CENTER);
        ft_registro.setPreferredSize(new Dimension(200, 200));
        
        JLabel regEmprestimo = new JLabel("Registrar Empréstimo", SwingConstants.CENTER);
        regEmprestimo.setPreferredSize(new Dimension(200,50));
        regEmprestimo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Componentes
        JLabel itemComp = new JLabel("Item:", SwingConstants.CENTER);
        itemComp.setPreferredSize(new Dimension(200, 50));
        
        JButton botaoItem = new JButton(itemtemp != null ? itemtemp.getTipo() : "Selecionar");
        
        JPopupMenu menuItemEscolhido = new JPopupMenu();
        if (itens != null && !itens.isEmpty()) {
            for (int i = 0; i < itens.size(); i++) {
                Item item = itens.get(i);
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
        JButton salvar = new JButton("Registrar Empréstimo");
        salvar.addActionListener(e -> regEmpItem(itens));
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_registro, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(regEmprestimo, gbc);
        
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
        pack();
        setVisible(true);
	}
	
	private void regEmpItem(Vector<Item> itens) {
		try {
			if(!(itemtemp instanceof ParteIntima)) {
				itens.remove(itemtemp);
				itemtemp.registrarEmprestimo();
				itens.add(itemtemp);
	            ExcluirTudo excluidor = new ExcluirTudo();
				excluidor.excluirPecas();
				for(int i = 0; i < itens.size(); i++) {
					itens.get(i).salvar();
				}
				JOptionPane.showMessageDialog(this, "Registro Feito!");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Não é possivel fazer emprestimo de uma peça intima!");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao fazer o registo :"+e.getMessage());
		}
	}
}
