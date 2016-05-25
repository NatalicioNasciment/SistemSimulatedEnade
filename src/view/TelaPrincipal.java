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
        super("Sistem Simuled Enade");
        
        Container principal = getContentPane();
        Container menu = new JPanel();
        Container conteudo = new JPanel();
    
        JMenuBar barraMenu = new JMenuBar();
        JMenu cadastro = new JMenu("Cadastro    ");
        JMenu Relatorios = new JMenu("Relatorios");
        
        JMenuItem menuItemAluno = new JMenuItem("  Aluno");
        JMenuItem menuItemProva = new JMenuItem(" Prova");
        JMenuItem menuItemQuestoes = new JMenuItem("Questões");
        
        barraMenu.add(cadastro);
        cadastro.add(menuItemAluno);
        cadastro.add(menuItemProva);
        cadastro.add(menuItemQuestoes);
        
        menuItemAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                alunoActionPerformed(evento);
            }
        });
        
        barraMenu.add(Relatorios);
        
    
        
        
        conteudo.setLayout(new GridLayout(1,1));
    
       principal.add(BorderLayout.NORTH, barraMenu);
        principal.add(BorderLayout.CENTER,conteudo);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void alunoActionPerformed(ActionEvent evento){
       //new CadastroAluno();
    }

    
    public static void main(String[] args) {
           new TelaPrincipal();
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}