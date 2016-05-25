package controller;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import model.ConectaBanco;
import model.ModelCampus;

public class ControllerCampus {
	
	ConectaBanco conecta = new ConectaBanco();
	
	public void inserirCampus(ModelCampus modeloCampus){
		try {
			conecta.conexao();
			
			PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO campus(campus) VALUES(?)");
			
			pst.setString(1, modeloCampus.getNomeCampus());
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Campus Cadastrado com sucesso!!!");
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error ao tentar cadastrar campus!!! "+ex.getMessage());
		}
	}

}
