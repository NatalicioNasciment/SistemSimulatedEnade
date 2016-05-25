package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConectaBanco;
import model.ModelCurso;

public class ControllerCurso {
	
	ConectaBanco conecta = new ConectaBanco();
	
	public void inserirCurso(ModelCurso modeloCurso ){
		
		conecta.conexao();
		try {			
			PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO curso (nome_curso, id_campus, id_area)" + " VALUES(?,?,?)");

			pst.setString(1, modeloCurso.getNome());
			pst.setInt(2, modeloCurso.getCampus());
			pst.setInt(3, modeloCurso.getArea());
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!!!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar curso");
		}
	}
	
	
	
	
}
