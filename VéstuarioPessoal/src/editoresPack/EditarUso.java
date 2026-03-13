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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backEnd.Look;
import backEnd.Uso;
import bancoDados.ExcluirTudo;

public class EditarUso extends JFrame{
	Look look;
	private JTextArea editar_data;
	private JTextArea editar_horario;
	private JTextArea editar_local;
	public EditarUso(String titulo, Vector<Look> looks,Look look, Vector<Uso> usos) {
        super(titulo);
        this.look = look;
        
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
        imagemRedim = ft_disquete.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon disquete_redim = new ImageIcon(imagemRedim);
        ImageIcon ft_mais = new ImageIcon("./imagens/mais.png");
        imagemRedim = ft_mais.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon mais_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_look = new JLabel(look_redim, SwingConstants.CENTER);
        ft_look.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_look = new JLabel(look.getNome(), SwingConstants.CENTER);
        nome_look.setPreferredSize(new Dimension(200,50));
        nome_look.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Componentes
        
        JLabel usosLook = new JLabel("uso :", SwingConstants.CENTER);
        usosLook.setPreferredSize(new Dimension(200, 50));
        editar_data = new JTextArea();
        editar_data.setPreferredSize(new Dimension(100, 50));
        editar_data.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_data.setAlignmentX(SwingConstants.CENTER);
        editar_data.setText("ex:dd/mm/aaaa");
        editar_horario = new JTextArea();
        editar_horario.setPreferredSize(new Dimension(100, 50));
        editar_horario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_horario.setAlignmentX(SwingConstants.CENTER);
        editar_horario.setText("ex:hh:mm");
        editar_local = new JTextArea();
        editar_local.setPreferredSize(new Dimension(100, 50));
        editar_local.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editar_local.setAlignmentX(SwingConstants.CENTER);
        editar_local.setText("ex:UFC");
        
        JLabel mais = new JLabel(ft_mais, SwingConstants.CENTER);
        mais.setPreferredSize(new Dimension(100,100));
        JButton adicionar = new JButton("Adicionar o uso");
        adicionar.addActionListener(e -> salvarAlteracoes(looks,look, usos));
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_look, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(nome_look, gbc);
        
        //adicionar componentes
        gbc2.gridy = 0;
        gbc2.gridx = 0;
        panelCentral.add(usosLook, gbc2);
        gbc2.gridy = 1;
        panelCentral.add(editar_data,gbc2);
        gbc2.gridy = 2;
        panelCentral.add(editar_horario,gbc2);
        gbc2.gridy = 3;
        panelCentral.add(editar_local,gbc2);
        
        //adicionar botao de adicionar uso
        gbc3.gridy = 0;
        
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
	private void salvarAlteracoes(Vector<Look> looks,Look look, Vector<Uso> usos) {
		try {
			String datatemp = editar_data.getText();
			String horariotemp = editar_horario.getText();
			String localtemp = editar_local.getText();
			Uso usotemp = new Uso(datatemp,horariotemp,localtemp);
			usos.add(usotemp);
			ExcluirTudo excluidor = new ExcluirTudo();
			excluidor.excluirLooks();
			for(int i = 0; i < looks.size(); i++) {
				looks.get(i).salvar();
			}
			this.dispose();
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro de formato!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar o uso :"+e.getMessage());
		}
	}
}
