package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConectaBanco;
import model.ModelAluno;

public class ControllerAluno {
	
	ConectaBanco conecta = new ConectaBanco();
	
	public void inserirAluno(ModelAluno modeloAluno){
		
		conecta.conexao();
		try {
			
			PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO usuario(matricula_usuario, nome_usuario, id_curso, categoria_usuario) VALUES(?,?,?,?)");
			pst.setInt(1, modeloAluno.getMatricula());
			pst.setString(2, modeloAluno.getNome());
			pst.setInt(3, modeloAluno.getId_curso());
			pst.setString(4, modeloAluno.getCategoria());
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Aluno Cadastrado com sucesso!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
