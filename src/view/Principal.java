package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

import model.ConectaBanco;

import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	ConectaBanco conecta = new ConectaBanco();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		carregarComponentes();
		conecta.conexao();

	}

	private void carregarComponentes() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("  Cadastro      ");
		menuBar.add(mnCadastro);

		
		JMenuItem campus = new JMenuItem("Campus");
		campus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				campusActionPerformed(evento);
			}

			
		});
		
		JMenuItem area_curso = new JMenuItem("Area Curso");
		area_curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				areaCursoActionPerformed(evento);
			} 

			
		});
		
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cursoActionPerformed(evento);
			}
		});
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		
		mntmAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		mntmAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				alunoActionPerformed(evento);

			}

			private void alunoActionPerformed(ActionEvent evento) {
				Aluno cadAluno = new Aluno();
				cadAluno.setVisible(true);

			}
		});
		
		JMenuItem mntmProva = new JMenuItem("Prova");
		mntmProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				provaActionPerformed(evento);
			}
		});
		
		JMenuItem mntmQuestes = new JMenuItem("Quest\u00F5es");
		mntmQuestes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				questoesActionPerformed(evento);
			}

			
		});
		
		mnCadastro.add(campus);
		mnCadastro.add(area_curso);
		mnCadastro.add(mntmCurso);
		mnCadastro.add(mntmAluno);
		mnCadastro.add(mntmProva);
		mnCadastro.add(mntmQuestes);
		

		JMenu menu = new JMenu("Relatórios");
		menuBar.add(menu);
		
		contentPane = new JPanel();
	
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void campusActionPerformed(ActionEvent evento) {
			Campus cadastroCampus = new Campus();
			cadastroCampus.setVisible(true);
			
	}
	
	private void areaCursoActionPerformed(ActionEvent evento) {
		ExCurso cadastroAreaCurso = new ExCurso();
		cadastroAreaCurso.setVisible(true);
		
	}
	
	private void cursoActionPerformed(ActionEvent evento) {
		Curso cadCurso = new Curso();
		cadCurso.setVisible(true);

	}
	
	private void provaActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	private void questoesActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
}
