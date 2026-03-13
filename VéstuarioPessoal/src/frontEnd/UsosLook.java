package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import backEnd.Look;

public class UsosLook extends JFrame{
	Look look;
	public UsosLook(String titulo, Look look) {
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
        
        ImageIcon ft_look1 = new ImageIcon("./imagens/look.png");
        Image imagemRedim = ft_look1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon look_redim = new ImageIcon(imagemRedim);
        // foto e tipo
        JLabel ft_look = new JLabel(look_redim, SwingConstants.CENTER);
        ft_look.setPreferredSize(new Dimension(200, 200));
        
        JLabel nome_look = new JLabel(look.getNome(), SwingConstants.CENTER);
        nome_look.setPreferredSize(new Dimension(200,50));
        nome_look.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Componentes
        for(int i = 0; i < look.getUso().size(); i++) {
        	JLabel usosLook = new JLabel("uso " + (i+1) +":", SwingConstants.CENTER);
            usosLook.setPreferredSize(new Dimension(200, 50));
            JLabel data = new JLabel(look.getUso().get(i).data, SwingConstants.CENTER);
            data.setPreferredSize(new Dimension(100, 50));
            data.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel horario = new JLabel(look.getUso().get(i).horario, SwingConstants.CENTER);
            horario.setPreferredSize(new Dimension(100, 50));
            horario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel local = new JLabel(look.getUso().get(i).local, SwingConstants.CENTER);
            local.setPreferredSize(new Dimension(100, 50));
            local.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gbc2.gridy = 0;
            gbc2.gridx = i;
            panelCentral.add(usosLook, gbc2);            
            gbc2.gridy = 1;           
            panelCentral.add(data, gbc2);         
            gbc2.gridy = 2;          
            panelCentral.add(horario, gbc2);         
            gbc2.gridy = 3;      
            panelCentral.add(local, gbc2);
        } 
        
        // Adicionar imagem
        gbc.gridy = 0;
        
        gbc.gridx = 0;
        panelEsquerdo.add(ft_look, gbc);
        
        // Adicionar tipo
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        panelEsquerdo.add(nome_look, gbc);
        
        panePrincipal.add(panelEsquerdo, BorderLayout.WEST);
        panePrincipal.add(panelCentral, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}