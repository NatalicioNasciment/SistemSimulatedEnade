package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerCurso;
import model.*;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class Curso extends JFrame {
	
	ConectaBanco conectaCurso = new ConectaBanco();
	ConectaBanco conectaCampus = new ConectaBanco();
	ConectaBanco conectaArea = new ConectaBanco();

	private JPanel contentPane;
	private JTextField nome_curso;
	JComboBox campus_curso;
	JComboBox area_curso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Curso frame = new Curso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Curso() {
		carregarComponentes();
		conectaCurso.conexao();
		conectaCampus.conexao();
		conectaArea.conexao();
		
		conectaCampus.executaSQL("SELECT * FROM campus");
		campus_curso.removeAllItems();
		
		try {
			conectaCampus.rs.first();
			do {
				campus_curso.addItem(conectaCampus.rs.getString("campus"));

			} while (conectaCampus.rs.next());

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar campus"+e.getMessage());
		}
		
		conectaArea.executaSQL("SELECT * FROM area_curso");
		area_curso.removeAllItems();
		
		try {
			conectaArea.rs.first();
			do {
				area_curso.addItem(conectaArea.rs.getString("area"));

			} while (conectaArea.rs.next());

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar area" + e.getMessage());
		}
		
	}
	
	private void carregarComponentes(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(10, 36, 764, 374);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(39, 31, 57, 14);
		panel.add(lblNewLabel);
		
		nome_curso = new JTextField();
		nome_curso.setBounds(85, 30, 273, 20);
		panel.add(nome_curso);
		nome_curso.setColumns(10);
		
		JLabel lblCampus = new JLabel("Campus: ");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCampus.setBounds(368, 31, 78, 14);
		panel.add(lblCampus);
		
		JList list = new JList();
		list.setBounds(493, 143, -40, -98);
		panel.add(list);
		
		campus_curso = new JComboBox();
		campus_curso.setBounds(434, 30, 116, 20);
		panel.add(campus_curso);
		
		JLabel label = new JLabel("Área: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(572, 31, 78, 14);
		panel.add(label);
		
		area_curso = new JComboBox();
		area_curso.setBounds(622, 30, 116, 20);
		panel.add(area_curso);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(33, 61, 705, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton adicionar = new JButton("");
		adicionar.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_add.png")));
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		adicionar.setBounds(20, 11, 54, 34);
		panel_1.add(adicionar);
		
		JButton salvar = new JButton("");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				salvarActionPerformed(evento);
			}
		});
			
		salvar.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_accept.png")));
		salvar.setBounds(84, 11, 54, 34);
		panel_1.add(salvar);
		
		JButton editar = new JButton("");
		editar.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_edit.png")));
		editar.setBounds(148, 11, 54, 34);
		panel_1.add(editar);
		
		JButton remover = new JButton("");
		remover.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_remove.png")));
		remover.setBounds(212, 11, 54, 34);
		panel_1.add(remover);
		
		JButton primeiro = new JButton("");
		primeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				primeiroActionPerformed(evento);
			}
		});
		primeiro.setIcon(new ImageIcon(Curso.class.getResource("/imagens/primeiro.png")));
		primeiro.setBounds(347, 11, 54, 34);
		panel_1.add(primeiro);
		
		JButton anterior = new JButton("");
		anterior.setIcon(new ImageIcon(Curso.class.getResource("/imagens/anterior.png")));
		anterior.setBounds(411, 11, 54, 34);
		panel_1.add(anterior);
		
		JButton proximo = new JButton("");
		proximo.setIcon(new ImageIcon(Curso.class.getResource("/imagens/proximo.png")));
		proximo.setBounds(481, 11, 54, 34);
		panel_1.add(proximo);
		
		JButton ultimo = new JButton("");
		ultimo.setIcon(new ImageIcon(Curso.class.getResource("/imagens/ultimo.png")));
		ultimo.setBounds(545, 11, 54, 34);
		panel_1.add(ultimo);
		
		JButton sair = new JButton("");
		sair.setIcon(new ImageIcon(Curso.class.getResource("/imagens/process_remove.png")));
		sair.setBounds(641, 11, 54, 34);
		panel_1.add(sair);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(33, 128, 705, 235);
		panel.add(panel_2);
		
		
		JLabel lblCadastroDeCurso = new JLabel("Cadastro de Curso");
		lblCadastroDeCurso.setForeground(SystemColor.windowBorder);
		lblCadastroDeCurso.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroDeCurso.setBounds(304, 11, 192, 14);
		contentPane.add(lblCadastroDeCurso);
	}

	private void salvarActionPerformed(ActionEvent evento) {
		try {
			ModelCurso modeloCurso = new ModelCurso();
			
			modeloCurso.setNome(nome_curso.getText());
			
			
			conectaCampus.executaSQL("SELECT * FROM campus WHERE campus='" + campus_curso.getSelectedItem() + "'");
			conectaCampus.rs.first();
			modeloCurso.setCampus(conectaCampus.rs.getInt("id_campus"));
			
			conectaArea.executaSQL("SELECT * FROM area_curso WHERE area='" + area_curso.getSelectedItem() + "'");
			conectaArea.rs.first();
			modeloCurso.setArea(conectaArea.rs.getInt("id_area"));
			
			ControllerCurso controleCurso = new ControllerCurso();
			controleCurso.inserirCurso(modeloCurso);
		

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar" + e);
		}
	}
	
	private void primeiroActionPerformed(ActionEvent evento) {
		
	}
	
	
	
	
}