package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerAluno;
import model.ConectaBanco;
import model.ModelUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Aluno extends JFrame {

	ConectaBanco conectaAluno = new ConectaBanco();
	ConectaBanco conectaCurso = new ConectaBanco();

	private JPanel contentPane;
	private JTextField matricula;
	private JTextField nome;
	JComboBox curso;
	JComboBox categoria_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aluno frame = new Aluno();
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
	public Aluno() {
		carregarComponentes();
		conectaAluno.conexao();
		conectaCurso.conexao();

		conectaCurso.executaSQL("SELECT * FROM curso ORDER BY nome_curso");
		curso.removeAllItems();

		try {
			conectaCurso.rs.first();
			do {
				curso.addItem(conectaCurso.rs.getString("nome_curso"));
			} while (conectaCurso.rs.next());
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, "Erro ao tentar preencher
			// combobox");
		}

	}

	private void carregarComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 417);
		setSize(800, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		// contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(21, 34, 753, 366);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Matricula: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 30, 80, 14);
		panel.add(lblNewLabel);

		matricula = new JTextField();
		matricula.setBounds(93, 29, 93, 20);
		panel.add(matricula);
		matricula.setColumns(10);

		JLabel label = new JLabel("Nome : ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(204, 32, 80, 14);
		panel.add(label);

		nome = new JTextField();
		nome.setBounds(260, 29, 471, 20);
		panel.add(nome);
		nome.setColumns(10);

		JLabel label_1 = new JLabel("Curso : ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(23, 67, 80, 14);
		panel.add(label_1);

		curso = new JComboBox();
		curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		curso.setBounds(93, 66, 191, 20);
		panel.add(curso);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(23, 92, 705, 56);
		panel.add(panel_1);

		JButton adicionar = new JButton("");
		adicionar.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/user_add.png")));
		adicionar.setBounds(20, 11, 54, 34);
		panel_1.add(adicionar);

		JButton salvar = new JButton("");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				salvarActionPerformed(evento);
			}
		});
		salvar.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/user_accept.png")));
		salvar.setBounds(84, 11, 54, 34);
		panel_1.add(salvar);

		JButton editar = new JButton("");
		editar.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/page_edit.png")));
		editar.setBounds(148, 11, 54, 34);
		panel_1.add(editar);

		JButton remover = new JButton("");
		remover.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/user_remove.png")));
		remover.setBounds(212, 11, 54, 34);
		panel_1.add(remover);

		JButton primeiro = new JButton("");
		primeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				primeiroActionPerformed(evento);
			}
		});
		primeiro.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/primeiro.png")));
		primeiro.setBounds(347, 11, 54, 34);
		panel_1.add(primeiro);

		JButton anterior = new JButton("");
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				anteriorActionPerformed(evento);
			}

			
		});
		anterior.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/anterior.png")));
		anterior.setBounds(411, 11, 54, 34);
		panel_1.add(anterior);

		JButton proximo = new JButton("");
		proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				proximoActionPeformed(evento);
			}
		});
		proximo.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/proximo.png")));
		proximo.setBounds(481, 11, 54, 34);
		panel_1.add(proximo);

		JButton ultimo = new JButton("");
		ultimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				ultimoActionPerformed(evento);
			}

		});
		ultimo.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/ultimo.png")));
		ultimo.setBounds(545, 11, 54, 34);
		panel_1.add(ultimo);

		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(Aluno.class.getResource("/imagens/process_remove.png")));
		button_8.setBounds(641, 11, 54, 34);
		panel_1.add(button_8);

		JLabel lblCategoriausuario = new JLabel("Categoria Usuario:");
		lblCategoriausuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoriausuario.setBounds(296, 64, 128, 22);
		panel.add(lblCategoriausuario);

		categoria_usuario = new JComboBox();
		categoria_usuario.setBounds(421, 66, 119, 20);
		panel.add(categoria_usuario);
		categoria_usuario.addItem("Aluno");

		JLabel lblCadastroDeAluno = new JLabel("Cadastro de Aluno");
		lblCadastroDeAluno.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroDeAluno.setForeground(SystemColor.windowBorder);
		lblCadastroDeAluno.setBounds(293, 11, 213, 23);
		contentPane.add(lblCadastroDeAluno);
	}

	private void salvarActionPerformed(ActionEvent evento) {
		try {

			ModelUsuario modeloUsuario = new ModelUsuario();

			int mat = Integer.parseInt(matricula.getText());
			modeloUsuario.setMatricula(mat);
			modeloUsuario.setNome(nome.getText());

			conectaCurso.executaSQL("SELECT * FROM curso WHERE nome_curso='" + curso.getSelectedItem() + "'");
			conectaCurso.rs.first();
			modeloUsuario.setId_curso(conectaCurso.rs.getInt("id_curso"));
			
			
			ControllerAluno controleAluno = new ControllerAluno();
			controleAluno.inserirAluno(modeloUsuario);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar aluno" + e.getMessage());
		}

	}

	private void primeiroActionPerformed(ActionEvent evento) {
		try {
			conectaAluno.executaSQL("SELECT * FROM usuario ORDER BY id_usuario");
			conectaAluno.rs.first();

			matricula.setText(String.valueOf(conectaAluno.rs.getInt("matricula_usuario")));
			nome.setText(conectaAluno.rs.getString("nome_usuario"));

			conectaCurso.executaSQL("SELECT * FROM curso WHERE id_curso =" + conectaAluno.rs.getInt("id_curso") + "");
			conectaCurso.rs.first();

			curso.setSelectedItem(conectaCurso.rs.getString("nome_curso"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar apresentar primeiro registro" + e.getMessage());
		}

	}
	
	private void anteriorActionPerformed(ActionEvent evento) {
		try {
			conectaAluno.rs.previous();

			matricula.setText(String.valueOf(conectaAluno.rs.getInt("matricula_usuario")));
			nome.setText(conectaAluno.rs.getString("nome_usuario"));

			conectaCurso.executaSQL("SELECT * FROM curso WHERE id_curso =" + conectaAluno.rs.getInt("id_curso"));
			conectaCurso.rs.first();

			curso.setSelectedItem(conectaCurso.rs.getString("nome_curso"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void proximoActionPeformed(ActionEvent evento) {
		try {
			conectaAluno.rs.next();
			matricula.setText(String.valueOf(conectaAluno.rs.getInt("matricula_usuario")));
			nome.setText(conectaAluno.rs.getString("nome_usuario"));

			conectaCurso.executaSQL("SELECT * FROM curso WHERE id_curso =" + conectaAluno.rs.getInt("id_curso"));
			conectaCurso.rs.first();

			curso.setSelectedItem(conectaCurso.rs.getString("nome_curso"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void ultimoActionPerformed(ActionEvent evento) {
		
		try {
			conectaAluno.executaSQL("SELECT * FROM usuario ORDER BY id_usuario");
			conectaAluno.rs.last();

			matricula.setText(String.valueOf(conectaAluno.rs.getInt("matricula_usuario")));
			nome.setText(conectaAluno.rs.getString("nome_usuario"));

			conectaCurso.executaSQL("SELECT * FROM curso WHERE id_curso =" + conectaAluno.rs.getInt("id_curso"));
			conectaCurso.rs.last();

			curso.setSelectedItem(conectaCurso.rs.getString("nome_curso"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
