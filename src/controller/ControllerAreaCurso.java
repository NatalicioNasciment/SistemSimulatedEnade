package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConectaBanco;
import model.ModelAreaCurso;

public class ControllerAreaCurso {

	ConectaBanco conecta = new ConectaBanco();
	
	public void inserirAreaCurso(ModelAreaCurso modeloAreaCurso){
		conecta.conexao();
		try {
			
			PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO area_curso (area) VALUES(?)");
			pst.setString(1, modeloAreaCurso.getAreaCurso());
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Area cadastrada com sucesso!!!");
			
		}catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar area!!! "+ ex.getMessage());
		}
	}
}
