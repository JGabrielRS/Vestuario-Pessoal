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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backEnd.Look;
import backEnd.Uso;
import bancoDados.ExcluirTudo;
import itensPack.Item;

public class EditorLook extends JFrame{
	private Look look;
	private Vector<Item> itens = new Vector<>();
	private Vector<Item> parteCima = new Vector<>();
	private Vector<Item> parteBaixo = new Vector<>();
	private Vector<Item> calcado = new Vector<>();
	private Vector<Item> acessorio = new Vector<>();
	private Vector<Item> parteIntima = new Vector<>();
	private Vector<Look> looks = new Vector<>();
	private JTextArea editar_qntUso;
	private Item parteCimatemp;
	private Item parteBaixotemp;
	private Item calcadotemp;
	private Item parteIntimatemp;
	private Item acessoriotemp;
	private Uso usotemp;
	
	public EditorLook(String titulo, Vector<Item> itens, Vector<Look> looks, Vector<Item> parteCima, Vector<Item> parteBaixo, Vector<Item> calcado, Vector<Item> acessorio, Vector<Item> parteIntima, Look look) {
		super(titulo);
        this.itens = itens;
        this.parteCima = parteCima;
        this.parteBaixo = parteBaixo;
        this.calcado = calcado;
        this.acessorio = acessorio;
        this.parteIntima = parteIntima;
        this.looks = looks;
        this.parteCimatemp = look.mostrarParteCima();
        this.parteBaixotemp = look.mostrarParteBaixo();
        this.calcadotemp = look.mostrarCalcado();
        this.parteIntimatemp = look.mostrarParteIntima();
        this.acessoriotemp = look.mostrarAcessorio();
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
        
        ImageIcon ft_look1 = new ImageIcon("./imagens/look.png");
        Image imagemRedim = ft_look1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon look_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_disquete = new ImageIcon("./imagens/disquete.png");
        imagemRedim = ft_disquete.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon disquete_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_mais = new ImageIcon("./imagens/mais.png");
        imagemRedim = ft_mais.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon mais_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_look = new JLabel(look_redim, SwingConstants.CENTER);
        ft_look.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_look = new JLabel(look.getNome(), SwingConstants.CENTER);
        nome_look.setPreferredSize(new Dimension(200,50));
        nome_look.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Componentes
        JLabel parteCimaComp = new JLabel("parte de cima:", SwingConstants.CENTER);
        parteCimaComp.setPreferredSize(new Dimension(200, 50));  // Tamanho fixo para imagem
        
        JLabel parteBaixoComp = new JLabel("parte de baixo:", SwingConstants.CENTER);
        parteBaixoComp.setPreferredSize(new Dimension(200, 50));
        
        JLabel calcadoComp = new JLabel("calçado:", SwingConstants.CENTER);
        calcadoComp.setPreferredSize(new Dimension(200, 50));

        JLabel usosComp = new JLabel("usos:", SwingConstants.CENTER);
        usosComp.setPreferredSize(new Dimension(200, 50));
        
        JLabel parteIntimaComp = new JLabel("parte intima:", SwingConstants.CENTER);
        parteIntimaComp.setPreferredSize(new Dimension(200, 50));
        
        JLabel qntUso = new JLabel("quantidade de usos:", SwingConstants.CENTER);
        qntUso.setPreferredSize(new Dimension(200, 50));
        
        JLabel acessorioComp = new JLabel("acessorio:", SwingConstants.CENTER);
        acessorioComp.setPreferredSize(new Dimension(200, 50));
        
        JButton botaoParteCima = new JButton(parteCimatemp != null ? parteCimatemp.getTipo() : "Selecionar");
        JButton botaoParteBaixo = new JButton(parteBaixotemp != null ? parteBaixotemp.getTipo() : "Selecionar");
        JButton botaoParteIntima = new JButton(parteIntimatemp != null ? parteIntimatemp.getTipo() : "Selecionar");
        JButton botaoCalcado = new JButton(calcadotemp != null ? calcadotemp.getTipo() : "Selecionar");
        JButton botaoAcessorio = new JButton(acessoriotemp != null ? acessoriotemp.getTipo() : "Selecionar");
        JButton botaoUsos = new JButton(usotemp != null ? usotemp.local : "Selecionar");
        
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
        JPopupMenu menuUsos = new JPopupMenu();
        if (look.getUso() != null && !look.getUso().isEmpty()) {
            for (int i = 0; i < parteBaixo.size(); i++) {
                Uso item = look.getUso().get(i);
            	JMenuItem menuItem = new JMenuItem(item.local);
            	menuItem.addActionListener(e -> {usotemp = item; botaoUsos.setText(item.local);});
            	menuUsos.add(menuItem);
            }
        } else {
            menuUsos.add(new JMenuItem("Nenhum item disponível"));
        }
        botaoUsos.addActionListener(e -> menuUsos.show(botaoUsos, 0, botaoUsos.getHeight()));
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
        JPopupMenu menuAcessorio = new JPopupMenu();
        if (acessorio != null && !acessorio.isEmpty()) {
            for (int i = 0; i < acessorio.size(); i++) {
                Item item = acessorio.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
            	menuItem.addActionListener(e -> {acessoriotemp = item; botaoAcessorio.setText(item.getTipo());});
            	menuAcessorio.add(menuItem);
            }
        } else {
        	menuAcessorio.add(new JMenuItem("Nenhum item disponível"));
        }
        botaoAcessorio.addActionListener(e -> menuAcessorio.show(botaoAcessorio, 0, botaoAcessorio.getHeight()));
        
        editar_qntUso = new JTextArea();
        editar_qntUso.setPreferredSize(new Dimension(100, 50));
        editar_qntUso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_qntUso.setAlignmentX(SwingConstants.CENTER);
        editar_qntUso.setText(Integer.toString(look.getQntUso()));
        
        JLabel disquete = new JLabel(disquete_redim, SwingConstants.CENTER);
        disquete.setPreferredSize(new Dimension(100,100));
        JButton salvar = new JButton("Salvar alterações");
        salvar.addActionListener(e -> salvarAlteracoes(looks, look));
        
        JLabel mais = new JLabel(mais_redim, SwingConstants.CENTER);
        mais.setPreferredSize(new Dimension(100,100));
        JButton adicionar = new JButton("Adicionar uso");
        adicionar.addActionListener(e -> new EditarUso("Adicionar Uso",looks, look, look.getUso()));
        
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
        panelCentral.add(parteCimaComp, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(parteBaixoComp, gbc2);
        
        gbc2.gridy = 2;
        
        gbc2.gridx = 0;
        panelCentral.add(calcadoComp, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(usosComp, gbc2);
        
        gbc2.gridy = 4;
        
        gbc2.gridx = 0;
        panelCentral.add(parteIntimaComp, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(qntUso, gbc2);
        
        gbc2.gridx = 2;
        panelCentral.add(acessorioComp, gbc2);
        
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
        panelCentral.add(botaoUsos, gbc2);
        
        gbc2.gridy = 5;
        
        gbc2.gridx = 0;
        panelCentral.add(botaoParteIntima, gbc2);
        
        gbc2.gridx = 1;
        panelCentral.add(editar_qntUso, gbc2);
        
        gbc2.gridx = 2;
        panelCentral.add(botaoAcessorio,gbc2);
        
        // adicionar botao de salvar peça
        gbc3.gridy = 0;
        
        gbc3.gridx = 0;
        panelDireito.add(disquete,gbc3);
        gbc3.gridx = 1;
        panelDireito.add(salvar,gbc3);
        
        gbc3.gridy = 1;
        
        gbc3.gridx = 0;
        panelDireito.add(mais,gbc3);
        gbc3.gridx = 1;
        panelDireito.add(adicionar,gbc3);
        
        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        panePrincipal.add(panelDireito, BorderLayout.EAST);
        pack();
        setVisible(true);
	}
	
	private void salvarAlteracoes(Vector<Look> looks, Look look) {
		try {
			looks.remove(look);
			look.mudarParteCima(parteCimatemp);
			look.mudarParteBaixo(parteBaixotemp);
			look.mudarCalcado(calcadotemp);
			look.mudarAcessorio(acessoriotemp);
			look.mudarParteIntima(parteIntimatemp);
			look.registrarUso(usotemp);
            int novaQntUso = Integer.parseInt(editar_qntUso.getText());
			look.mudarQntUso(novaQntUso);
			looks.add(look);
            ExcluirTudo excluidor = new ExcluirTudo();
			excluidor.excluirLooks();
			for(int i = 0; i < looks.size(); i++) {
				looks.get(i).salvar();
			}
			this.dispose();
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro de formato!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar o look :"+e.getMessage());
		}
	}
}
