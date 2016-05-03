package view;

import java.awt.BorderLayout;
//import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TelaPrincipal extends JFrame implements ActionListener{
    
    TelaPrincipal(){
        super("Layout Padrão");
        
        Container principal = getContentPane();
        Container menu = new JPanel();
        Container conteudo = new JPanel();
        
        JMenuBar barraMenu = new JMenuBar();
        JMenu cadastro = new JMenu("Cadastro    ");
        JMenu Relatorios = new JMenu("Relatorios");
        
        JMenuItem menuItemCliente = new JMenuItem("Curso");
        JMenuItem menuItemFornecedor = new JMenuItem("Questões");
        JMenuItem menuItemAssociados = new JMenuItem("Assunto");
        
        barraMenu.add(cadastro);
        cadastro.add(menuItemCliente);
        cadastro.add(menuItemFornecedor);
        cadastro.add(menuItemAssociados);
        
        menuItemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                clienteActionPerformed(evento);
            }
        });
        
        barraMenu.add(Relatorios);
        
        
        
        conteudo.setLayout(new GridLayout(1,1));
    
        principal.add(BorderLayout.NORTH, barraMenu);
        principal.add(BorderLayout.CENTER,conteudo);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void clienteActionPerformed(ActionEvent evento){
       
    }

    
    public static void main(String[] args) {
           new TelaPrincipal();
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}