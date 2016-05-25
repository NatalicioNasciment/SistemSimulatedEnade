package model;

import java.sql.*;

import javax.swing.JOptionPane;
/**
 *
 * @author Grupo Ctrlb
 */
public class ConectaBanco {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/SistemSimuledEnade";
    private String usuario = "postgres";
    private String senha = "root";
    public Connection conn;
    
    public void conexao(){
    
        try {
           
            System.getProperty("jdbc.Drives",driver);
            conn = DriverManager.getConnection(caminho, usuario, senha); 
            //JOptionPane.showMessageDialog(null,"Conectado com sucesso");
            
        } catch (Exception e) {
            
           //JOptionPane.showMessageDialog(null,"Erro ao conectar" + e.getMessage());
        }
    
    }
    
 public void executaSQL (String sql){
        
        try {
            
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (Exception e) {
        }
    }
    
    public void desconecta(){
    
        try {
            
            conn.close();
            JOptionPane.showMessageDialog(null,"Sucesso ao desconectar");
            
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null,"Erro ao tentar desconectar");
            
        }
    
    }
   
}
