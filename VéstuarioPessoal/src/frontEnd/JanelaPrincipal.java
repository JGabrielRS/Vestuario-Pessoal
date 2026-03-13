package frontEnd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import backEnd.Look;
import bancoDados.CarregarDados;
import bancoDados.Ler;
import criarPack.CriarLook;
import criarPack.criarAcessorio;
import criarPack.criarCalcado;
import criarPack.criarParteBaixo;
import criarPack.criarParteCima;
import criarPack.criarParteIntima;
import estatisticaPack.Estatistica;
import itensPack.Item;
import menusEspeciaisPack.JanelaEmprestimo;
import menusEspeciaisPack.JanelaLavagem;

public class JanelaPrincipal extends JFrame{
	Vector<Item> itens = new Vector<>();
	Vector<Item> parteCima = new Vector<>();
	Vector<Item> parteBaixo = new Vector<>();
	Vector<Item> calcado = new Vector<>();
	Vector<Item> acessorio = new Vector<>();
	Vector<Item> parteIntima = new Vector<>();
	Vector<Look> looks = new Vector<>();
	public JanelaPrincipal(String titulo) throws FileNotFoundException {
        super(titulo);
        this.itens = CarregarDados.carregarItens();
        this.looks = CarregarDados.carregarLooks();
        this.parteCima = CarregarDados.filtrarPorTipo(itens, "ParteCima");
        this.parteBaixo = CarregarDados.filtrarPorTipo(itens, "ParteBaixo");
        this.calcado = CarregarDados.filtrarPorTipo(itens, "Calcado");
        this.acessorio = CarregarDados.filtrarPorTipo(itens, "Acessorio");
        this.parteIntima = CarregarDados.filtrarPorTipo(itens, "ParteIntima");
        
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
        
        // imagens
        ImageIcon ft_camisa = new ImageIcon("./imagens/camisa.png");
        Image imagemRedim = ft_camisa.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon camisa_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_calca = new ImageIcon("./imagens/calca.png");
        imagemRedim = ft_calca.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon calca_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_cueca = new ImageIcon("./imagens/cueca.png");
        imagemRedim = ft_cueca.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon cueca_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_sapato = new ImageIcon("./imagens/tenis.png");
        imagemRedim = ft_sapato.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon sapato_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_relogio = new ImageIcon("./imagens/relogio.png");
        imagemRedim = ft_relogio.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon acessorio_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_look1 = new ImageIcon("./imagens/look.png");
        imagemRedim = ft_look1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon look_redim = new ImageIcon(imagemRedim);
        
        ImageIcon ft_maiscamisa = new ImageIcon("./imagens/camisa_mais.png");
        Image imagemRedim2 = ft_maiscamisa.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscamisa_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maiscalca = new ImageIcon("./imagens/calca_mais.png");
        imagemRedim2 = ft_maiscalca.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscalca_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maiscueca = new ImageIcon("./imagens/cueca_mais.png");
        imagemRedim2 = ft_maiscueca.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maiscueca_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maissapato = new ImageIcon("./imagens/tenis_mais.png");
        imagemRedim2 = ft_maissapato.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maissapato_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maisrelogio = new ImageIcon("./imagens/relogio_mais.png");
        imagemRedim2 = ft_maisrelogio.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maisacessorio_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maislook1 = new ImageIcon("./imagens/look_mais.png");
        imagemRedim2 = ft_maislook1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maislook_redim = new ImageIcon(imagemRedim2);
        
        ImageIcon ft_grafico = new ImageIcon("./imagens/grafico.png");
        imagemRedim2 = ft_grafico.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon grafico_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_emprestimo = new ImageIcon("./imagens/emprestimo.png");
        imagemRedim2 = ft_emprestimo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon emprestimo_redim = new ImageIcon(imagemRedim2);
        ImageIcon ft_maquinadelavar = new ImageIcon("./imagens/maquinadelavar.png");
        imagemRedim2 = ft_maquinadelavar.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon maquinadelavar_redim = new ImageIcon(imagemRedim2);
        
        ImageIcon ft_recarregar = new ImageIcon("./imagens/recarregar.png");
        imagemRedim2 = ft_recarregar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon recarregar_redim = new ImageIcon(imagemRedim2);
        
        // Componentes
        JLabel ft_parteCima = new JLabel(camisa_redim, SwingConstants.CENTER);
        ft_parteCima.setPreferredSize(new Dimension(200, 200));  
        
        JLabel ft_parteBaixo = new JLabel(calca_redim, SwingConstants.CENTER);
        ft_parteBaixo.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_parteIntima = new JLabel(cueca_redim, SwingConstants.CENTER);
        ft_parteIntima.setPreferredSize(new Dimension(200, 200));

        JLabel ft_calcado = new JLabel(sapato_redim, SwingConstants.CENTER);
        ft_calcado.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_acessorio = new JLabel(acessorio_redim, SwingConstants.CENTER);
        ft_acessorio.setPreferredSize(new Dimension(200, 200));
        
        JLabel ft_look = new JLabel(look_redim, SwingConstants.CENTER);
        ft_look.setPreferredSize(new Dimension(200, 200));
        
        JButton botaoParteCima = new JButton("Partes de Cima");
        JButton botaoParteBaixo = new JButton("Partes de Baixo");
        JButton botaoParteIntima = new JButton("Partes Intimas");
        JButton botaoCalcado = new JButton("Calcados");
        JButton botaoAcessorio = new JButton("Acessorios");
        JButton botaoLook = new JButton("Looks");
        
        // Configurar popup menus
        JPopupMenu menuParteCima = new JPopupMenu();
        if (parteCima != null && !parteCima.isEmpty()) {
            for (int i = 0; i < parteCima.size(); i++) {
                Item item = parteCima.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
                menuItem.addActionListener(e -> new JanelaParteCima(item.getTipo(), item, itens));
                menuParteCima.add(menuItem);
                botaoParteCima.addActionListener(e -> menuParteCima.show(botaoParteCima, 0, botaoParteCima.getHeight()));
            }
        } else {
            menuParteCima.add(new JMenuItem("Nenhum item disponível"));
        }
        JPopupMenu menuParteBaixo = new JPopupMenu();
        if (parteBaixo != null && !parteBaixo.isEmpty()) {
            for (int i = 0; i < parteBaixo.size(); i++) {
                Item item = parteBaixo.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
                menuItem.addActionListener(e -> new JanelaParteBaixo(item.getTipo(), item, itens));
                menuParteBaixo.add(menuItem);
                botaoParteBaixo.addActionListener(e -> menuParteBaixo.show(botaoParteBaixo, 0, botaoParteBaixo.getHeight()));
            }
        } else {
        	menuParteBaixo.add(new JMenuItem("Nenhum item disponível"));
        }
        JPopupMenu menuParteIntima = new JPopupMenu();
        if (parteIntima != null && !parteIntima.isEmpty()) {
            for (int i = 0; i < parteIntima.size(); i++) {
                Item item = parteIntima.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
                menuItem.addActionListener(e -> new JanelaParteIntima(item.getTipo(), item, itens));
                menuParteIntima.add(menuItem);
                botaoParteIntima.addActionListener(e -> menuParteIntima.show(botaoParteIntima, 0, botaoParteIntima.getHeight()));
            }
        } else {
        	menuParteIntima.add(new JMenuItem("Nenhum item disponível"));
        }
        JPopupMenu menuCalcado = new JPopupMenu();
        if (calcado != null && !calcado.isEmpty()) {
            for (int i = 0; i < calcado.size(); i++) {
                Item item = calcado.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
                menuItem.addActionListener(e -> new JanelaCalcado(item.getTipo(), item, itens));
                menuCalcado.add(menuItem);
                botaoCalcado.addActionListener(e -> menuCalcado.show(botaoCalcado, 0, botaoCalcado.getHeight()));
            }
        } else {
        	menuCalcado.add(new JMenuItem("Nenhum item disponível"));
        }
        JPopupMenu menuAcessorio = new JPopupMenu();
        if (acessorio != null && !acessorio.isEmpty()) {
            for (int i = 0; i < acessorio.size(); i++) {
                Item item = acessorio.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getTipo());
                menuItem.addActionListener(e -> new JanelaAcessorio(item.getTipo(), item, itens));
                menuAcessorio.add(menuItem);
                botaoAcessorio.addActionListener(e -> menuAcessorio.show(botaoAcessorio, 0, botaoAcessorio.getHeight()));
            }
        } else {
        	menuAcessorio.add(new JMenuItem("Nenhum item disponível"));
        }
        JPopupMenu menuLook = new JPopupMenu();
        if (looks != null && !looks.isEmpty()) {
            for (int i = 0; i < looks.size(); i++) {
                Look item = looks.get(i);
            	JMenuItem menuItem = new JMenuItem(item.getNome());
                menuItem.addActionListener(e -> new JanelaLook(item.getNome(), itens, looks, parteCima, parteBaixo, calcado, acessorio, parteIntima, item));
                menuLook.add(menuItem);
                botaoLook.addActionListener(e -> menuLook.show(botaoLook, 0, botaoLook.getHeight()));
            }
        } else {
        	menuLook.add(new JMenuItem("Nenhum item disponível"));
        }
        
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
        
        JButton criarParteCima = new JButton("Criar Parte de Cima");
        criarParteCima.addActionListener(e -> new criarParteCima("Criar Parte de Cima", itens));
        JButton criarParteBaixo = new JButton("Criar Parte de Baixo");
        criarParteBaixo.addActionListener(e -> new criarParteBaixo("Criar Parte de Baixo", itens));
        JButton criarParteIntima = new JButton("Criar Parte Intima");
        criarParteIntima.addActionListener(e -> new criarParteIntima("Criar Parte Intima", itens));
        JButton criarCalcado = new JButton("Criar Calcado");
        criarCalcado.addActionListener(e -> new criarCalcado("Criar Calçado", itens));
        JButton criarAcessorio = new JButton("Criar Acessorio");
        criarAcessorio.addActionListener(e -> new criarAcessorio("Criar Acessorio", itens));
        JButton criarLook = new JButton("Criar Look");
        criarLook.addActionListener(e -> new CriarLook("Criar Look", itens,looks,parteCima,parteBaixo,calcado,acessorio,parteIntima));
        
        JLabel recarregarpagina = new JLabel(recarregar_redim, SwingConstants.CENTER);
        JButton recarregar = new JButton("Recarregar Página");
        recarregar.addActionListener(e -> {
			try {recarregarPaginaAtual(titulo);} catch (Exception e1) {e1.printStackTrace();}});

        
        JLabel maiscamisa = new JLabel(maiscamisa_redim, SwingConstants.CENTER);
        maiscamisa.setPreferredSize(new Dimension(150, 150));  
        JLabel maiscalca = new JLabel(maiscalca_redim, SwingConstants.CENTER);
        maiscalca.setPreferredSize(new Dimension(150, 150));  
        JLabel maissapato = new JLabel(maissapato_redim, SwingConstants.CENTER);
        maissapato.setPreferredSize(new Dimension(150, 150));  
        JLabel maiscueca = new JLabel(maiscueca_redim, SwingConstants.CENTER);
        maiscueca.setPreferredSize(new Dimension(150, 150));  
        JLabel maisacessorio = new JLabel(maisacessorio_redim, SwingConstants.CENTER);
        maisacessorio.setPreferredSize(new Dimension(150, 150));  
        JLabel maislook = new JLabel(maislook_redim, SwingConstants.CENTER);
        maislook.setPreferredSize(new Dimension(150, 150));  
        
        JButton estatisticas = new JButton("Estatísticas");
        estatisticas.addActionListener(e -> new Estatistica("Estatísticas",itens,looks,parteCima,parteBaixo,calcado,acessorio,parteIntima));
        JButton emprestimos = new JButton("Empréstimos");
        emprestimos.addActionListener(e -> new JanelaEmprestimo("Empréstimos",itens,looks,parteCima,parteBaixo,calcado,acessorio,parteIntima));
        JButton lavagem = new JButton("Lavagem");
        lavagem.addActionListener(e -> new JanelaLavagem("Lavagem",itens,parteCima,parteBaixo,calcado,parteIntima));
        
        JLabel ft_estatistica = new JLabel(grafico_redim, SwingConstants.CENTER);
        ft_estatistica.setPreferredSize(new Dimension(150, 150));  
        JLabel ft_emprestimo1 = new JLabel(emprestimo_redim, SwingConstants.CENTER);
        ft_emprestimo1.setPreferredSize(new Dimension(150, 150));  
        JLabel ft_lavagem = new JLabel(maquinadelavar_redim, SwingConstants.CENTER);
        ft_lavagem.setPreferredSize(new Dimension(150, 150));  
        
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        panelBaixo.add(criarParteCima,gbc2);
        gbc2.gridx = 0;
        panelBaixo.add(maiscamisa,gbc2);
        gbc2.gridx = 3;
        panelBaixo.add(criarParteBaixo,gbc2);
        gbc2.gridx = 2;
        panelBaixo.add(maiscalca,gbc2);
        gbc2.gridx = 5;
        panelBaixo.add(estatisticas,gbc2);
        gbc2.gridx = 4;
        panelBaixo.add(ft_estatistica,gbc2);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        panelBaixo.add(criarParteIntima,gbc2);
        gbc2.gridx = 0;
        panelBaixo.add(maiscueca,gbc2);
        gbc2.gridx = 3;
        panelBaixo.add(criarCalcado,gbc2);
        gbc2.gridx = 2;
        panelBaixo.add(maissapato,gbc2);
        gbc2.gridx = 5;
        panelBaixo.add(emprestimos,gbc2);
        gbc2.gridx = 4;
        panelBaixo.add(ft_emprestimo1,gbc2);
        gbc2.gridy = 2;
        gbc2.gridx = 1;
        panelBaixo.add(criarAcessorio,gbc2);
        gbc2.gridx = 0;
        panelBaixo.add(maisacessorio,gbc2);
        gbc2.gridx = 3;
        panelBaixo.add(criarLook,gbc2);
        gbc2.gridx = 2;
        panelBaixo.add(maislook,gbc2);
        gbc2.gridx = 5;
        panelBaixo.add(lavagem,gbc2);
        gbc2.gridx = 4;
        panelBaixo.add(ft_lavagem,gbc2);
        gbc2.gridy = 1;
        gbc2.gridx = 6;
        panelBaixo.add(recarregarpagina,gbc2);
        gbc2.gridx = 7;
        panelBaixo.add(recarregar,gbc2);
        
        
        panePrincipal.add(panelCima, BorderLayout.NORTH);
        panePrincipal.add(panelBaixo, BorderLayout.SOUTH);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
	private void recarregarPaginaAtual(String titulo) throws FileNotFoundException {
		this.dispose();
		new JanelaPrincipal(titulo);
	}
}
