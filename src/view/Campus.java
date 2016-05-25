package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerCampus;
import model.ModelCampus;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Campus extends JFrame {

	private JPanel contentPane;
	private JTextField nomeCampus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Campus frame = new Campus();
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
	public Campus() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 298);
		setSize(674, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(10, 29, 647, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel campus = new JLabel("Campus: ");
		campus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campus.setBounds(34, 12, 69, 14);
		panel.add(campus);
		
		nomeCampus = new JTextField();
		nomeCampus.setBounds(99, 11, 528, 20);
		panel.add(nomeCampus);
		nomeCampus.setColumns(10);
		
		JLabel lblCadastroCampus = new JLabel("Cadastro Campus");
		lblCadastroCampus.setForeground(Color.GRAY);
		lblCadastroCampus.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroCampus.setBounds(203, 1, 211, 28);
		contentPane.add(lblCadastroCampus);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 48, 617, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton adicionar = new JButton("");
		adicionar.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_add.png")));
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				adicionarActionPerformed(evento);
			}

			
		});
		adicionar.setBounds(10, 11, 54, 34);
		panel_1.add(adicionar);
		
		JButton salvar = new JButton("");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				salvarActionPerformed(evento);
			}

			
		});
			
		salvar.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_accept.png")));
		salvar.setBounds(74, 11, 54, 34);
		panel_1.add(salvar);
		
		JButton editar = new JButton("");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				editarActionPerformed(evento);
			}

			
		});
		editar.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_edit.png")));
		editar.setBounds(138, 11, 54, 34);
		panel_1.add(editar);
		
		JButton remover = new JButton("");
		remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				removerActionPerformed(evento);
			}

			
		});
		remover.setIcon(new ImageIcon(Curso.class.getResource("/imagens/page_remove.png")));
		remover.setBounds(202, 11, 54, 34);
		panel_1.add(remover);
		
		JButton primeiro = new JButton("");
		primeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				primeiroActionPerformed(evento);
			}

			
		});
		primeiro.setIcon(new ImageIcon(Curso.class.getResource("/imagens/primeiro.png")));
		primeiro.setBounds(295, 11, 54, 34);
		panel_1.add(primeiro);
		
		JButton anterior = new JButton("");
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				anteriorActionPerformed(evento);
			}

			
		});
		anterior.setIcon(new ImageIcon(Curso.class.getResource("/imagens/anterior.png")));
		anterior.setBounds(359, 11, 54, 34);
		panel_1.add(anterior);
		
		JButton proximo = new JButton("");
		proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				proximoActionPerformed(evento);
			}

			
		});
		proximo.setIcon(new ImageIcon(Curso.class.getResource("/imagens/proximo.png")));
		proximo.setBounds(423, 11, 54, 34);
		panel_1.add(proximo);
		
		JButton ultimo = new JButton("");
		ultimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				ultimoActionPerformed(evento);
			}

			
		});
		ultimo.setIcon(new ImageIcon(Curso.class.getResource("/imagens/ultimo.png")));
		ultimo.setBounds(487, 11, 54, 34);
		panel_1.add(ultimo);
		
		JButton sair = new JButton("");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				sairActionPerformed(evento);
			}

			
		});
		sair.setIcon(new ImageIcon(Curso.class.getResource("/imagens/process_remove.png")));
		sair.setBounds(551, 11, 54, 34);
		panel_1.add(sair);
	}
	
	private void adicionarActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	
	private void salvarActionPerformed(ActionEvent evento) {
		
		ModelCampus modeloCampus = new ModelCampus();
		modeloCampus.setNomeCampus(nomeCampus.getText());
		
		ControllerCampus controleCampus = new ControllerCampus();
		controleCampus.inserirCampus(modeloCampus);
		
	}
	
	private void editarActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	
	private void removerActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	
	private void primeiroActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	
	private void anteriorActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	private void proximoActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	
	private void ultimoActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	private void sairActionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}
	}

